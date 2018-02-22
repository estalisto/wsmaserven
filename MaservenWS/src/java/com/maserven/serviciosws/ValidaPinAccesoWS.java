/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.maserven.dao.LoginDAO;
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
@Path("ValidaPinAccesoWS")
public class ValidaPinAccesoWS {
       LoginDAO usu = new LoginDAO();
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ValidaPinAccesoWS(@QueryParam("usuario") String fusuario, @QueryParam("clave_pin") String  fpin){
          String datos ="[]";
          String remplazado="";
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
          if (usu.ConsultaPinAcceso(fusuario, fpin)){
                json = new JSONObject();
           json.put("mensaje", "ok");
           json.put("codigo", 1);
           itemSelectedJson.add(json);
                    } else  {
              json = new JSONObject();
           json.put("mensaje", "Pin Incorrecto");
           json.put("codigo", 0);
           itemSelectedJson.add(json);
            }
          datos=itemSelectedJson.toString();
          datos=datos.replace("[", "");
          datos=datos.replace("]", "");
   // return "hola: "+usuarios.get(0).getScgUsuNombres();
    return Response.ok(datos).build();
    }
   
}
