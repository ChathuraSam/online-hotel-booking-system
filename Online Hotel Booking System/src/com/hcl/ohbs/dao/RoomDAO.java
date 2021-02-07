package com.hcl.ohbs.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelOwner;
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
	
	public List<Room> getAllRoomsByHotelId(int id){
		System.out.println("Begin findRoomByHotelId: hotel id=" + id);
		List<Room> list =new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Room room = null;
		try{
			con = DBConnection.getConnection();
			String query = "select * from room where hotel_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				room = new Room(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
				list.add(room);
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
		System.out.println("Begin findRoomByHotelId: Room = " + room);
	    return list;
	}
	
	public Room getnoOfPersonsAndAvailablityById(int id) {
		System.out.println("Begin getnoOfPersonsAndAvailablityById : Room Id=" + id);
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Room room = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT NO_OF_PERSONS,ISAVAILABLE FROM room WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	room = new Room(rs.getInt(1), rs.getInt(2));
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
        System.out.println("End getnoOfPersonsAndAvailablityById : Room=" + room);
        return room;
	}
	
	//update isAvailablity into 0, when reservation made
	public boolean updateIsAvailablity(int roomId){		
        Connection con = null;
        PreparedStatement pstmt = null;      
        try{
            con = DBConnection.getConnection();
            String query = "UPDATE room SET ISAVAILABLE=0 WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,roomId);
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
	
	public int getHotelIdByRoomId(int roomId) {
		System.out.println("Begin getHotelIdByRoomId : Room id=" + roomId);
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id = 0;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT hotel_id FROM room WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, roomId);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	id = rs.getInt(1);
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
        System.out.println("End getHotelIdByRoomId : hotel Id=" + id);
        return id;
	}
	
	public String getNameById(int roomId) {
		System.out.println("Begin getNameById : Room id=" + roomId);
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String name = null;
        try{
            con = DBConnection.getConnection();
            String query = "SELECT name FROM room WHERE id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, roomId);
            rs = pstmt.executeQuery();
            if(rs.next()){
            	name = rs.getString(1);
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
        System.out.println("End getNameById : Room name=" + name);
        return name;
	}
	
	public Room getRoomById(int id){
		System.out.println("Begin getRoomById: room id=" + id);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Room room = null;
		try{
			con = DBConnection.getConnection();
			String query = "select * from room where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				room = new Room(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getInt(6), new Hotel(rs.getInt(7)));
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
		System.out.println("Begin findRoomByHotelId: Room = " + room);
	    return room;
	}
}
