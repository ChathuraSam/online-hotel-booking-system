package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hcl.ohbs.entities.Room;
public class RoomDAO {
	public boolean addRoom(Room room) {
		System.out.println("Begin addRoom DAO: Room=" + room);
		Connection con = null;
        PreparedStatement pstmt = null;       
        try{
            con = DBConnection.getConnection();            
            String query = "INSERT INTO room(name,price,features,no_of_persons,isAvailable,hotel_id) VALUES(?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,room.getName());
            pstmt.setDouble(2,room.getPrice());
            pstmt.setString(3,room.getFeatures());
            pstmt.setInt(4,room.getNoOfPersons());
            pstmt.setInt(5,room.getIsAvailable());
            pstmt.setInt(6,room.getHotel().getId());
            int n = pstmt.executeUpdate();
            System.out.println("End addRoom DAO: n=" + n);
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
        System.out.println("End addRoom DAO: ");
        return false;
	}
	
	public int getRoomIdByName(String roomName) {
		System.out.println("Begin getRoomIdByName : Room Name=" + roomName);
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT id FROM room WHERE name=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, roomName);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	int id = rs.getInt(1);
            	System.out.println("End getRoomIdByName : Room Id=" + id);
                return id;
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
        System.out.println("End getRoomIdByName : Room Id=0");
        return 0;
	}
}
