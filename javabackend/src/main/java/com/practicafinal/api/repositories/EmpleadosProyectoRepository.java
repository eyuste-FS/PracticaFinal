package com.practicafinal.api.repositories;

import com.practicafinal.api.embeddables.EmpleadosProyectoId;
import com.practicafinal.api.models.response.EmpleadosProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadosProyectoRepository extends JpaRepository<EmpleadosProyecto, EmpleadosProyectoId> {

    @Query(value = "select p from PR_EMPLEADOS_PROYECTO p where p.empleadosProyectoId.idProyecto = ?1")
    List<EmpleadosProyecto> getAsignacionProyecto(Long id_proyecto);

    @Query(value = "select p from PR_EMPLEADOS_PROYECTO p where p.empleadosProyectoId.idEmpleado = ?1")
    List<EmpleadosProyecto> getAsignacionEmpleado(Long id_empleado);
}
