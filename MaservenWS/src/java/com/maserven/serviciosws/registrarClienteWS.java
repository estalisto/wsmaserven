/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
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
@Path("registrarClienteWS")
public class registrarClienteWS {
    
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarCliente(@QueryParam("usuario") String Usuario, 
                                    @QueryParam("identificacion") String  Identificacion,
                                    @QueryParam("nombre_cliente") String  nombre_cliente
                                    ){
          String datos ="1";
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
         json = new JSONObject();
         
         //llamar al metodo de registrar
          if (datos.equals("1")){
           json.put("mensaje", "Registrado exitosamente...");
           json.put("codigo_error", datos);
          }
          if (datos.equals("0")){
           json.put("mensaje", "Problemas al registrar el cliente, comuniquese con soporte");
           json.put("codigo_error", datos);
          }
          if (datos.equals("3")){
           json.put("mensaje", "Cliente Ya existe, se ecnuentra asociado con otro vendedor, Comunicarse con deptamento de Ventas.");
           json.put("codigo_error", datos);
          }
         
           itemSelectedJson.add(json);
  
    return Response.ok(itemSelectedJson.toString()).build();
    }
    
}
