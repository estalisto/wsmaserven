
import com.maserven.dao.LoginDAO;
import com.maserven.modelos.ScgUsuarios;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Finpac01
 */
@Path("PruebasWS")
public class PruebasWS {
   
    
    LoginDAO usu = new LoginDAO();
      @GET
      @Produces(MediaType.APPLICATION_JSON)
    public Response hellows(@QueryParam("name") String nombre){
          String datos ="";
          datos=usu.getUsuariosAll();
   // return "hola: "+usuarios.get(0).getScgUsuNombres();
    return Response.ok(datos).build();
    }
    
}
