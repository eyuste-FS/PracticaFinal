package com.practicafinal.api.models.response;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "EM_EMPLEADOS")
@Table(name = "EM_EMPLEADOS")
public class Empleado {

    @Id
    @SequenceGenerator(name = "empleado-sequence", sequenceName = "empleado-sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado-sequence")
    @Column(name = "ID_EMPLEADO", nullable = false, updatable = false, columnDefinition = "INT(7)")
    private Long idEmpleado;

    @Column(name = "TX_NIF", columnDefinition = "VARCHAR(9)")
    private String txNif;

    @Column(name = "TX_NOMBRE", columnDefinition = "VARCHAR(30)", nullable = false)
    private String txNombre;

    @Column(name = "TX_APELLIDO1", columnDefinition = "VARCHAR(40)", nullable = false)
    private String txApellido1;

    @Column(name = "TX_APELLIDO2", columnDefinition = "VARCHAR(40)", nullable = false)
    private String txApellido2;

    @Column(name = "F_NACIMIENTO", columnDefinition = "DATE", nullable = false)
    private LocalDate fNacimiento;

    @Column(name = "N_TELEFONO1", columnDefinition = "VARCHAR(12)", nullable = false)
    private String nTelefono1;

    @Column(name = "N_TELEFONO2", columnDefinition = "VARCHAR(12)", nullable = false)
    private String nTelefono2;

    @Column(name = "TX_EMAIL", columnDefinition = "VARCHAR(40)", nullable = false)
    private String txEmail;

    @Column(name = "F_ALTA", columnDefinition = "DATE", nullable = false)
    private LocalDate fAlta;

    @Column(name = "F_BAJA", columnDefinition = "DATE")
    private LocalDate fBaja;

    @Column(name = "CX_EDOCIVIL", columnDefinition = "CHAR(1)", nullable = false)
    private char cxEdocivil;

    @Column(name = "B_SERVMILITAR", columnDefinition = "CHAR(1)", nullable = false)
    private char bServmilitar;

    public Empleado() {
    }

    public Empleado(
            String txNif, String txNombre, String txApellido1,
            String txApellido2, LocalDate fNacimiento, String nTelefono1,
            String nTelefono2, String txEmail, LocalDate fAlta,
            LocalDate fBaja, char cxEdocivil, char bServmilitar) {

        this.txNif = txNif;
        this.txNombre = txNombre;
        this.txApellido1 = txApellido1;
        this.txApellido2 = txApellido2;
        this.fNacimiento = fNacimiento;
        this.nTelefono1 = nTelefono1;
        this.nTelefono2 = nTelefono2;
        this.txEmail = txEmail;
        this.fAlta = fAlta;
        this.fBaja = fBaja;
        this.cxEdocivil = cxEdocivil;
        this.bServmilitar = bServmilitar;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTxNif() {
        return txNif;
    }

    public void setTxNif(String txNif) {
        this.txNif = txNif;
    }

    public String getTxNombre() {
        return txNombre;
    }

    public void setTxNombre(String txNombre) {
        this.txNombre = txNombre;
    }

    public String getTxApellido1() {
        return txApellido1;
    }

    public void setTxApellido1(String txApellido1) {
        this.txApellido1 = txApellido1;
    }

    public String getTxApellido2() {
        return txApellido2;
    }

    public void setTxApellido2(String txApellido2) {
        this.txApellido2 = txApellido2;
    }

    public LocalDate getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getNTelefono1() {
        return nTelefono1;
    }

    public void setNTelefono1(String nTelefono1) {
        this.nTelefono1 = nTelefono1;
    }

    public String getNTelefono2() {
        return nTelefono2;
    }

    public void setNTelefono2(String nTelefono2) {
        this.nTelefono2 = nTelefono2;
    }

    public String getTxEmail() {
        return txEmail;
    }

    public void setTxEmail(String txEmail) {
        this.txEmail = txEmail;
    }

    public LocalDate getFAlta() {
        return fAlta;
    }

    public void setFAlta(LocalDate fAlta) {
        this.fAlta = fAlta;
    }

    public LocalDate getFBaja() {
        return fBaja;
    }

    public void setFBaja(LocalDate fBaja) {
        this.fBaja = fBaja;
    }

    public char getCxEdocivil() {
        return cxEdocivil;
    }

    public void setCxEdocivil(char cxEdocivil) {
        this.cxEdocivil = cxEdocivil;
    }

    public char getBServmilitar() {
        return bServmilitar;
    }

    public void setBServmilitar(char bServmilitar) {
        this.bServmilitar = bServmilitar;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", txNif='" + txNif + '\'' +
                ", txNombre='" + txNombre + '\'' +
                ", txApellido1='" + txApellido1 + '\'' +
                ", txApellido2='" + txApellido2 + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", nTelefono1='" + nTelefono1 + '\'' +
                ", nTelefono2='" + nTelefono2 + '\'' +
                ", txEmail='" + txEmail + '\'' +
                ", fAlta=" + fAlta +
                ", fBaja=" + fBaja +
                ", cxEdocivil=" + cxEdocivil +
                ", bServmilitar=" + bServmilitar +
                '}';
    }
}

/*
   ID_EMPLEADO 				INT(7) AUTO_INCREMENT PRIMARY KEY NOT NULL,
   TX_NIF 					VARCHAR(9),
   TX_NOMBRE 				VARCHAR(30) NOT NULL,
   TX_APELLIDO1 			VARCHAR(40) NOT NULL,
   TX_APELLIDO2 			VARCHAR(40) NOT NULL,
   F_NACIMIENTO				DATE  NOT NULL,
   N_TELEFONO1 				VARCHAR(12) NOT NULL,
   N_TELEFONO2 				VARCHAR(12) NOT NULL,
   TX_EMAIL 				VARCHAR(40) NOT NULL,
   F_ALTA 					DATE  NOT NULL,
   F_BAJA					DATE,
   CX_EDOCIVIL 				CHAR(1) NOT NULL,
   B_SERVMILITAR 			CHAR(1) NOT NULL
*/