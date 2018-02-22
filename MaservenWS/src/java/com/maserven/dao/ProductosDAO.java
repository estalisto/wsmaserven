/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.dao;

import com.maserven.utils.ConexionMaster;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Finpac01
 */
public class ProductosDAO {
    
    public String ConsultaItems(String tipo, String codInt, String CodAlterno, String descripcion, String linea)
        {
            String valor = "";
            int cont=0;
          JSONObject json = new JSONObject();
        JSONArray itemSelectedJson = new JSONArray();
         try{      
            ConexionMaster conMaster=new ConexionMaster();
            PreparedStatement pst;
            ResultSet rs;
            pst = conMaster.getconexion().prepareStatement("exec dbo.SP_CONSULTA_ITEMS '"+tipo+"','"+codInt+"','"+CodAlterno+"','"+descripcion+"','"+linea+"';");
            rs = pst.executeQuery();
            while(rs.next())  {
                json = new JSONObject();
           json.put("codigo_interno",rs.getString(1));
           json.put("codigo_alterno", rs.getString(2));
           json.put("descripcion", rs.getString(3));
           json.put("pvp", rs.getString(5));
           json.put("stock", rs.getString(6));
           itemSelectedJson.add(json); 
           //json.put("mensaje", "ok");
          // json.put("codigo_error", 1);
          cont++;
            }
            rs.close();
            pst.close();
            conMaster.cierraConexion();
            System.out.println("cont>>>: "+cont);
            return itemSelectedJson.toString();  
            }catch (SQLException ex) {
                System.err.println( ex.getMessage() );
                 json = new JSONObject();           
           json.put("mensaje", "No existen datos");
           json.put("codigo_error", 0);
           itemSelectedJson.add(json);
           return itemSelectedJson.toString();  
             } 
        }
    
}
