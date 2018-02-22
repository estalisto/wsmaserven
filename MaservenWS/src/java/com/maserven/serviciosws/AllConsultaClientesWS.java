/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.maserven.dao.ClientesDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Finpac01
 */
@Path("AllConsultaClientesWS")
public class AllConsultaClientesWS {
     ClientesDAO cli = new ClientesDAO();
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
     public Response MisClientesWS(@QueryParam("tipo") String ftipo,@QueryParam("usuario") String fusuario, @QueryParam("identificacion") String  f_identificacion, @QueryParam("nombre_cliente") String  f_nombre_cliente){
          String datos ="[]";       
          datos=cli.getConsultaCliente(ftipo,fusuario,f_identificacion,f_nombre_cliente);
          if(datos==null){
           datos = "{\"data\":[]}";
           }   else{
               datos = "{\"data\": "+datos+"}";
           }
         
    return Response.ok(datos).build();
    }
    
}
