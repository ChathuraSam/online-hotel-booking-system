package com.hcl.ohbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelOwner;

public class HotelDAO {
	
	public boolean addHotel(Hotel hotel) {
		Connection con = null;
        PreparedStatement pstmt = null;       
        try{
            con = DBConnection.getConnection();
            String query = "INSERT INTO hotel(name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,hotel.getName());
            pstmt.setString(2,hotel.getCity());
            pstmt.setString(3,hotel.getPhoneNumber());
            pstmt.setString(4,hotel.getAddress());
            pstmt.setString(5,hotel.getStatus());
            pstmt.setInt(6,hotel.getMaximum_capacity());
            pstmt.setInt(7,hotel.getAvailable_capacity());
            pstmt.setInt(8,hotel.getHotelOwner().getId());
            pstmt.setString(9,hotel.getCategory());
            pstmt.setString(10,hotel.getFeatures());
            pstmt.setDouble(11,hotel.getPrice());
            int n = pstmt.executeUpdate();
		return n>0?true:false;   
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
        return false;
	}
	
	public Hotel findHotelByName(String name){
		try{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			con = DBConnection.getConnection();
			String query = "select name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price from hotel where NAME=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Hotel h = new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new HotelOwner(rs.getInt(8)),rs.getString(9),rs.getString(10),rs.getDouble(11));
				return h;
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return null;
	}
	
	public List<Hotel> findHotelByCity(String city){
		List<Hotel> list =new ArrayList<>();
		try{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
			con = DBConnection.getConnection();
			String query = "select name,city,phone_number,address,status,maximum_capacity,available_capacity,hotel_owner_id,category,features,price from hotel where CITY=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, city);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Hotel h = new Hotel(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),new HotelOwner(rs.getInt(8)),rs.getString(9),rs.getString(10),rs.getDouble(11));
				list.add(h);
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return list;
	}
	
	public int getIdByName(String hotelName) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT id FROM hotel WHERE name=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, hotelName);
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
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0;
	}
	
	public int getMaxCapacityById(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT maximum_capacity FROM hotel WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
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
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0;
	}
	
	public int getAvailableCapacityById(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT available_capacity FROM hotel WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
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
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return 0;
	}
	
}
