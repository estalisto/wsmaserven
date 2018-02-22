/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Finpac01
 */
public class ConexionMaster {
    

   //String url2="jdbc:sqlserver://localhost\\MASERDESARROLO:49403;databaseName=db_maser";
     String url2="jdbc:sqlserver://192.168.1.200\\SERVIDORMASER:1433;databaseName=db_maser";

   String Usuario="sa", Clave="SGRDD.servidormaserven.13.";
   String motorBD="db_maser";
   
 Connection cn=null;
     public Connection getconexion(){
        
        String user = Usuario;        
        String pass = Clave;        
        //String url="jdbc:sqlserver://localhost\\MASERDESARROLO:49403;databaseName="+motorBD;
        String url="jdbc:sqlserver://192.168.1.200\\SERVIDORMASER:1433;databaseName="+motorBD;
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url2,Usuario,Clave);
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
        
        return cn;
    }
     
    public void cierraConexion()
    {
        try
        {
            cn.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
    }
 
   
    
    public Connection getconexion2(){
        Connection cn=null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url2,Usuario,Clave);
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }

    public Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

