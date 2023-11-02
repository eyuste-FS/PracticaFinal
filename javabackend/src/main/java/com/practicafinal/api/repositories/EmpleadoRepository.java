package com.practicafinal.api.repositories;

import com.practicafinal.api.models.response.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query(value = "select e from EM_EMPLEADOS where F_BAJA is NULL order by ID_EMPLEADO limit 10 offset (?1 * 10)")
    List<Empleado> getEmpleados(int page);

    @Query(value = "select e from EM_EMPLEADOS where F_BAJA is NULL order by ID_EMPLEADO limit 10")
    List<Empleado> getEmpleados();
}
