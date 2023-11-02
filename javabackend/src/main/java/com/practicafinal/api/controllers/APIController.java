package com.practicafinal.api.controllers;

import com.practicafinal.api.embeddables.EmpleadosProyectoId;
import com.practicafinal.api.models.request.ActualizacionAsignacionModelRequest;
import com.practicafinal.api.models.request.EmpleadoModelRequest;
import com.practicafinal.api.models.request.ProyectoModelRequest;
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
@RequestMapping(path="/")
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
            @RequestParam(name = "page", defaultValue = "0") int page){

        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Empleado> empleados = empleadoRepository.getEmpleados(10, page * 10);

        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto")
    public ResponseEntity<List<Proyecto>> getProyectosSinBaja(
            @RequestParam(name = "page", defaultValue = "0") int page){

        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Proyecto> proyectos = proyectoRepository.getProyectos(10, 10 *page);

        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto/{proyecto_id}/empleado/")
    public ResponseEntity<List<EmpleadosProyecto>> getEmpleadosProyecto(
            @PathVariable Long proyecto_id){

        List<EmpleadosProyecto> empleadosProyecto = empleadosProyectoRepository.getAsignacionProyecto(proyecto_id);

        return new ResponseEntity<>(empleadosProyecto, HttpStatus.OK);
    }

    /*
    * POST
    * */

    @PostMapping(path = "proyecto/{proyecto_id}/empleado/")
    public ResponseEntity postAsignarEmpleadoProyecto(
            @PathVariable Long proyecto_id,
            @Validated @RequestBody ActualizacionAsignacionModelRequest asignacion){

        Proyecto proyecto = proyectoRepository.getReferenceById(proyecto_id);
        if (proyecto.getfBaja() != null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        ArrayList<EmpleadosProyecto> altas = new ArrayList<>();
        for (Long alta: asignacion.getEmpleadosAlta()){
            try{
                boolean existia = true;
                Empleado empleado = empleadoRepository.getReferenceById(alta);

                if (empleado.getFBaja() != null){
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }

                EmpleadosProyectoId nuevaAsignacion = new EmpleadosProyectoId(empleado, proyecto);

                try{ // Comprobar si ya existia
                    empleadosProyectoRepository.getReferenceById(nuevaAsignacion);
                }catch (Exception exception){
                    existia = false;
                }

                if (existia){
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }

                altas.add(new EmpleadosProyecto(nuevaAsignacion, LocalDate.now()));
            } catch (Exception exception){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        ArrayList<EmpleadosProyecto> bajas = new ArrayList<>();
        for (Long baja: asignacion.getEmpleadosBaja()){
            try{
                Empleado empleado = empleadoRepository.getReferenceById(baja);

                if (empleado.getFBaja() != null){
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }

                EmpleadosProyecto ep =  empleadosProyectoRepository.getReferenceById(
                        new EmpleadosProyectoId(empleado, proyecto));
                bajas.add(ep);
            } catch (Exception exception){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        empleadosProyectoRepository.saveAll(altas);
        empleadosProyectoRepository.deleteAll(bajas);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    * PUT
    * */

    @PutMapping(path = "/empleado")
    public ResponseEntity<Empleado> putEmpleado(
            @Validated @RequestBody EmpleadoModelRequest empleadoModelRequest){

        char edoCivil = ' ';
        String edoCivilStr = empleadoModelRequest.getEstadoCivil();
        if (edoCivilStr.equals("Casado")) {
            edoCivil = 'C';
        } else if (edoCivilStr.equals("Soltero")) {
            edoCivil = 'S';
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        char sMilitar = ' ';
        String sMilitarStr = empleadoModelRequest.getServicioMilitar();
        if (sMilitarStr.equals("No")) {
            sMilitar = 'N';
        } else if (sMilitarStr.equals("Si")) {
            sMilitar = 'S';
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

        try{
            empleadoRepository.save(nuevoEmpleado);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.OK);
    }

    @PutMapping(path = "/proyecto")
    public ResponseEntity<Proyecto> putProyecto(
            @Validated @RequestBody ProyectoModelRequest proyectoModelRequest){

        Proyecto nuevoProyecto = new Proyecto(
                proyectoModelRequest.getDescripcion(),
                proyectoModelRequest.getFecha_inicio(),
                proyectoModelRequest.getFecha_final(),
                null,
                proyectoModelRequest.getLugar(),
                proyectoModelRequest.getObservaciones());

        try{
            proyectoRepository.save(nuevoProyecto);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(nuevoProyecto, HttpStatus.OK);
    }


    /*
    * DELETE
    * */

    @DeleteMapping(path = "/empleado/{empleado_id}")
    public ResponseEntity<String> deleteEmpleado(
            @PathVariable Long empleado_id){

        Empleado empleado = null;
        try{
             empleado = empleadoRepository.getReferenceById(empleado_id);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<EmpleadosProyecto> proyectos = empleadosProyectoRepository.getAsignacionEmpleado(empleado_id);
        if(proyectos.size() > 0){
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

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/proyecto/{proyecto_id}")
    public ResponseEntity<String> deleteProyecto(
            @PathVariable Long proyecto_id){

        Proyecto proyecto = null;
        try{
            proyecto = proyectoRepository.getReferenceById(proyecto_id);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(empleadosProyectoRepository.getAsignacionProyecto(proyecto_id).size() > 0){
            String err = String.format(
                    "No se puede dar de baja el proyecto %s porque tiene asignado al menos un recurso",
                    proyecto.getTxDescripcion());
            return new ResponseEntity<>(err, HttpStatus.CONFLICT);
        }

        proyecto.setfBaja(LocalDate.now());
        proyectoRepository.save(proyecto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
