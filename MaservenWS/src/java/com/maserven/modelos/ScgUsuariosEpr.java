package com.maserven.modelos;
// Generated Nov 20, 2017 3:07:33 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ScgUsuariosEpr generated by hbm2java
 */
public class ScgUsuariosEpr  implements java.io.Serializable {


     private ScgUsuariosEprId id;
     private ScgEmpresas scgEmpresas;
     private ScgPerfilesCab scgPerfilesCab;
     private ScgUsuarios scgUsuarios;
     private Date scgUxeActualizaFec;
     private String scgUxeActualizaUsr;
     private Date scgUxeCreacionFec;
     private String scgUxeCreacionUsr;
     private char scgUxeEstado;

    public ScgUsuariosEpr() {
    }

    public ScgUsuariosEpr(ScgUsuariosEprId id, ScgEmpresas scgEmpresas, ScgPerfilesCab scgPerfilesCab, ScgUsuarios scgUsuarios, Date scgUxeActualizaFec, String scgUxeActualizaUsr, Date scgUxeCreacionFec, String scgUxeCreacionUsr, char scgUxeEstado) {
       this.id = id;
       this.scgEmpresas = scgEmpresas;
       this.scgPerfilesCab = scgPerfilesCab;
       this.scgUsuarios = scgUsuarios;
       this.scgUxeActualizaFec = scgUxeActualizaFec;
       this.scgUxeActualizaUsr = scgUxeActualizaUsr;
       this.scgUxeCreacionFec = scgUxeCreacionFec;
       this.scgUxeCreacionUsr = scgUxeCreacionUsr;
       this.scgUxeEstado = scgUxeEstado;
    }
   
    public ScgUsuariosEprId getId() {
        return this.id;
    }
    
    public void setId(ScgUsuariosEprId id) {
        this.id = id;
    }
    public ScgEmpresas getScgEmpresas() {
        return this.scgEmpresas;
    }
    
    public void setScgEmpresas(ScgEmpresas scgEmpresas) {
        this.scgEmpresas = scgEmpresas;
    }
    public ScgPerfilesCab getScgPerfilesCab() {
        return this.scgPerfilesCab;
    }
    
    public void setScgPerfilesCab(ScgPerfilesCab scgPerfilesCab) {
        this.scgPerfilesCab = scgPerfilesCab;
    }
    public ScgUsuarios getScgUsuarios() {
        return this.scgUsuarios;
    }
    
    public void setScgUsuarios(ScgUsuarios scgUsuarios) {
        this.scgUsuarios = scgUsuarios;
    }
    public Date getScgUxeActualizaFec() {
        return this.scgUxeActualizaFec;
    }
    
    public void setScgUxeActualizaFec(Date scgUxeActualizaFec) {
        this.scgUxeActualizaFec = scgUxeActualizaFec;
    }
    public String getScgUxeActualizaUsr() {
        return this.scgUxeActualizaUsr;
    }
    
    public void setScgUxeActualizaUsr(String scgUxeActualizaUsr) {
        this.scgUxeActualizaUsr = scgUxeActualizaUsr;
    }
    public Date getScgUxeCreacionFec() {
        return this.scgUxeCreacionFec;
    }
    
    public void setScgUxeCreacionFec(Date scgUxeCreacionFec) {
        this.scgUxeCreacionFec = scgUxeCreacionFec;
    }
    public String getScgUxeCreacionUsr() {
        return this.scgUxeCreacionUsr;
    }
    
    public void setScgUxeCreacionUsr(String scgUxeCreacionUsr) {
        this.scgUxeCreacionUsr = scgUxeCreacionUsr;
    }
    public char getScgUxeEstado() {
        return this.scgUxeEstado;
    }
    
    public void setScgUxeEstado(char scgUxeEstado) {
        this.scgUxeEstado = scgUxeEstado;
    }




}


