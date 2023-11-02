package com.practicafinal.api.models.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProyectoModelRequest {

    @NotNull
    private String descripcion;

    @NotNull
    private LocalDate fecha_inicio;

    private LocalDate fecha_final;

    @NotNull
    private String lugar;

    @NotNull
    private String observaciones;

    public ProyectoModelRequest() {
    }

    public ProyectoModelRequest(String descripcion, LocalDate fecha_inicio, LocalDate fecha_final, String lugar, String observaciones) {
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.lugar = lugar;
        this.observaciones = observaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
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
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_final=" + fecha_final +
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