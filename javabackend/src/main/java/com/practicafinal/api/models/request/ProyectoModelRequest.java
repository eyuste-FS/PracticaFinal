package com.practicafinal.api.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProyectoModelRequest {

    @NotNull
    @Size(min = 1, max = 125)
    private String descripcion;

    @NotNull
    private LocalDate fechaInicio;

    @NotNull
    private LocalDate fechaFinal;

    @NotNull
    @Size(min = 1, max = 30)
    private String lugar;

    @NotNull
    @Size(min = 1, max = 300)
    private String observaciones;

    public ProyectoModelRequest() {
    }

    public ProyectoModelRequest(String descripcion, LocalDate fechaInicio, LocalDate fechaFinal, String lugar, String observaciones) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "ProyectoModelRequest{" +
                "descripcion='" + descripcion + '\'' +
                ", fecha_inicio=" + fechaInicio +
                ", fecha_final=" + fechaFinal +
                ", lugar='" + lugar + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}

/*
- descripcion
- fecha_inicio
- fecha_final
- lugar
- observaciones
*/