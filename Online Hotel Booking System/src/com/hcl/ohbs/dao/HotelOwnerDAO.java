package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.hcl.ohbs.entities.HotelOwner;
public class HotelOwnerDAO {
	
	public boolean addHotelOwner(HotelOwner hotelOwner) {
		Connection con = null;
        PreparedStatement pstmt = null;       
        try{
            con = DBConnection.getConnection();
            String query = "INSERT INTO hotel_owner(first_name,last_name,nic,phone_number,email,username,password) VALUES(?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,hotelOwner.getFistName());
            pstmt.setString(2,hotelOwner.getLastName());
            pstmt.setString(3,hotelOwner.getNic());
            pstmt.setString(4,hotelOwner.getPhoneNumber());
            pstmt.setString(5,hotelOwner.getEmail());
            pstmt.setString(6,hotelOwner.getUsername());
            pstmt.setString(7,hotelOwner.getPassword());
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
