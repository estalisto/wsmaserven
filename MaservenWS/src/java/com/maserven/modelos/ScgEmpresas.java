package com.maserven.modelos;
// Generated Nov 20, 2017 3:07:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ScgEmpresas generated by hbm2java
 */
public class ScgEmpresas  implements java.io.Serializable {


     private String scgEprCodigo;
     private ScgProvinciasCiu scgProvinciasCiu;
     private String scgEprRuc;
     private char scgEprEstado;
     private String scgEprDescripcion;
     private String scgEprTelefono1;
     private String scgEprTelefono2;
     private String scgEprDireccion;
     private String scgEprPaginaWeb;
     private String scgEprEmail;
     private byte[] scgEprLogo;
     private String scgEprBaseDatos;
     private String scgEprEmailMsj;
     private String scgEprEmailHost;
     private String scgEprCreacionUsr;
     private Date scgEprCreacionFec;
     private String scgEprActualizaUsr;
     private Date scgEprActualizaFec;
     private char scgEprTipoEmp;
     private String scgEprExtension;
     private String scgEprDescripcionCom;
     private String scgEprNumeroCon;
     private boolean scgEprContribuyenteEsp;
     private boolean scgEprVentasTra;
     private Set scgUsuariosEprs = new HashSet(0);

    public ScgEmpresas() {
    }

	
    public ScgEmpresas(String scgEprCodigo, ScgProvinciasCiu scgProvinciasCiu, String scgEprRuc, char scgEprEstado, String scgEprDescripcion, String scgEprTelefono1, String scgEprTelefono2, String scgEprDireccion, String scgEprPaginaWeb, String scgEprEmail, String scgEprBaseDatos, String scgEprEmailMsj, String scgEprEmailHost, String scgEprCreacionUsr, Date scgEprCreacionFec, String scgEprActualizaUsr, Date scgEprActualizaFec, char scgEprTipoEmp, String scgEprDescripcionCom, boolean scgEprContribuyenteEsp, boolean scgEprVentasTra) {
        this.scgEprCodigo = scgEprCodigo;
        this.scgProvinciasCiu = scgProvinciasCiu;
        this.scgEprRuc = scgEprRuc;
        this.scgEprEstado = scgEprEstado;
        this.scgEprDescripcion = scgEprDescripcion;
        this.scgEprTelefono1 = scgEprTelefono1;
        this.scgEprTelefono2 = scgEprTelefono2;
        this.scgEprDireccion = scgEprDireccion;
        this.scgEprPaginaWeb = scgEprPaginaWeb;
        this.scgEprEmail = scgEprEmail;
        this.scgEprBaseDatos = scgEprBaseDatos;
        this.scgEprEmailMsj = scgEprEmailMsj;
        this.scgEprEmailHost = scgEprEmailHost;
        this.scgEprCreacionUsr = scgEprCreacionUsr;
        this.scgEprCreacionFec = scgEprCreacionFec;
        this.scgEprActualizaUsr = scgEprActualizaUsr;
        this.scgEprActualizaFec = scgEprActualizaFec;
        this.scgEprTipoEmp = scgEprTipoEmp;
        this.scgEprDescripcionCom = scgEprDescripcionCom;
        this.scgEprContribuyenteEsp = scgEprContribuyenteEsp;
        this.scgEprVentasTra = scgEprVentasTra;
    }
    public ScgEmpresas(String scgEprCodigo, ScgProvinciasCiu scgProvinciasCiu, String scgEprRuc, char scgEprEstado, String scgEprDescripcion, String scgEprTelefono1, String scgEprTelefono2, String scgEprDireccion, String scgEprPaginaWeb, String scgEprEmail, byte[] scgEprLogo, String scgEprBaseDatos, String scgEprEmailMsj, String scgEprEmailHost, String scgEprCreacionUsr, Date scgEprCreacionFec, String scgEprActualizaUsr, Date scgEprActualizaFec, char scgEprTipoEmp, String scgEprExtension, String scgEprDescripcionCom, String scgEprNumeroCon, boolean scgEprContribuyenteEsp, boolean scgEprVentasTra, Set scgUsuariosEprs) {
       this.scgEprCodigo = scgEprCodigo;
       this.scgProvinciasCiu = scgProvinciasCiu;
       this.scgEprRuc = scgEprRuc;
       this.scgEprEstado = scgEprEstado;
       this.scgEprDescripcion = scgEprDescripcion;
       this.scgEprTelefono1 = scgEprTelefono1;
       this.scgEprTelefono2 = scgEprTelefono2;
       this.scgEprDireccion = scgEprDireccion;
       this.scgEprPaginaWeb = scgEprPaginaWeb;
       this.scgEprEmail = scgEprEmail;
       this.scgEprLogo = scgEprLogo;
       this.scgEprBaseDatos = scgEprBaseDatos;
       this.scgEprEmailMsj = scgEprEmailMsj;
       this.scgEprEmailHost = scgEprEmailHost;
       this.scgEprCreacionUsr = scgEprCreacionUsr;
       this.scgEprCreacionFec = scgEprCreacionFec;
       this.scgEprActualizaUsr = scgEprActualizaUsr;
       this.scgEprActualizaFec = scgEprActualizaFec;
       this.scgEprTipoEmp = scgEprTipoEmp;
       this.scgEprExtension = scgEprExtension;
       this.scgEprDescripcionCom = scgEprDescripcionCom;
       this.scgEprNumeroCon = scgEprNumeroCon;
       this.scgEprContribuyenteEsp = scgEprContribuyenteEsp;
       this.scgEprVentasTra = scgEprVentasTra;
       this.scgUsuariosEprs = scgUsuariosEprs;
    }
   
    public String getScgEprCodigo() {
        return this.scgEprCodigo;
    }
    
    public void setScgEprCodigo(String scgEprCodigo) {
        this.scgEprCodigo = scgEprCodigo;
    }
    public ScgProvinciasCiu getScgProvinciasCiu() {
        return this.scgProvinciasCiu;
    }
    
    public void setScgProvinciasCiu(ScgProvinciasCiu scgProvinciasCiu) {
        this.scgProvinciasCiu = scgProvinciasCiu;
    }
    public String getScgEprRuc() {
        return this.scgEprRuc;
    }
    
    public void setScgEprRuc(String scgEprRuc) {
        this.scgEprRuc = scgEprRuc;
    }
    public char getScgEprEstado() {
        return this.scgEprEstado;
    }
    
    public void setScgEprEstado(char scgEprEstado) {
        this.scgEprEstado = scgEprEstado;
    }
    public String getScgEprDescripcion() {
        return this.scgEprDescripcion;
    }
    
    public void setScgEprDescripcion(String scgEprDescripcion) {
        this.scgEprDescripcion = scgEprDescripcion;
    }
    public String getScgEprTelefono1() {
        return this.scgEprTelefono1;
    }
    
    public void setScgEprTelefono1(String scgEprTelefono1) {
        this.scgEprTelefono1 = scgEprTelefono1;
    }
    public String getScgEprTelefono2() {
        return this.scgEprTelefono2;
    }
    
    public void setScgEprTelefono2(String scgEprTelefono2) {
        this.scgEprTelefono2 = scgEprTelefono2;
    }
    public String getScgEprDireccion() {
        return this.scgEprDireccion;
    }
    
    public void setScgEprDireccion(String scgEprDireccion) {
        this.scgEprDireccion = scgEprDireccion;
    }
    public String getScgEprPaginaWeb() {
        return this.scgEprPaginaWeb;
    }
    
    public void setScgEprPaginaWeb(String scgEprPaginaWeb) {
        this.scgEprPaginaWeb = scgEprPaginaWeb;
    }
    public String getScgEprEmail() {
        return this.scgEprEmail;
    }
    
    public void setScgEprEmail(String scgEprEmail) {
        this.scgEprEmail = scgEprEmail;
    }
    public byte[] getScgEprLogo() {
        return this.scgEprLogo;
    }
    
    public void setScgEprLogo(byte[] scgEprLogo) {
        this.scgEprLogo = scgEprLogo;
    }
    public String getScgEprBaseDatos() {
        return this.scgEprBaseDatos;
    }
    
    public void setScgEprBaseDatos(String scgEprBaseDatos) {
        this.scgEprBaseDatos = scgEprBaseDatos;
    }
    public String getScgEprEmailMsj() {
        return this.scgEprEmailMsj;
    }
    
    public void setScgEprEmailMsj(String scgEprEmailMsj) {
        this.scgEprEmailMsj = scgEprEmailMsj;
    }
    public String getScgEprEmailHost() {
        return this.scgEprEmailHost;
    }
    
    public void setScgEprEmailHost(String scgEprEmailHost) {
        this.scgEprEmailHost = scgEprEmailHost;
    }
    public String getScgEprCreacionUsr() {
        return this.scgEprCreacionUsr;
    }
    
    public void setScgEprCreacionUsr(String scgEprCreacionUsr) {
        this.scgEprCreacionUsr = scgEprCreacionUsr;
    }
    public Date getScgEprCreacionFec() {
        return this.scgEprCreacionFec;
    }
    
    public void setScgEprCreacionFec(Date scgEprCreacionFec) {
        this.scgEprCreacionFec = scgEprCreacionFec;
    }
    public String getScgEprActualizaUsr() {
        return this.scgEprActualizaUsr;
    }
    
    public void setScgEprActualizaUsr(String scgEprActualizaUsr) {
        this.scgEprActualizaUsr = scgEprActualizaUsr;
    }
    public Date getScgEprActualizaFec() {
        return this.scgEprActualizaFec;
    }
    
    public void setScgEprActualizaFec(Date scgEprActualizaFec) {
        this.scgEprActualizaFec = scgEprActualizaFec;
    }
    public char getScgEprTipoEmp() {
        return this.scgEprTipoEmp;
    }
    
    public void setScgEprTipoEmp(char scgEprTipoEmp) {
        this.scgEprTipoEmp = scgEprTipoEmp;
    }
    public String getScgEprExtension() {
        return this.scgEprExtension;
    }
    
    public void setScgEprExtension(String scgEprExtension) {
        this.scgEprExtension = scgEprExtension;
    }
    public String getScgEprDescripcionCom() {
        return this.scgEprDescripcionCom;
    }
    
    public void setScgEprDescripcionCom(String scgEprDescripcionCom) {
        this.scgEprDescripcionCom = scgEprDescripcionCom;
    }
    public String getScgEprNumeroCon() {
        return this.scgEprNumeroCon;
    }
    
    public void setScgEprNumeroCon(String scgEprNumeroCon) {
        this.scgEprNumeroCon = scgEprNumeroCon;
    }
    public boolean isScgEprContribuyenteEsp() {
        return this.scgEprContribuyenteEsp;
    }
    
    public void setScgEprContribuyenteEsp(boolean scgEprContribuyenteEsp) {
        this.scgEprContribuyenteEsp = scgEprContribuyenteEsp;
    }
    public boolean isScgEprVentasTra() {
        return this.scgEprVentasTra;
    }
    
    public void setScgEprVentasTra(boolean scgEprVentasTra) {
        this.scgEprVentasTra = scgEprVentasTra;
    }
    public Set getScgUsuariosEprs() {
        return this.scgUsuariosEprs;
    }
    
    public void setScgUsuariosEprs(Set scgUsuariosEprs) {
        this.scgUsuariosEprs = scgUsuariosEprs;
    }




}


