package com.java.util;

import java.sql.*;


public class DBConnect {
private static Connection conn = null;
	
	public  DBConnect() {
try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
 
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ecommerce", "root", "spoorthy");
 
            System.out.println("Connected to the database");
           
 
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
 
	}
        
 
	public static Connection  getConnect()
	 {
		 DBConnect d1= new DBConnect();
		 return conn;
		
	 }
}
