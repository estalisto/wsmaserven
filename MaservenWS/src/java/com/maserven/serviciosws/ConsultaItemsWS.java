/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.maserven.dao.LoginDAO;
import com.maserven.dao.ProductosDAO;
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
@Path("ConsultaItemsWS")
public class ConsultaItemsWS {
    
    ProductosDAO item = new ProductosDAO();
   //   EnviarEmail email = new EnviarEmail();
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ConsultaItemsWS(@QueryParam("tipo") String tipo, 
                                    @QueryParam("cod_int") String  codigoIterno,
                                    @QueryParam("cod_alt") String  codigoAlterno,
                                    @QueryParam("descripcion") String  Descripcion,
                                    @QueryParam("linea") String  Linea
                                    ){
          String datos ="[]";
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
          datos=item.ConsultaItems(tipo, codigoIterno, codigoAlterno, Descripcion, Linea);
          
        JsonParser parser = new JsonParser();

        // Obtain Array
        JsonArray gsonArr = parser.parse(datos).getAsJsonArray();
          json = new JSONObject();
           
           /*json.put("data", gsonArr);
           json.put("mensaje", "ok");
           json.put("codigo_error", 1);
           itemSelectedJson.add(json);*/
           String datosJSON="{ \"data\":"+gsonArr+",\"mensaje\":\"ok\",\"codigo_error\":1}";
          
 System.out.println("datosJSON: "+datosJSON);
    //return Response.ok(itemSelectedJson.toString()).build();
    return Response.ok(datosJSON).build();
    }
    
    
}
