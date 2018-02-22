/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.maserven.utils.EnviarEmail;
import com.maserven.utils.GeneraReporte;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Finpac01
 */
@Path("EnviarDocumento")
public class EnviarDocumento {
    
    
      GeneraReporte report = new GeneraReporte();
      EnviarEmail env=new EnviarEmail();
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response EnvioDocumentos(@QueryParam("num_pedido") String fnum_pedido,
            @QueryParam("nombre_archivo") String fNombreArchivo,
            @QueryParam("email") String femail){
        
        String mensaje="",codigo="";
        JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
        
          try {
              report.genera_mi_reporte(Integer.parseInt(fnum_pedido),fNombreArchivo);
              codigo="1";
              mensaje=mensaje+"Pedido Generado ";
              
          
             
          } catch (JRException ex) {
              Logger.getLogger(RegistraPedidosWS.class.getName()).log(Level.SEVERE, null, ex);
              codigo="-1";
              mensaje=mensaje+"Problemas al Generar el Pedido  ";
          }
          
       try{
                env.SendEnviarEmail("Pedido N.#"+fnum_pedido,"Estimado Usuario,  <br>Se adjunta la Nota de Pedido N#:"+fnum_pedido+". Verificar que los datos del documento sea los Correctos.<br>"
                      + "<br>Saludos, <br>Departamento de Sistemas",  fNombreArchivo, "notaspedido@maserven.com,"+femail);
                codigo="1";
                mensaje=mensaje+" y enviado por correo.";
          } catch (Exception ex) {
                Logger.getLogger(RegistraPedidosWS.class.getName()).log(Level.SEVERE, "error al enviar correo", ex);
                codigo="-2";
                mensaje=mensaje+"Problemas al enviar el documento";
          }
          
         json.put("mensaje",mensaje);
         json.put("codigo",codigo);
         itemSelectedJson.add(json);
         ;  
    return Response.ok(itemSelectedJson.toString()).build();
    }
    
    
}
