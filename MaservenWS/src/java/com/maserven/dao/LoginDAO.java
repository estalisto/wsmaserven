/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.dao;

import com.maserven.modelos.HibernateUtil;
import com.maserven.modelos.ScgUsuarios;
import com.maserven.utils.ConexionConfig;
import com.maserven.utils.ConexionMaster;
import com.maserven.utils.EnviarEmail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Finpac01
 */
public class LoginDAO {
    
    EnviarEmail email = new EnviarEmail();
     public List<ScgUsuarios> getScgUsuarios() {

        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        // hacemos la transaccion
        ArrayList<ScgUsuarios> arreglo = new ArrayList<ScgUsuarios>();
        Query q = session.createQuery("from ScgUsuarios E ");
        List<ScgUsuarios> lista = q.list();
        for (ScgUsuarios mrol : lista) {
            System.out.print("ok: ");
        }
        tx.commit();
        session.close();
        return lista;
    }
     
     public String getUsuariosAll()
        {
            JSONObject json = new JSONObject();
            JSONArray itemSelectedJson = new JSONArray();  
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx= session.beginTransaction();
            Query q = session.createQuery("from ScgUsuarios E ");
            List<ScgUsuarios> lista = q.list();
            for (ScgUsuarios datos : lista) {
               
                 json = new JSONObject();
                     json.put("nombre",datos.getScgUsuNombres()+" "+datos.getScgUsuApellidos());
                     json.put("email",datos.getScgUsuEmail());
                     json.put("cargo","VENDEDOR");
                     itemSelectedJson.add(json);
            }
            tx.commit();
            session.close();

         return  itemSelectedJson.toString();
        }
    public String getUsuariosAccesos(String Usuario, String Clave)
        {
            JSONObject json = new JSONObject();
            JSONArray itemSelectedJson = new JSONArray();  
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx= session.beginTransaction();
            Query q = session.createQuery("from ScgUsuarios E Where E.scgUsuClave= :scgUsuClave and E.scgUsuEmail= :scgUsuEmail ");
            q.setParameter("scgUsuEmail",Usuario);
            q.setParameter("scgUsuClave",Clave);            
            List<ScgUsuarios> lista = q.list();
            if (lista.size()>0){
                for (ScgUsuarios datos : lista) {
                //System.out.print("ok: ");
                 json = new JSONObject();
                     json.put("nombre",datos.getScgUsuNombres()+" "+datos.getScgUsuApellidos());
                     json.put("email",datos.getScgUsuEmail());
                     json.put("cargo","VENDEDOR");
                     json.put("mensaje","ok");
                     json.put("codigo",1);
                     itemSelectedJson.add(json);
            }
        }else{
             json = new JSONObject();
                     json.put("nombre","");
                     json.put("email","");
                     json.put("cargo","VENDEDOR");
                     json.put("mensaje","invalido");
                     json.put("codigo",0);
                     itemSelectedJson.add(json);
                     
            
            }
            
            tx.commit();
            session.close();

         return  itemSelectedJson.toString();
        }
    public boolean PermiteAccesos(String Usuario, String Clave)
        {  Random rng = new Random();
            boolean resultado=false;
            int PIN = rng.nextInt(9000)+100;
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx= session.beginTransaction();
            Query q = session.createQuery("from ScgUsuarios E Where E.scgUsuClave= :scgUsuClave and E.scgUsuEmail= :scgUsuEmail ");
            q.setParameter("scgUsuEmail",Usuario);
            q.setParameter("scgUsuClave",Clave);            
            List<ScgUsuarios> lista = q.list();
            for (ScgUsuarios datos : lista) {
                 
               // resultado=email.SendEnviarEmail("Pin  de Acceso","clave: "+PIN,"",Usuario);
               System.out.println("ok");
             
               try{
                   RegistraPinAcceso(Usuario,PIN);
               }catch (Exception ex) {
                System.out.println( "Error en el metodo RegistraPinAcceso: "+ex.getMessage() );
               }
             System.out.println("Pin  de Acceso clave: "+PIN);
                 resultado=true; 
            }
            tx.commit();
            session.close();

         return  resultado;
        }
    
     public boolean Consulta_eMail(String email)
        {  Random rng = new Random();
            boolean resultado=false;
            int PIN = rng.nextInt(9000)+100;
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Session session;
            session = sesion.openSession();
            Transaction tx= session.beginTransaction();
            Query q = session.createQuery("from ScgUsuarios E Where E.scgUsuEmail= :scgUsuEmail ");
            q.setParameter("scgUsuEmail",email);          
            List<ScgUsuarios> lista = q.list();
            for (ScgUsuarios datos : lista) {
                 
                
                resultado=true; 
            }
            tx.commit();
            session.close();

         return  resultado;
        }
     
     public String registraCambioClave(String Usuario, String Clave)
        {
            String valor = "";
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
         try{      
            ConexionMaster conMaster=new ConexionMaster();
            PreparedStatement pst;
            ResultSet rs;
            pst = conMaster.getconexion().prepareStatement("exec dbo.SP_CONSULTA_CLIENTE '"+Usuario+"','"+Clave+"';");
            rs = pst.executeQuery();
            while(rs.next())  {
                json = new JSONObject();
           json.put("codigo",rs.getString(1));
           json.put("identificacion", rs.getString(3));
           json.put("razon_social", rs.getString(2));
           json.put("mensaje", "ok");
           json.put("codigo_error", 1);
           itemSelectedJson.add(json);
            }
            rs.close();
            pst.close();
            conMaster.cierraConexion();
            return itemSelectedJson.toString();  
            }catch (SQLException ex) {
                System.err.println( ex.getMessage() );
                 json = new JSONObject();
           json.put("codigo",null);
           json.put("identificacion", null);
           json.put("razon_social", null);
           json.put("mensaje", "No existen datos");
           json.put("codigo_error", 0);
           itemSelectedJson.add(json);
           return itemSelectedJson.toString();  
             } 
        }
      public Boolean ConsultaPinAcceso(String Usuario, String Pin)
        {
            String query = "";
            String rst="";
            query="exec dbo.SP_CONSULTA_PIN '"+Usuario+"','"+Pin+"';";
            Boolean respuesta=false;
         
         try{      
            ConexionConfig cfg=new ConexionConfig();
            PreparedStatement pst;
            ResultSet rs;
            pst = cfg.getconexion().prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next())  {
                rst=rs.getString(1).toString();
                    if(rst.equals("1")){ 
                    respuesta=true;
                    }
         
            }
            rs.close();
            pst.close();
            cfg.cierraConexion();
            return respuesta;  
            }catch (SQLException ex) {
                
           return respuesta;  
             } 
        }
      
       public Boolean RegistraPinAcceso(String Usuario, int Pin)
        {
            String valor = "";
            String PIN = "";
            PIN = String.valueOf(Pin);
            Boolean respuesta=false;
         
         try{      
            ConexionConfig cfg=new ConexionConfig();
            PreparedStatement pst;
            ResultSet rs;
            pst = cfg.getconexion().prepareStatement("exec dbo.SP_CREA_CON_PIN '"+Usuario+"','"+PIN+"' ;");
            rs = pst.executeQuery();
            while(rs.next())  {
               
                    if(rs.getString(1).equals(1)){ 
                    respuesta=true;
                    }
         
            }
            rs.close();
            pst.close();
            cfg.cierraConexion();
            return respuesta;  
            }catch (SQLException ex) {
                 System.out.println( ex.getMessage() );
           return respuesta;  
             } 
        }
    public String generaPIN(){
        Random rng = new Random();
            boolean resultado=false;
            int PIN = rng.nextInt(9000)+100;
            String valor="0000";
            valor=Integer.toString(PIN);
         return valor;   
    }
    
    public String htmlPIN(String pin ){
    
    String cadena ="<html><div style='margin: 0px; padding: 0px; font-size: 14px; font-family: Helvetica, Arial, sans-serif, serif, EmojiFont; line-height: 19px; color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);'>\n" +
"<table cellpadding='0' cellspacing='0' border='0' align='center' width='100%' style='border-bottom:1px dashed #ededed'>\n" +
"<tbody>\n" +
"<tr>\n" +
"<td>\n" +
"<table cellpadding='0' cellspacing='0' border='0' align='center' width='600'>\n" +
"<tbody>\n" +
"<tr>\n" +
"<td height='40' style='padding:0 20px'>\n" +
"<p style='font-size:12px; line-height:16px; font-family:Helvetica,Arial,sans-serif; color:#999'>\n" +
"Este es un mensaje de correo electrónico automático, no lo respondas.</p>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table cellpadding='0' cellspacing='0' border='0' align='center' width='600'>\n" +
"<tbody>\n" +
"<tr>\n" +
"<td style='padding-top:20px; padding-right:20px; padding-left:20px'>\n" +
"<table border='0' cellspacing='0' cellpadding='0' width='560' align='center'>\n" +
"<tbody>\n" +
"<tr>\n" +
"<td align='left' width='450'>\n" +
"<h1 style='font-size:20px; font-weight:bold; font-family:Helvetica,Arial,sans-serif; line-height:28px; color:#999'>\n" +
"¡Hola!</h1>\n" +
"</td>\n" +
"<td align='rigth' ><a href='http://maserven.com/sitio/' target='_blank' rel='noopener noreferrer' style='line-height:0'><img data-imagetype='External' src='http://expriceit.com.ec/img/maserven.png' width='210' height='50' border='0' alt='http://maserven.com' > </a></td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style='padding-top:40px; padding-right:20px; padding-left:20px'>\n" +
"<h2 style='font-weight:bold; font-size:24px; font-family:Helvetica,Arial,sans-serif; line-height:26px; color:#999; margin:0'>\n" +
"Envio de PIN para acceder a la Aplicación</h2>\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td style='padding:20px 20px'>\n" +
"<div style='font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 14px; font-family: Helvetica, Arial, sans-serif, serif, EmojiFont; line-height: 19px; color: rgb(51, 51, 51);'>\n" +
"Para acceder a la aplicación de pedidos desde tu movil, es necesario ingresar tu PIN : <a href='#' target='_blank' rel='noopener noreferrer' style='text-decoration:underline; color:#00aff0; font-weight:bold'>"+pin+"</a>.<br>\n" +
"<br>\n" +
"Recuerda que tu claves de acceso y pin son privados. Por tal motivo no debes compartir las mismas con nadie. </div>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"<table cellpadding='0' cellspacing='0' border='0' align='center' width='600'>\n" +
"<tbody>\n" +
"<tr>\n" +
"<td style='padding-top:30px; padding-right:20px; padding-bottom:20px; padding-left:20px'>\n" +
"<p style='font-weight:bold; font-size:18px; line-height:24px; font-family:Helvetica,Arial,sans-serif; color:#666; margin:0'>\n" +
"¡Hasta pronto!<br>\n" +
"<br>\n" +
"Saludos,<br>\n" +
"MASERVEN S.A. y toda su gente</p>\n" +
"</td>\n" +
"</tr>\n" +
"</tbody>\n" +
"</table>\n" +
"</div></html>"; 
    return cadena;
    }
}
