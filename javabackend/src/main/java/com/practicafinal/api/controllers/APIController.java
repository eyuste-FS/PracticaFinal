package com.practicafinal.api.controllers;

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
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "sort", defaultValue = "") String sort){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/proyecto")
    public ResponseEntity<List<Proyecto>> getProyectosSinBaja(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "sort", defaultValue = "") String sort){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/proyecto/{proyecto_id}/empleado/")
    public ResponseEntity<List<EmpleadosProyecto>> getEmpleadosProyecto(
            @PathVariable int proyecto_id){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
    * POST
    * */

    @PostMapping(path = "proyecto/{proyecto_id}/empleado/{empleado_id}")
    public ResponseEntity<EmpleadosProyecto> postAsignarEmpleadoProyecto(
            @PathVariable int proyecto_id,
            @PathVariable int empleado_id){
        //TODO
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
