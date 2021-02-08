package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {  
	
        ResourceBundle rb = ResourceBundle.getBundle("oracle");
        String url = rb.getString("db.url");
        String username = rb.getString("db.username");
       String password = rb.getString("db.password");       
        Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection(url,username,password);        
        return con; 
    }
}