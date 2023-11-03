package com.practicafinal.api.models.response;

import java.time.LocalDate;

public class AsignacionEmpleadoProyecto {

    private Empleado empleado;

    private LocalDate fAlta;

    private Long idProyecto;


    public AsignacionEmpleadoProyecto(EmpleadosProyecto empleadosProyecto) {
        this.empleado = empleadosProyecto.getEmpleadosProyectoId().getIdEmpleado();
        this.fAlta = empleadosProyecto.getfAlta();
        this.idProyecto = empleadosProyecto.getEmpleadosProyectoId().getIdProyecto().getIdProyecto();
    }

    public AsignacionEmpleadoProyecto(Empleado empleado, LocalDate fAlta, Long idProyecto) {
        this.empleado = empleado;
        this.fAlta = fAlta;
        this.idProyecto = idProyecto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getfAlta() {
        return fAlta;
    }

    public void setfAlta(LocalDate fAlta) {
        this.fAlta = fAlta;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }
}
