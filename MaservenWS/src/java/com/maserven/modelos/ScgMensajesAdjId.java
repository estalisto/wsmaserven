package com.maserven.modelos;
// Generated Nov 20, 2017 3:07:33 PM by Hibernate Tools 4.3.1



/**
 * ScgMensajesAdjId generated by hbm2java
 */
public class ScgMensajesAdjId  implements java.io.Serializable {


     private short scgMenAnio;
     private String scgUsuCodigo;
     private long scgMenNumero;
     private int scgFilSecuencia;

    public ScgMensajesAdjId() {
    }

    public ScgMensajesAdjId(short scgMenAnio, String scgUsuCodigo, long scgMenNumero, int scgFilSecuencia) {
       this.scgMenAnio = scgMenAnio;
       this.scgUsuCodigo = scgUsuCodigo;
       this.scgMenNumero = scgMenNumero;
       this.scgFilSecuencia = scgFilSecuencia;
    }
   
    public short getScgMenAnio() {
        return this.scgMenAnio;
    }
    
    public void setScgMenAnio(short scgMenAnio) {
        this.scgMenAnio = scgMenAnio;
    }
    public String getScgUsuCodigo() {
        return this.scgUsuCodigo;
    }
    
    public void setScgUsuCodigo(String scgUsuCodigo) {
        this.scgUsuCodigo = scgUsuCodigo;
    }
    public long getScgMenNumero() {
        return this.scgMenNumero;
    }
    
    public void setScgMenNumero(long scgMenNumero) {
        this.scgMenNumero = scgMenNumero;
    }
    public int getScgFilSecuencia() {
        return this.scgFilSecuencia;
    }
    
    public void setScgFilSecuencia(int scgFilSecuencia) {
        this.scgFilSecuencia = scgFilSecuencia;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ScgMensajesAdjId) ) return false;
		 ScgMensajesAdjId castOther = ( ScgMensajesAdjId ) other; 
         
		 return (this.getScgMenAnio()==castOther.getScgMenAnio())
 && ( (this.getScgUsuCodigo()==castOther.getScgUsuCodigo()) || ( this.getScgUsuCodigo()!=null && castOther.getScgUsuCodigo()!=null && this.getScgUsuCodigo().equals(castOther.getScgUsuCodigo()) ) )
 && (this.getScgMenNumero()==castOther.getScgMenNumero())
 && (this.getScgFilSecuencia()==castOther.getScgFilSecuencia());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getScgMenAnio();
         result = 37 * result + ( getScgUsuCodigo() == null ? 0 : this.getScgUsuCodigo().hashCode() );
         result = 37 * result + (int) this.getScgMenNumero();
         result = 37 * result + this.getScgFilSecuencia();
         return result;
   }   


}


