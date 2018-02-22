/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maserven.utils;

/**
 *
 * @author Finpac01
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ViewSoft
 */
public class ConexionConfig {
    
  // String url2="jdbc:sqlserver://192.168.1.189\\MASERDESARROLO:49403;databaseName=db_config";
   String url2="jdbc:sqlserver://192.168.1.200\\SERVIDORMASER:1433;databaseName=db_config";
 Connection cn=null;
     public Connection getconexion(){
        //String url="jdbc:sqlserver://192.168.1.189\\MASERDESARROLO:49403;databaseName=db_config";
               String url="jdbc:sqlserver://192.168.1.200\\SERVIDORMASER:1433;databaseName=db_config";

        String user = "sa";
        String pass = "SGRDD.servidormaserven.13.";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url,user,pass);
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
            cn=DriverManager.getConnection(url2,"sa","SGRDD.servidormaserven.13.");
                                                    //SGRDD.servidormaserven.13.
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cn;
    }

    public Connection getConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
