/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.maserven.utils.ConexionConfig;
import com.maserven.utils.ConexionMaster;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Finpac01
 */
public class MisPedidosDAO {
     public String setNuevoPedido(String num_pedido, String identificacion,String numero_ped_app, 
             String total_pedido, String subtotal, String valor_dscto, String valor_iva, String email,String NombreArchivo ){
         
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); // Error, la cadena de texto no se puede convertir en fecha.
         String NombreArchivo1;
         NombreArchivo1 = "pedido_maserven_"+dateFormat.format(new Date())+".pdf";
         String valor = "";
         String ejecutaSentencia="exec dbo.SP_PEDIDOS_CAB "+Float.parseFloat(num_pedido)+",'"+identificacion+"',"+Float.parseFloat(numero_ped_app)+","+Float.parseFloat(total_pedido)+","+Float.parseFloat(subtotal)+","+Float.parseFloat(valor_dscto)+","+Float.parseFloat(valor_iva)+",'"+email+"','"+NombreArchivo+"';";
         
         JSONObject json = new JSONObject();
         JSONArray itemSelectedJson = new JSONArray();
         try{      
           
            ConexionMaster conMaster=new ConexionMaster();
            PreparedStatement pst;
            ResultSet rs;
            pst = conMaster.getconexion().prepareStatement("exec dbo.SP_PEDIDOS_CAB "+Float.parseFloat(num_pedido)+",'"+identificacion+"',"+Float.parseFloat(numero_ped_app)+","+Float.parseFloat(total_pedido)+","+Float.parseFloat(subtotal)+","+Float.parseFloat(valor_dscto)+","+Float.parseFloat(valor_iva)+",'"+email+"','"+NombreArchivo1+"';");
           
            rs = pst.executeQuery();
            while(rs.next())  {
                json = new JSONObject();
           json.put("id_pedido",rs.getString(1));
           json.put("nombre_archivo",NombreArchivo1);
           itemSelectedJson.add(json);
            }
            rs.close();
            pst.close();
            conMaster.cierraConexion();
            return itemSelectedJson.toString();  
            }catch (SQLException ex) {
                System.err.println( ex.getMessage() );
                 json = new JSONObject();
           json.put("id_pedido","-1");
           json.put("nombre_archivo","");
           itemSelectedJson.add(json);
           return itemSelectedJson.toString();  
             } 
                
    }
     
     
     public String setDetallePedido(String num_pedido, String codigo_interno,String codigo_alterno, 
             String cantidad, String precio, String fecha_creacion, String fecha_actualizacion, String estado, String descuento ){
         
         
         String valor = "";
         String ejecutaSentencia="exec dbo.SP_PEDIDOS_DET '"+Float.parseFloat(num_pedido)+"','"+codigo_interno+"','"+codigo_alterno+"','"+Float.parseFloat(cantidad)+"','"+Float.parseFloat(precio)+"','"+fecha_creacion+"','"+fecha_actualizacion+"','A','"+Float.parseFloat(descuento)+"'";
         
         JSONObject json = new JSONObject();
         JSONArray itemSelectedJson = new JSONArray();
         try{      
           
            ConexionMaster conMaster=new ConexionMaster();
            PreparedStatement pst;
            ResultSet rs;
            pst = conMaster.getconexion().prepareStatement(ejecutaSentencia);
           
            rs = pst.executeQuery();
            while(rs.next())  {
                json = new JSONObject();
           json.put("id_pedido",rs.getString(1));
           itemSelectedJson.add(json);
            }
            rs.close();
            pst.close();
            conMaster.cierraConexion();
            return itemSelectedJson.toString();  
            }catch (SQLException ex) {
                System.err.println( ex.getMessage() );
                 json = new JSONObject();
           json.put("id_pedido","-1");
           itemSelectedJson.add(json);
           return itemSelectedJson.toString();  
             } 
                
    }
     
   public int DescomponeJson(String Trama){
         
              JsonElement jelement = new JsonParser().parse(Trama);
    JsonObject  jobject = jelement.getAsJsonObject();
   // jobject = jobject.getAsJsonObject("");
    //JsonArray jarray = jobject.getAsJsonArray("id_pedidos");
    //jobject = jobject.get(0).getAsJsonObject();
    String result = jobject.get("id_pedido").getAsString();
   
             return 1;
        
   }  
   
   public static void dumpJSONElement(JsonElement elemento) {
    if (elemento.isJsonObject()) {
        System.out.println("Es objeto");
        JsonObject obj = elemento.getAsJsonObject();
        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
        while (iter.hasNext()) {
            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
            System.out.println("Clave: " + entrada.getKey());
            System.out.println("Valor:");
            dumpJSONElement(entrada.getValue());
        }
 
    } else if (elemento.isJsonArray()) {
        JsonArray array = elemento.getAsJsonArray();
        System.out.println("Es array. Numero de elementos: " + array.size());
        java.util.Iterator<JsonElement> iter = array.iterator();
        while (iter.hasNext()) {
            JsonElement entrada = iter.next();
            dumpJSONElement(entrada);
        }
    } else if (elemento.isJsonPrimitive()) {
        System.out.println("Es primitiva");
        JsonPrimitive valor = elemento.getAsJsonPrimitive();
        if (valor.isBoolean()) {
            System.out.println("Es booleano: " + valor.getAsBoolean());
        } else if (valor.isNumber()) {
            System.out.println("Es numero: " + valor.getAsNumber());
        } else if (valor.isString()) {
            System.out.println("Es texto: " + valor.getAsString());
        }
    } else if (elemento.isJsonNull()) {
        System.out.println("Es NULL");
    } else {
        System.out.println("Es otra cosa");
    }
}

    private void dumpJSONElement(JSONObject jsonObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public String ConsultarPedidosporUsuario(String email){
         
         String valor = "";
         String ejecutaSentencia="exec dbo.SP_CONSULTA_PED_JSON '"+email+"';";
         
         try{      
           
            ConexionMaster conMaster=new ConexionMaster();
            PreparedStatement pst;
            ResultSet rs;
            pst = conMaster.getconexion().prepareStatement(ejecutaSentencia);
           
            rs = pst.executeQuery();
            while(rs.next())  {
                valor=rs.getString(1);
           
            }
            rs.close();
            pst.close();
            conMaster.cierraConexion();
            return valor;  
            }catch (SQLException ex) {
                System.err.println( ex.getMessage() );;
           return valor;  
             } 
                
    }
}
