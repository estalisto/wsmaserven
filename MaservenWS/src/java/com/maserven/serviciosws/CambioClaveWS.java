/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.maserven.dao.LoginDAO;
import com.maserven.utils.EnviarEmail;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Finpac01
 */
@Path("CambioClaveWS")
public class CambioClaveWS {
    
     
    LoginDAO usu = new LoginDAO();
      EnviarEmail email = new EnviarEmail();
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CambioClaveWS(@QueryParam("usuario") String fusuario, @QueryParam("clave") String  fclave){
          String datos ="[]";
          Boolean resultado;
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
       //registra nueva clave
       //genera pin
      String pin = usu.generaPIN();
       //registra nuevo pin

       //envia mail
       resultado=email.SendEnviarEmail("Pin  de Acceso",usu.htmlPIN(pin),"",fusuario);
       //resultado=true;
       if(resultado){
       json = new JSONObject();
           
           json.put("mensaje", "ok");
           json.put("codigo_error", 1);
           itemSelectedJson.add(json);
           
       }else{
       json = new JSONObject();
           
           json.put("mensaje", "error");
           json.put("codigo_error", 0);
           itemSelectedJson.add(json);
          
       }
        datos=itemSelectedJson.toString();
  
    return Response.ok(datos).build();
    }
}
