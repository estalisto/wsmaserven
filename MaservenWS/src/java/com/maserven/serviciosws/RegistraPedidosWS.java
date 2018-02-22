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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Finpac01
 */
@Path("RegistraPedidosWS")
public class RegistraPedidosWS {
      MisPedidosDAO pedido = new MisPedidosDAO();
      GeneraReporte report = new GeneraReporte();
      EnviarEmail env=new EnviarEmail();
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response InsertPedidoWS(@QueryParam("num_pedido") String fnum_pedido, 
            @QueryParam("identificacion") String f_identificacion, 
            @QueryParam("numero_ped_app") String fnumero_ped_app, 
            @QueryParam("total_pedido") String ftotal_pedido, 
            @QueryParam("subtotal") String fsubtotal, 
            @QueryParam("valor_dscto") String fvalor_dscto, 
            @QueryParam("valor_iva") String fvalor_iva, 
            @QueryParam("email") String femail){
        String datos ="[]";   
        //SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d HH:mm:ss z yyyy"); // Error, la cadena de texto no se puede convertir en fecha.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // Error, la cadena de texto no se puede convertir en fecha.
          String NombreArchivo="Pedido_Maserven_"+dateFormat.format(new Date())+".pdf";
        System.out.println(">>>> Fecha actual: "+NombreArchivo);
        String num_pedido="";
        
        try {
            
            datos=pedido.setNuevoPedido(fnum_pedido, f_identificacion, fnumero_ped_app, ftotal_pedido, fsubtotal, fvalor_dscto, fvalor_iva, femail,NombreArchivo);
            num_pedido=datos;
            //pedido.DescomponeJson(datos);
        } catch (Exception e) {
            datos ="[]"; 
              System.err.println( e.getMessage());
        }
        
          
          
          datos=datos.replace("[","");
          datos=datos.replace("]","");
    return Response.ok(datos).build();
    }
    
}
