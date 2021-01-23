package com.hcl.ohbs.dao;

import java.sql.*;

import com.hcl.ohbs.entities.Customer;

public class CustomerDAO {

	//register new customer
		public boolean registerCustomer(Customer c) 
		{
			try {
			//make the connection
			Connection con=DBConnection.getConnection();
			PreparedStatement pmt=null;
			String query=null;
			
			
				//query to add customer details to the database
				query="insert into customer(first_name,last_name,phone_number,address,email,username,password) values(?,?,?,?,?,?,?)";
				pmt=con.prepareStatement(query);
				pmt.setString(1,c.getFirstName() );
				pmt.setString(2, c.getLastName());
				pmt.setString(3, c.getPhoneNumber());
				pmt.setString(4, c.getAddress());
				pmt.setString(5, c.getEmail());
				pmt.setString(6, c.getUsername());
				pmt.setString(7, c.getPassword());
				
				//execute the query
				int n=pmt.executeUpdate();
			    return n>0?true:false;
			}
			catch(SQLException se) {se.printStackTrace();}
			catch(ClassNotFoundException cls) {cls.printStackTrace();}
			return false;
		}
}
