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

        List<Empleado> empleados = empleadoRepository.getEmpleados(page);

        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto")
    public ResponseEntity<List<Proyecto>> getProyectosSinBaja(
            @RequestParam(name = "page", defaultValue = "0") int page){

        if (page < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Proyecto> proyectos = proyectoRepository.getProyectos(page);

        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping(path = "/proyecto/{proyecto_id}/empleado/")
    public ResponseEntity<List<EmpleadosProyecto>> getEmpleadosProyecto(
            @PathVariable Long proyecto_id){

        List<EmpleadosProyecto> empleadosProyecto = empleadosProyectoRepository.getAsignacion(proyecto_id);

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

        ArrayList<EmpleadosProyecto> altas = new ArrayList<>();
        for (Long alta: asignacion.getEmpleadosAlta()){
            try{
                boolean existia = true;
                Empleado empleado = empleadoRepository.getReferenceById(alta);
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
        for (Long baja: asignacion.getEmpleadosAlta()){
            try{
                Empleado empleado = empleadoRepository.getReferenceById(baja);
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
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/proyecto")
    public ResponseEntity<Proyecto> putProyecto(
            @Validated @RequestBody ProyectoModelRequest proyectoModelRequest){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /*
    * DELETE
    * */

    @DeleteMapping(path = "/empleado/{empleado_id}")
    public ResponseEntity<Empleado> deleteEmpleado(
            @PathVariable int empleado_id){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/proyecto/{proyecto_id}")
    public ResponseEntity<Proyecto> deleteProyecto(
            @PathVariable int proyecto_id){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
