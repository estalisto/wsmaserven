package com.maserven.modelos;
// Generated Nov 20, 2017 3:07:33 PM by Hibernate Tools 4.3.1



/**
 * ScgMensajesAdj generated by hbm2java
 */
public class ScgMensajesAdj  implements java.io.Serializable {


     private ScgMensajesAdjId id;
     private ScgMensajes scgMensajes;
     private String scgFilNombre;
     private String scgFilExtension;
     private byte[] scgFilObjeto;

    public ScgMensajesAdj() {
    }

    public ScgMensajesAdj(ScgMensajesAdjId id, ScgMensajes scgMensajes, String scgFilNombre, String scgFilExtension, byte[] scgFilObjeto) {
       this.id = id;
       this.scgMensajes = scgMensajes;
       this.scgFilNombre = scgFilNombre;
       this.scgFilExtension = scgFilExtension;
       this.scgFilObjeto = scgFilObjeto;
    }
   
    public ScgMensajesAdjId getId() {
        return this.id;
    }
    
    public void setId(ScgMensajesAdjId id) {
        this.id = id;
    }
    public ScgMensajes getScgMensajes() {
        return this.scgMensajes;
    }
    
    public void setScgMensajes(ScgMensajes scgMensajes) {
        this.scgMensajes = scgMensajes;
    }
    public String getScgFilNombre() {
        return this.scgFilNombre;
    }
    
    public void setScgFilNombre(String scgFilNombre) {
        this.scgFilNombre = scgFilNombre;
    }
    public String getScgFilExtension() {
        return this.scgFilExtension;
    }
    
    public void setScgFilExtension(String scgFilExtension) {
        this.scgFilExtension = scgFilExtension;
    }
    public byte[] getScgFilObjeto() {
        return this.scgFilObjeto;
    }
    
    public void setScgFilObjeto(byte[] scgFilObjeto) {
        this.scgFilObjeto = scgFilObjeto;
    }




}


