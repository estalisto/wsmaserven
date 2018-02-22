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

/**
 *
 * @author Finpac01
 */
@Path("UsuarioServicios")
public class UsuarioServicios {
    
    
    LoginDAO usu = new LoginDAO();
      EnviarEmail email = new EnviarEmail();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response usuariosAll(){
          String datos ="";
          datos=usu.getUsuariosAll();
   // return "hola: "+usuarios.get(0).getScgUsuNombres();
    return Response.ok(datos).build();
    }
    
    @GET
    //@Path("/{usuario}-{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response UsuariosAccesosWS(@QueryParam("usuario") String fusuario, @QueryParam("clave") String  fclave){
          String datos ="",datos2="";
          

        // Obtain Array
       
       String remplazado="";
        //  if (usu.PermiteAccesos(fusuario,fclave)){
              datos=usu.getUsuariosAccesos(fusuario,fclave);
              datos=datos.replace("[","");
              datos=datos.replace("]","");
           
           
        //  } 
      datos2=datos;
   // return "hola: "+usuarios.get(0).getScgUsuNombres();
    return Response.ok(datos2).build();
    
    }
   
    
    
}
