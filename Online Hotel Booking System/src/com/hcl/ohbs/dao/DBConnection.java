package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {  
		
		/*
		 * Attention please
		 * Here we can remove the resourceBundle method because I got an error.
		 * Properties file is kind of error prone file I hope
		 * So, user the code block starts from line 29 and make one connection line for your PC
		 * I got line 1
		 * pease comment other lines while you are on your line
		 * 
		 * */
		
		
//        ResourceBundle rb = ResourceBundle.getBundle("oracle");
//        String url = rb.getString("db.url");
//        String username = rb.getString("db.username");
//        String password = rb.getString("db.password");       
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection con = DriverManager.getConnection(url,username,password);        
//        return con; 
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","br3akDown"); // chathura

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","br3akDown"); // chathura

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","br3akDown"); // sithara
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","shanu123"); // shanuka

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sithara123"); // sithara

		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","br3akDown"); // shanuka
		//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","br3akDown"); // thanusha
		System.out.println("Connected");
		return con;
    }
}