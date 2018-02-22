package com.maserven.modelos;
// Generated Nov 20, 2017 3:07:33 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * ScgPerfilesCab generated by hbm2java
 */
public class ScgPerfilesCab  implements java.io.Serializable {


     private String scgPerCodigo;
     private String scgPerDescripcion;
     private char scgPerEstado;
     private boolean scgPerPendiente;
     private Set scgPerfilesDets = new HashSet(0);
     private Set scgUsuariosEprs = new HashSet(0);

    public ScgPerfilesCab() {
    }

	
    public ScgPerfilesCab(String scgPerCodigo, String scgPerDescripcion, char scgPerEstado, boolean scgPerPendiente) {
        this.scgPerCodigo = scgPerCodigo;
        this.scgPerDescripcion = scgPerDescripcion;
        this.scgPerEstado = scgPerEstado;
        this.scgPerPendiente = scgPerPendiente;
    }
    public ScgPerfilesCab(String scgPerCodigo, String scgPerDescripcion, char scgPerEstado, boolean scgPerPendiente, Set scgPerfilesDets, Set scgUsuariosEprs) {
       this.scgPerCodigo = scgPerCodigo;
       this.scgPerDescripcion = scgPerDescripcion;
       this.scgPerEstado = scgPerEstado;
       this.scgPerPendiente = scgPerPendiente;
       this.scgPerfilesDets = scgPerfilesDets;
       this.scgUsuariosEprs = scgUsuariosEprs;
    }
   
    public String getScgPerCodigo() {
        return this.scgPerCodigo;
    }
    
    public void setScgPerCodigo(String scgPerCodigo) {
        this.scgPerCodigo = scgPerCodigo;
    }
    public String getScgPerDescripcion() {
        return this.scgPerDescripcion;
    }
    
    public void setScgPerDescripcion(String scgPerDescripcion) {
        this.scgPerDescripcion = scgPerDescripcion;
    }
    public char getScgPerEstado() {
        return this.scgPerEstado;
    }
    
    public void setScgPerEstado(char scgPerEstado) {
        this.scgPerEstado = scgPerEstado;
    }
    public boolean isScgPerPendiente() {
        return this.scgPerPendiente;
    }
    
    public void setScgPerPendiente(boolean scgPerPendiente) {
        this.scgPerPendiente = scgPerPendiente;
    }
    public Set getScgPerfilesDets() {
        return this.scgPerfilesDets;
    }
    
    public void setScgPerfilesDets(Set scgPerfilesDets) {
        this.scgPerfilesDets = scgPerfilesDets;
    }
    public Set getScgUsuariosEprs() {
        return this.scgUsuariosEprs;
    }
    
    public void setScgUsuariosEprs(Set scgUsuariosEprs) {
        this.scgUsuariosEprs = scgUsuariosEprs;
    }




}


