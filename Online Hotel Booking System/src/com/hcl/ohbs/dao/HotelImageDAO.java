package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hcl.ohbs.entities.HotelImage;
public class HotelImageDAO {
	public boolean addHotelImage(HotelImage hotelImage) {
		Connection con = null;
        PreparedStatement pstmt = null;       
        try{
            con = DBConnection.getConnection();
            String query = "INSERT INTO hotel_image VALUES(?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,hotelImage.getHotel().getId());
            pstmt.setString(2,hotelImage.getImages());
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
	
	public String getImagePathByHotelId(int id) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT images FROM hotel_image WHERE hotel_id=?";
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
                if(rs!=null)
                    rs.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        } 
        return null;
	}
}
