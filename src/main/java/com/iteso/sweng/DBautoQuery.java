/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteso.sweng;
import java.sql.*;
/**
 *
 * @author CoCoNO
 */
public class DBautoQuery {
    
    
    private static DBautoQuery instance = null;
    static private String user = "root1337";
    static private String pass = "toor1337";
    static private String dbClass = "com.mysql.jdbc.Driver";
    static private String dbDriver = "jdbc:mysql://db4free.net:3306/catalogero";
    static private Connection conn = null;
  
   protected DBautoQuery() {
      // Exists only to defeat instantiation.
       
   }
   public static DBautoQuery getInstance() {
      if(instance == null) {
         instance = new DBautoQuery();
      }
      return instance;
   }
   
   public boolean isActive()
   {
       return null!=conn;
   }
   
   
   public boolean connect() {
    boolean done = false;
    //load driver
    try {
        Class.forName(dbClass).newInstance();
        System.out.println("driver loaded"); // THIS IS BEING RETURNED
    } catch (Exception ex) {
        System.err.println(ex);
    }
    // Connection
    try {
        conn = DriverManager.getConnection(dbDriver, user, pass);
        System.out.println("connected"); // THIS IS NOT BEING RETURNED
        done = true;
    } catch (SQLException ex) {
        System.out.println("SQLException: " + ex.getMessage());
    }
    return done;
   }
   public ResultSet doQuery(String qry)
    {
        try 
        {
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(qry);
             return rs;
        } 
        catch (Exception e) 
        {
            System.out.println("SQLException on Query: " + e.getMessage());
        }
        
        
        return null;
    }
   public void close()
    {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("SQLException on closing: " + e.getMessage());
        }
        
    }
   
}