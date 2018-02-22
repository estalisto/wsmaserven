/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Finpac01
 */
public class GeneraReporte {
    ConexionMaster conMaster=new ConexionMaster();
    
    
    
    
   public void genera_reporte() throws JRException {
      InputStream inputstream = null;
   try {
             inputstream = new FileInputStream("C:\\Users\\Finpac01\\Documents\\NetBeansProjects\\MaservenWS\\web\\reportes\\NotaPedido.jrxml");
	
          } catch (FileNotFoundException ex) {
              Logger.getLogger(GeneraReporte.class.getName()).log(Level.SEVERE, null, ex);
          }
   



Map parameters =new HashMap();
JasperDesign jasperDesing = JRXmlLoader.load(inputstream);
JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesing);
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conMaster.getconexion());
JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Finpac01\\Documents\\NetBeansProjects\\MaservenWS\\web\\reportes\\NotaPedido1.pdf");
   }
   
public void genera_mi_reporte(int idpedido, String NombreArchivo) throws JRException {
      InputStream inputstream = null;
        try {
             //inputstream = new FileInputStream("C:\\Users\\Finpac01\\Documents\\NetBeansProjects\\MaservenWS\\web\\reportes\\NotaPedido.jrxml");
             inputstream = new FileInputStream("/var/lib/tomcat8/webapps/MaservenWS/reportes/NotaPedido.jrxml");
	
          } catch (FileNotFoundException ex) {
                System.out.println("Problemas al buscar el JRXML>> "+ex.getMessage());
              Logger.getLogger(GeneraReporte.class.getName()).log(Level.SEVERE, null, ex);
            
          }
   


try{
    Map parameters =new HashMap();
    int id_pedido=idpedido;
    String mi_documento="";
    //mi_documento="C:\\Users\\Finpac01\\Documents\\"+NombreArchivo;
    mi_documento="/var/lib/tomcat8/documentos/"+NombreArchivo;

    parameters.put("id_pedido", id_pedido); 
    JasperDesign jasperDesing = JRXmlLoader.load(inputstream);
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesing);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conMaster.getconexion());
    //JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Finpac01\\Documents\\NetBeansProjects\\MaservenWS\\web\\reportes\\NotaPedido1.pdf");
    JasperExportManager.exportReportToPdfFile(jasperPrint,mi_documento);
}catch (Exception e){
  System.out.println("Problemas al Generar  el PDF>> "+e.getMessage());
  Logger.getLogger(GeneraReporte.class.getName()).log(Level.SEVERE, null, e);
}
    
    }
}
