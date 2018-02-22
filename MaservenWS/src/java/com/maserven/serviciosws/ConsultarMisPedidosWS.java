/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

/**
 *
 * @author Finpac01
 */
 

import com.maserven.dao.MisPedidosDAO;
import com.maserven.utils.EnviarEmail;
import com.maserven.utils.GeneraReporte;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ConsultarMisPedidosWS")
public class ConsultarMisPedidosWS {
    
     MisPedidosDAO pedido = new MisPedidosDAO();
      GeneraReporte report = new GeneraReporte();
      EnviarEmail env=new EnviarEmail();
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ConsultarMisPedidosWS(@QueryParam("email") String femail){
    
    String datos="";
    datos=pedido.ConsultarPedidosporUsuario(femail);
    return Response.ok(datos).build();
    }
    
}
