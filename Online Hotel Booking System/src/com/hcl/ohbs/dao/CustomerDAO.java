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
		
		public boolean LoginCustomer(Customer c) {
			boolean status=false;
			try {
				
				Connection con=DBConnection.getConnection();
				PreparedStatement pmt=null;
				ResultSet rs=null;
				String query=null;
				
				query = "select * from customer where username=? and password=?";
				pmt=con.prepareStatement(query);
				pmt.setString(1,c.getUsername());
				pmt.setString(2, c.getPassword());
				
				rs=pmt.executeQuery();
			    status=rs.next();
				
			}
			catch(SQLException e) {e.printStackTrace();}
			catch(ClassNotFoundException cls) {cls.printStackTrace();}
			return status;
		}
		
		public int findIdByUsernamePassword(String username, String password){       
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				con = DBConnection.getConnection();
				String query = "SELECT id FROM customer WHERE username=? AND password=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				if(rs.next()){
					return rs.getInt(1);
				}
		    }catch(ClassNotFoundException e1){
		            e1.printStackTrace();
		    }catch(SQLException e2){
		            e2.printStackTrace();
		    }finally{
		         try{
		            if(pstmt!=null)
		                pstmt.close();
		            if(rs!=null)
		                rs.close();
		            if(con!=null)
		                con.close();
		         }catch(SQLException e3){
		                e3.printStackTrace();
		         }
		     } 
		    return 0;
		}
		public String findNameByUsernamePassword(String username, String password){       
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try{
				con = DBConnection.getConnection();
				String query = "SELECT first_name FROM customer WHERE username=? AND password=?";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				if(rs.next()){
					return rs.getString(1);
				}
		    }catch(ClassNotFoundException e1){
		            e1.printStackTrace();
		    }catch(SQLException e2){
		            e2.printStackTrace();
		    }finally{
		         try{
		            if(pstmt!=null)
		                pstmt.close();
		            if(rs!=null)
		                rs.close();
		            if(con!=null)
		                con.close();
		         }catch(SQLException e3){
		                e3.printStackTrace();
		         }
		     } 
		    return null;
		}
		
		public String getNameById(int id) {
			Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try{
	            con = DBConnection.getConnection();
	            String query = "SELECT first_name FROM customer WHERE id=?";
	            pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            if(rs.next()){
	                return rs.getString(1);
	            }
	        }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	        }catch(SQLException e2){
	            e2.printStackTrace();
	        }finally{
	            try{
	                if(pstmt!=null)
	                    pstmt.close();
	                if(con!=null)
	                    con.close();
	            }catch(SQLException e3){
	                e3.printStackTrace();
	            }
	        } 
	        return null;
		}
}
