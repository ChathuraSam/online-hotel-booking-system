package com.hcl.ohbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hcl.ohbs.entities.Hotel;

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
}
