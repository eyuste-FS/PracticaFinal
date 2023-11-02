package com.practicafinal.api.models.response;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PR_PROYECTO")
public class Proyecto {

    @Id
    @SequenceGenerator(name = "proyecto-sequence", sequenceName = "proyecto-sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proyecto-sequence")
    @Column(name = "ID_PROYECTO", nullable = false, updatable = false, columnDefinition = "INT(5)")
    private Long idProyecto;

    @Column(name = "TX_DESCRIPCION", columnDefinition = "VARCHAR(125)", nullable = false)
    private String txDescripcion;

    @Column(name = "F_INICIO", columnDefinition = "DATE", nullable = false)
    private LocalDate fInicio;

    @Column(name = "F_FIN", columnDefinition = "DATE")
    private LocalDate fFin;

    @Column(name = "F_BAJA", columnDefinition = "DATE")
    private LocalDate fBaja;

    @Column(name = "TX_LUGAR", columnDefinition = "VARCHAR(30)")
    private String txLugar;

    @Column(name = "TX_OBSERVACIONES", columnDefinition = "VARCHAR(300)")
    private String txObservaciones;

    public Proyecto() {
    }

    public Proyecto(String txDescripcion, LocalDate fInicio, LocalDate fFin, LocalDate fBaja, String txLugar, String txObservaciones) {
        this.txDescripcion = txDescripcion;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.fBaja = fBaja;
        this.txLugar = txLugar;
        this.txObservaciones = txObservaciones;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getTxDescripcion() {
        return txDescripcion;
    }

    public void setTxDescripcion(String txDescripcion) {
        this.txDescripcion = txDescripcion;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFin() {
        return fFin;
    }

    public void setfFin(LocalDate fFin) {
        this.fFin = fFin;
    }

    public LocalDate getfBaja() {
        return fBaja;
    }

    public void setfBaja(LocalDate fBaja) {
        this.fBaja = fBaja;
    }

    public String getTxLugar() {
        return txLugar;
    }

    public void setTxLugar(String txLugar) {
        this.txLugar = txLugar;
    }

    public String getTxObservaciones() {
        return txObservaciones;
    }

    public void setTxObservaciones(String txObservaciones) {
        this.txObservaciones = txObservaciones;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "idProyecto=" + idProyecto +
                ", txDescripcion='" + txDescripcion + '\'' +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                ", fBaja=" + fBaja +
                ", txLugar='" + txLugar + '\'' +
                ", txObservaciones='" + txObservaciones + '\'' +
                '}';
    }
}

/*
   ID_PROYECTO 				INT(5) AUTO_INCREMENT PRIMARY KEY NOT NULL,
   TX_DESCRIPCIÓN 			VARCHAR(125) NOT NULL,
   F_INICIO 				DATE NOT NULL,
   F_FIN 					DATE,
   F_BAJA					DATE,
   TX_LUGAR 				VARCHAR(30),
   TX_OBSERVACIONES 		VARCHAR(300)
*/
