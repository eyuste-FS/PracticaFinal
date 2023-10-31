package com.practicafinal.api.embeddables;

import com.practicafinal.api.models.response.Empleado;
import com.practicafinal.api.models.response.Proyecto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Embeddable
public class EmpleadosProyectoId {

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "ID_EMPLEADO", nullable = false)
    private Empleado idEmpleado;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
    private Proyecto idProyecto;

    public EmpleadosProyectoId(Empleado idEmpleado, Proyecto idProyecto) {
        this.idEmpleado = idEmpleado;
        this.idProyecto = idProyecto;
    }

    public EmpleadosProyectoId() {
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "EmpleadosProyectoId{" +
                "idEmpleado=" + idEmpleado +
                ", idProyecto=" + idProyecto +
                '}';
    }
}
