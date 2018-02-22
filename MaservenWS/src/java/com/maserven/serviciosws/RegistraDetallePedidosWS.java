/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.serviciosws;

import com.maserven.dao.MisPedidosDAO;
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
@Path("RegistraDetallePedidosWS")
public class RegistraDetallePedidosWS {
    
    MisPedidosDAO pedido = new MisPedidosDAO();
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response InsertPedidoWS(@QueryParam("num_pedido") String fnum_pedido, 
            @QueryParam("codigo_interno") String fcodigo_interno, 
            @QueryParam("codigo_alterno") String fcodigo_alterno, 
            @QueryParam("cantidad") String fcantidad, 
            @QueryParam("precio") String fprecio, 
            @QueryParam("fecha_creacion") String ffecha_creacion, 
            @QueryParam("fecha_actualizacion") String ffecha_actualizacion, 
            @QueryParam("estado") String festado,
            @QueryParam("descuento") String fdescuento){
        String datos ="[]";    
        
        try {
            datos=pedido.setDetallePedido(fnum_pedido, fcodigo_interno, fcodigo_alterno, fcantidad, fprecio, ffecha_creacion, ffecha_actualizacion, festado,fdescuento );
  
        } catch (Exception e) {
            datos ="[]"; 
              System.err.println( e.getMessage());
        }
          datos=datos.replace("[","");
          datos=datos.replace("]","");
    return Response.ok(datos).build();
    }
    
}
