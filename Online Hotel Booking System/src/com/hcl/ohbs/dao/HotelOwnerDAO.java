package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hcl.ohbs.entities.HotelOwner;
public class HotelOwnerDAO {
	
	public boolean addHotelOwner(HotelOwner hotelOwner) {
		Connection con = null;
        PreparedStatement pstmt = null;       
        try{
            con = DBConnection.getConnection();
            String query = "INSERT INTO hotel_owner(first_name,last_name,nic,phone_number,email,username,password,status) VALUES(?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,hotelOwner.getFistName());
            pstmt.setString(2,hotelOwner.getLastName());
            pstmt.setString(3,hotelOwner.getNic());
            pstmt.setString(4,hotelOwner.getPhoneNumber());
            pstmt.setString(5,hotelOwner.getEmail());
            pstmt.setString(6,hotelOwner.getUsername());
            pstmt.setString(7,hotelOwner.getPassword());
            pstmt.setInt(8,hotelOwner.getStatus());
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
	public int findIdByUsernamePassword(String username, String password){       
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			String query = "SELECT id FROM hotel_owner WHERE username=? AND password=?";
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
	
	public int findStatusByUsernamePassword(String username, String password){
		System.out.println("Begin findStatusByUsernamePassword: username=" + username + " passowrd=" + password);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int status = 0;
		try{
			con = DBConnection.getConnection();
			String query = "SELECT status FROM hotel_owner WHERE username=? AND password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				status = rs.getInt(1);
				System.out.println("status1 = " + status);
			}
			System.out.println("status2 = " + status);
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
		System.out.println("End findStatusByUsernamePassword: status3=" + status);
	    return status;
	}
	
	public HotelOwner logInHotelOwner(String username) {
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        HotelOwner hotelOwner = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT * FROM hotel_owner WHERE username=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	hotelOwner = new HotelOwner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
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
        return hotelOwner;
	}
	
	public boolean deleteHotelOwner(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;      
		try{
			con = DBConnection.getConnection();
			String query = "DELETE FROM hotel_owner WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
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
	
	public boolean updateUser(HotelOwner hotelOwner){		
        Connection con = null;
        PreparedStatement pstmt = null;      
        try{
            con = DBConnection.getConnection();
            String query = "UPDATE hotel_owner SET first_name=?,last_name=?,nic=?,phone_number=?,email=?,username=?,password=? WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,hotelOwner.getFistName());
            pstmt.setString(2,hotelOwner.getLastName());
            pstmt.setString(3,hotelOwner.getNic());
            pstmt.setString(4,hotelOwner.getPhoneNumber());
            pstmt.setString(5,hotelOwner.getEmail());
            pstmt.setString(6,hotelOwner.getUsername());
            pstmt.setString(7,hotelOwner.getPassword());
            pstmt.setInt(8,hotelOwner.getId());
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
	public String findNameByUsernamePassword(String username, String password){       
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = DBConnection.getConnection();
			String query = "SELECT first_name FROM hotel_owner WHERE username=? AND password=?";
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
	
	public List<HotelOwner> getAllHotelOwners() {		
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        List<HotelOwner> list = new ArrayList<>();        
        try{  
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String query = "SELECT id,first_name,last_name,nic,phone_number,email,status from hotel_owner";
            rs = stmt.executeQuery(query);         
            while(rs.next()){
            	HotelOwner hotelOwner = new HotelOwner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(hotelOwner);
            }
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();
            }catch(SQLException e3){
                e3.printStackTrace();
            }
        }        
        return list;
	}
	
	public boolean updateStatus(HotelOwner hotelOwner){		
        Connection con = null;
        PreparedStatement pstmt = null;      
        try{
            con = DBConnection.getConnection();
            String query = "UPDATE hote_owner SET status=1 WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,hotelOwner.getId());
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
	
	public HotelOwner findOwnerById(int id){       
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HotelOwner hotelOwner = null;
		try{
			con = DBConnection.getConnection();
			String query = "SELECT * FROM hotel_owner WHERE username=? AND password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				hotelOwner = new HotelOwner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
	    return hotelOwner;
	}
}
