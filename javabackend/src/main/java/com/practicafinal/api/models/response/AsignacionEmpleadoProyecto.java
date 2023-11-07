package com.practicafinal.api.models.response;

import java.time.LocalDate;

public class AsignacionEmpleadoProyecto {

    private Empleado empleado;

    private LocalDate fAlta;

    private Long idProyecto;

    private boolean asignado;


    public AsignacionEmpleadoProyecto(EmpleadosProyecto empleadosProyecto) {
        this.empleado = empleadosProyecto.getEmpleadosProyectoId().getIdEmpleado();
        this.fAlta = empleadosProyecto.getfAlta();
        this.idProyecto = empleadosProyecto.getEmpleadosProyectoId().getIdProyecto().getIdProyecto();
        this.asignado = true;
    }

    public AsignacionEmpleadoProyecto(Empleado empleado, LocalDate fAlta, Long idProyecto, boolean asignado) {
        this.empleado = empleado;
        this.fAlta = fAlta;
        this.idProyecto = idProyecto;
        this.asignado = asignado;
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

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }
}
