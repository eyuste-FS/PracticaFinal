package com.practicafinal.api.repositories;

import com.practicafinal.api.models.response.Empleado;
import com.practicafinal.api.models.response.EmpleadosProyecto;
import com.practicafinal.api.models.response.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query(value = "select e from EM_EMPLEADOS e where e.fBaja is NULL order by e.idEmpleado limit ?1 offset ?2")
    List<Empleado> getEmpleados(int limit, int offset);

    @Query(value = "select e from EM_EMPLEADOS e where e not in ?1 and e.fBaja is NULL")
    List<Empleado> getEmpleadosNotIn(List<Empleado> empleados);
}
