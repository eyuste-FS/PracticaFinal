package com.practicafinal.api.models.response;

import com.practicafinal.api.embeddables.EmpleadosProyectoId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "PR_EMPLEADOS_PROYECTO")
public class EmpleadosProyecto {

    @EmbeddedId
    private EmpleadosProyectoId empleadosProyectoId;

    @Column(name = "F_ALTA", columnDefinition = "DATE")
    private LocalDate fAlta;

    public EmpleadosProyecto() {
    }

    public EmpleadosProyecto(EmpleadosProyectoId empleadosProyectoId, LocalDate fAlta) {
        this.empleadosProyectoId = empleadosProyectoId;
        this.fAlta = fAlta;
    }

    public EmpleadosProyectoId getEmpleadosProyectoId() {
        return empleadosProyectoId;
    }

    public void setEmpleadosProyectoId(EmpleadosProyectoId empleadosProyectoId) {
        this.empleadosProyectoId = empleadosProyectoId;
    }

    public LocalDate getfAlta() {
        return fAlta;
    }

    public void setfAlta(LocalDate fAlta) {
        this.fAlta = fAlta;
    }

    @Override
    public String toString() {
        return "EmpleadosProyecto{" +
                "empleadosProyectoId=" + empleadosProyectoId +
                ", fAlta=" + fAlta +
                '}';
    }
}
