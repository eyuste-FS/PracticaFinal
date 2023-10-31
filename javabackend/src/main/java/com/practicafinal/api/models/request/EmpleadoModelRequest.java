package com.practicafinal.api.models.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmpleadoModelRequest {

    @NotNull
    private String nif;
    @NotNull
    private String nombre;
    @NotNull
    private String primerApellido;
    @NotNull
    private String segundoApellido;
    @NotNull
    private LocalDate fechaNacimiento;
    @NotNull
    private LocalDate fechaAlta;
    @NotNull
    private String telefono1;
    @NotNull
    private String telefono2;
    @NotNull
    private String email;
    @NotNull
    private String estadoCivil;
    @NotNull
    private String servicioMilitar;

    public EmpleadoModelRequest(
            String nif, String nombre, String primerApellido,
            String segundoApellido, LocalDate fechaNacimiento,
            LocalDate fechaAlta, String telefono1, String telefono2,
            String email, String estadoCivil, String servicioMilitar) {

        this.nif = nif;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.servicioMilitar = servicioMilitar;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getServicioMilitar() {
        return servicioMilitar;
    }

    public void setServicioMilitar(String servicioMilitar) {
        this.servicioMilitar = servicioMilitar;
    }

    @Override
    public String toString() {
        return "EmpleadoModelRequest{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaAlta=" + fechaAlta +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", email='" + email + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", servicioMilitar='" + servicioMilitar + '\'' +
                '}';
    }
}

    /*
    - nif
    - nombre
    - primerApellido
    - segundoApellido
    - fechaNacimiento
    - fechaAlta
    - telefono1
    - telefono2
    - email
    - estadoCivil [Soltero/Casado]
        - servicioMilitar [Si/No]
    */