package com.practicafinal.api.controllers;

import com.practicafinal.api.embeddables.EmpleadosProyectoId;
import com.practicafinal.api.models.request.ActualizacionAsignacionModelRequest;
import com.practicafinal.api.models.request.EmpleadoModelRequest;
import com.practicafinal.api.models.request.ProyectoModelRequest;
import com.practicafinal.api.models.response.AsignacionEmpleadoProyecto;
import com.practicafinal.api.models.response.Empleado;
import com.practicafinal.api.models.response.EmpleadosProyecto;
import com.practicafinal.api.models.response.Proyecto;
import com.practicafinal.api.repositories.EmpleadosProyectoRepository;
import com.practicafinal.api.repositories.EmpleadoRepository;
import com.practicafinal.api.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/")
public class APIController {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    ProyectoRepository proyectoRepository;

    @Autowired
    EmpleadosProyectoRepository empleadosProyectoRepository;

    /*
     * GET
     * */

    @GetMapping(path = "/empleado")
    public ResponseEntity<List<Empleado>> getEmpleadosSinBaja(
            @RequestParam(name = "page", defaultValue = "-1") int page) {

        if (page == -1){
            return new ResponseEntity<>(empleadoRepository.getAllEmpleados(), HttpStatus.OK);
        }

        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Empleado> empleados = empleadoRepository.getEmpleados(10, page * 10);

        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto")
    public ResponseEntity<List<Proyecto>> getProyectosSinBaja(
            @RequestParam(name = "page", defaultValue = "-1") int page) {

        if (page == -1){
            return new ResponseEntity<>(proyectoRepository.getAllProyectos(), HttpStatus.OK);
        }

        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Proyecto> proyectos = proyectoRepository.getProyectos(10, 10 * page);

        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto/{proyecto_id}/empleado")
    public ResponseEntity<List<AsignacionEmpleadoProyecto>> getEmpleadosProyecto(
            @PathVariable Long proyecto_id) {

        if (!proyectoRepository.existsById(proyecto_id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Proyecto proyecto = proyectoRepository.getReferenceById(proyecto_id);
        List<EmpleadosProyecto> empleadosProyecto = empleadosProyectoRepository.getAsignacionProyecto(proyecto);
        List<AsignacionEmpleadoProyecto> asignacionEmpleadoProyecto = empleadosProyecto
                .stream()
                .map(AsignacionEmpleadoProyecto::new)
                .collect(Collectors.toList());

        List<Empleado> empleadosNoProyecto = empleadoRepository.getEmpleadosNotIn(
                asignacionEmpleadoProyecto
                        .stream()
                        .map(AsignacionEmpleadoProyecto::getEmpleado)
                        .collect(Collectors.toList()));
        List<AsignacionEmpleadoProyecto> noAsignacionEmpleadoProyecto = empleadosNoProyecto
                .stream()
                .map(empleado -> {
                    return new AsignacionEmpleadoProyecto(empleado, null, proyecto_id, false);
                })
                .collect(Collectors.toList());
        asignacionEmpleadoProyecto.addAll(noAsignacionEmpleadoProyecto);

        if(asignacionEmpleadoProyecto.size() < 1){
            asignacionEmpleadoProyecto.addAll(
                    empleadoRepository.getAllEmpleados().stream().map(e->{
                        return new AsignacionEmpleadoProyecto(e, null, proyecto_id, false);
                    }).collect(Collectors.toList()));
        }

        return new ResponseEntity<>(asignacionEmpleadoProyecto, HttpStatus.OK);
    }

    /*
     * POST
     * */

    @PostMapping(path = "/proyecto/{proyecto_id}/empleado")
    public ResponseEntity<String> postAsignarEmpleadoProyecto(
            @PathVariable Long proyecto_id,
            @Validated @RequestBody ActualizacionAsignacionModelRequest asignacion) {

        Proyecto proyecto = proyectoRepository.getReferenceById(proyecto_id);
        if (proyecto.getfBaja() != null) {
            return new ResponseEntity("El proyecto está dado de baja", HttpStatus.NOT_FOUND);
        }

        ArrayList<EmpleadosProyecto> altas = new ArrayList<>();
        for (Long alta : asignacion.getEmpleadosAlta()) {
            if (!empleadoRepository.existsById(alta)) {
                return new ResponseEntity<>(
                        String.format("No se ha encontrado ningún empleado con id=%d", alta),
                        HttpStatus.NOT_FOUND);
            }
            Empleado empleado = empleadoRepository.getReferenceById(alta);

            if (empleado.getFBaja() != null) {
                return new ResponseEntity(
                        String.format(
                                "El empleado %s %s %s (id=%d) está dado de baja",
                                empleado.getTxNombre(), empleado.getTxApellido1(),
                                empleado.getTxApellido2(), empleado.getIdEmpleado()),
                        HttpStatus.NOT_FOUND);
            }

            EmpleadosProyectoId nuevaAsignacion = new EmpleadosProyectoId(empleado, proyecto);

            if (empleadosProyectoRepository.existsById(nuevaAsignacion)) {
                return new ResponseEntity<>(
                        String.format(
                                "El empleado %s %s %s (id=%d) ya estaba dado de alta en este proyecto (id=%d)",
                                empleado.getTxNombre(), empleado.getTxApellido1(),
                                empleado.getTxApellido2(), empleado.getIdEmpleado(), proyecto_id),
                        HttpStatus.CONFLICT);
            }

            altas.add(new EmpleadosProyecto(nuevaAsignacion, LocalDate.now()));
        }

        ArrayList<EmpleadosProyecto> bajas = new ArrayList<>();
        for (Long baja : asignacion.getEmpleadosBaja()) {
            if (!empleadoRepository.existsById(baja)) {
                return new ResponseEntity<>(String.format(
                        "No se ha encontrado ningún empleado con id=%d", baja),
                        HttpStatus.NOT_FOUND);
            }
            Empleado empleado = empleadoRepository.getReferenceById(baja);

            if (empleado.getFBaja() != null) {
                return new ResponseEntity(
                        String.format(
                                "El empleado %s %s %s (id=%d) está dado de baja",
                                empleado.getTxNombre(), empleado.getTxApellido1(),
                                empleado.getTxApellido2(), empleado.getIdEmpleado()),
                        HttpStatus.NOT_FOUND);
            }

            EmpleadosProyectoId epid = new EmpleadosProyectoId(empleado, proyecto);
            if (!empleadosProyectoRepository.existsById(epid)) {
                continue;
                /*return new ResponseEntity<>(
                        String.format(
                                "No se ha encontrado ningún empleado con id=%d dado de alta en este proyecto",
                                baja),
                        HttpStatus.NOT_FOUND);*/
            }
            EmpleadosProyecto ep = empleadosProyectoRepository.getReferenceById(epid);
            bajas.add(ep);
        }

        empleadosProyectoRepository.saveAll(altas);
        empleadosProyectoRepository.deleteAll(bajas);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /*
     * PUT
     * */

    @PutMapping(path = "/empleado")
    public ResponseEntity<String> putEmpleado(
            @Validated @RequestBody EmpleadoModelRequest empleadoModelRequest) {

        char edoCivil = ' ';
        String edoCivilStr = empleadoModelRequest.getEstadoCivil();
        if (edoCivilStr.equals("Casado")) {
            edoCivil = 'C';
        } else if (edoCivilStr.equals("Soltero")) {
            edoCivil = 'S';
        } else {
            return new ResponseEntity<>("El estado civil debe ser Soltero o Casado", HttpStatus.BAD_REQUEST);
        }

        char sMilitar = ' ';
        String sMilitarStr = empleadoModelRequest.getServicioMilitar();
        if (sMilitarStr.equals("No")) {
            sMilitar = 'N';
        } else if (sMilitarStr.equals("Si")) {
            sMilitar = 'S';
        } else {
            return new ResponseEntity<>("El servicio militar debe ser Si o No", HttpStatus.BAD_REQUEST);
        }

        Empleado nuevoEmpleado = new Empleado(
                empleadoModelRequest.getNif(),
                empleadoModelRequest.getNombre(),
                empleadoModelRequest.getPrimerApellido(),
                empleadoModelRequest.getSegundoApellido(),
                empleadoModelRequest.getFechaNacimiento(),
                empleadoModelRequest.getTelefono1(),
                empleadoModelRequest.getTelefono2(),
                empleadoModelRequest.getEmail(),
                empleadoModelRequest.getFechaAlta(),
                null,
                edoCivil,
                sMilitar);

        try {
            empleadoRepository.save(nuevoEmpleado);
        } catch (Exception exception) {
            return new ResponseEntity<>("No se pudo dar de alta al empleado por un conflicto", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(nuevoEmpleado.toString(), HttpStatus.OK);
    }

    @PutMapping(path = "/proyecto")
    public ResponseEntity<String> putProyecto(
            @Validated @RequestBody ProyectoModelRequest proyectoModelRequest) {

        Proyecto nuevoProyecto = new Proyecto(
                proyectoModelRequest.getDescripcion(),
                proyectoModelRequest.getFechaInicio(),
                proyectoModelRequest.getFechaFinal(),
                null,
                proyectoModelRequest.getLugar(),
                proyectoModelRequest.getObservaciones());

        try {
            proyectoRepository.save(nuevoProyecto);
        } catch (Exception exception) {
            return new ResponseEntity<>("No se pudo dar de alta al proyecto por un conflicto", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(nuevoProyecto.toString(), HttpStatus.OK);
    }

    /*
     * DELETE
     * */

    @DeleteMapping(path = "/empleado/{empleado_id}")
    public ResponseEntity<String> deleteEmpleado(
            @PathVariable Long empleado_id) {

        Empleado empleado = null;
        try {
            empleado = empleadoRepository.getReferenceById(empleado_id);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<EmpleadosProyecto> proyectos = empleadosProyectoRepository.getAsignacionEmpleado(empleado);
        if (proyectos.size() > 0) {
            String proyectoStr = String.join(
                    ", ",
                    proyectos.stream()
                            .map(EmpleadosProyecto::getEmpleadosProyectoId)
                            .map(EmpleadosProyectoId::getIdProyecto)
                            .map(Proyecto::getTxDescripcion)
                            .collect(Collectors.toList()));
            String err = String.format(
                    "No se puede dar de baja al empleado %s %s %s porque está asignado a el/los proyecto/s %s",
                    empleado.getTxNombre(), empleado.getTxApellido1(), empleado.getTxApellido2(), proyectoStr);
            return new ResponseEntity<>(err, HttpStatus.CONFLICT);
        }

        empleado.setFBaja(LocalDate.now());
        empleadoRepository.save(empleado);

        return new ResponseEntity<>("Empleado dado de baja", HttpStatus.OK);
    }

    @DeleteMapping(path = "/proyecto/{proyecto_id}")
    public ResponseEntity<String> deleteProyecto(
            @PathVariable Long proyecto_id) {

        Proyecto proyecto = null;
        try {
            proyecto = proyectoRepository.getReferenceById(proyecto_id);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (empleadosProyectoRepository.getAsignacionProyecto(proyecto).size() > 0) {
            String err = String.format(
                    "No se puede dar de baja el proyecto %s porque tiene asignado al menos un recurso",
                    proyecto.getTxDescripcion());
            return new ResponseEntity<>(err, HttpStatus.CONFLICT);
        }

        proyecto.setfBaja(LocalDate.now());
        proyectoRepository.save(proyecto);

        return new ResponseEntity<>("Proyecto dado de baja", HttpStatus.OK);
    }

}
