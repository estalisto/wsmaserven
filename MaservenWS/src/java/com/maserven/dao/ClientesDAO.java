/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.dao;

import com.maserven.utils.ConexionConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Finpac01
 */
public class ClientesDAO {
    
    public String getNuevaConsulta(String usuario, String identificacion){
         String valor = "";
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
         try{      
            ConexionConfig cxConfig=new ConexionConfig();
            PreparedStatement pst;
            ResultSet rs;
            // exec dbo.SP_CONSULTA_CLIENTE 'RSO','','ba_reyes2008@hotmail.com','A'
            pst = cxConfig.getconexion().prepareStatement("exec dbo.SP_CONSULTA_CLIENTE '"+identificacion+"','"+usuario+"';");
           
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
            cxConfig.cierraConexion();
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
    public String getConsultaCliente(String tipo, String usuario, String identificacion, String nombre_cliente){
         String valor = "";
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
        String query="";
        query="exec dbo.SP_CONSULTA_CLIENTE '"+tipo+"','"+identificacion+"','"+usuario+"','"+nombre_cliente+"';";
         try{      
            ConexionConfig cxConfig=new ConexionConfig();
            PreparedStatement pst;
            ResultSet rs;
            // exec dbo.SP_CONSULTA_CLIENTE 'RSO','','ba_reyes2008@hotmail.com','A'
            pst = cxConfig.getconexion().prepareStatement(query);
           
            rs = pst.executeQuery();
            while(rs.next())  {
                json = new JSONObject();
           json.put("codigo",rs.getString(1));
           json.put("identificacion", rs.getString(3));
           json.put("razon_social", rs.getString(2));
           itemSelectedJson.add(json);
            }
            rs.close();
            pst.close();
            cxConfig.cierraConexion();
            return itemSelectedJson.toString();  
            }catch (SQLException ex) {
                System.err.println( ex.getMessage() );
               return itemSelectedJson.toString();  
             } 
                
    }
    
}
