package com.hcl.ohbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.hcl.ohbs.entities.Customer;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelOwner;
import com.hcl.ohbs.entities.Invoice;
import com.hcl.ohbs.entities.Reservation;
import com.hcl.ohbs.entities.Room;



public class InvoiceDAO {
	
	
	public boolean generateInvoice(Invoice i) {
		
		try {
			//make the connection
			Connection con=DBConnection.getConnection();
			PreparedStatement pmt=null;
			String query=null;
			

				query="insert into invoice(date_generated,total_amount,customer_id,reservation_id) values (SYSDATE ,?,?,?)";
				pmt=con.prepareStatement(query);
				pmt.setDouble(1, i.getTotalAmount());
				pmt.setInt(2,i.getCustomerId());
				pmt.setInt(3, i.getReservationId());
				

				
				//execute the query
				int n=pmt.executeUpdate();
			    return n>0?true:false;
			}
			catch(SQLException se) {se.printStackTrace();}
			catch(ClassNotFoundException cls) {cls.printStackTrace();}
			return false;
			
			
		}

	public List<Integer> getRoomsById(int CustomerId){
		List<Integer> list =new ArrayList<>();
		try{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
			con = DBConnection.getConnection();
			String query = "select room_id from reservation where customer_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, CustomerId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Integer i = new Integer(rs.getInt(1));
				list.add(i);
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return list;
	}
	
	public Double getPriceByRoomId(int RoomId){
		Double price=0.0;
		try{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
			con = DBConnection.getConnection();
			String query = "select price from room where id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, RoomId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//Double d = new Double(rs.getDouble(1));
				price = rs.getDouble(1);
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return price;
	}
	
	public List<Reservation> getReservationByCustomerId(int CustomerId){
        List<Reservation> list =new ArrayList<>();
        try{
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
            con = DBConnection.getConnection();
            String query = "select * from reservation where customer_id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, CustomerId);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Reservation r = new Reservation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),new Customer(rs.getInt(5)),new Room(rs.getInt(6)));
                list.add(r);
                
            }
        }catch(ClassNotFoundException e1){
                e1.printStackTrace();
        }catch(SQLException e2){
                e2.printStackTrace();
        }
        return list;
    }
	
	public Invoice getInvoiceByCustomerId(int id){       
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Invoice invoice = null;
		try{
			con = DBConnection.getConnection();
			String query = "SELECT id,date_generated,total_amount,customer_id,reservation_id FROM invoice WHERE customer_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				invoice = new Invoice(rs.getInt(1),rs.getDate(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5));
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
	    return invoice;
	}
}
