package com.practicafinal.api.models.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ActualizacionAsignacionModelRequest {

    @NotNull
    private List<Long> empleadosBaja;
    @NotNull
    private List<Long> empleadosAlta;

    public ActualizacionAsignacionModelRequest() {
    }

    public ActualizacionAsignacionModelRequest(List<Long> empleadosBaja, List<Long> empleadosAlta) {
        this.empleadosBaja = empleadosBaja;
        this.empleadosAlta = empleadosAlta;
    }

    public List<Long> getEmpleadosBaja() {
        return empleadosBaja;
    }

    public void setEmpleadosBaja(List<Long> empleadosBaja) {
        this.empleadosBaja = empleadosBaja;
    }

    public List<Long> getEmpleadosAlta() {
        return empleadosAlta;
    }

    public void setEmpleadosAlta(List<Long> empleadosAlta) {
        this.empleadosAlta = empleadosAlta;
    }

    @Override
    public String toString() {
        return "ActualizacionAsignacionModelRequest{" +
                "empleadosBaja=" + empleadosBaja +
                ", empleadosAlta=" + empleadosAlta +
                '}';
    }
}
