package com.hcl.ohbs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.ohbs.entities.Customer;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelOwner;
import com.hcl.ohbs.entities.Reservation;

public class ReservationDAO {
	
	public boolean bookingHotel(Reservation r) {
		
	try {
		//make the connection
		Connection con=DBConnection.getConnection();
		PreparedStatement pmt=null;
		String query=null;
		
		
			//query to add reservation details to the database
			query="insert into reservation(check_in,check_out,no_of_persons,customer_id,hotel_id) values (?,?,?,?,?)";
			pmt=con.prepareStatement(query);
			pmt.setString(1, r.getCheckIn());
			pmt.setString(2, r.getCheckOut());
			pmt.setInt(3,r.getNoOfPersons());
			pmt.setInt(4, r.getCustomer().getId());
			pmt.setInt(5, r.getHotel().getId());

			
			//execute the query
			int n=pmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se) {se.printStackTrace();}
		catch(ClassNotFoundException cls) {cls.printStackTrace();}
		return false;
		
		
	}
	
	public List<Reservation> viewReservationById(int id){
		List<Reservation> list =new ArrayList<>();
		try{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
			con = DBConnection.getConnection();
			String query = "select check_in,check_out,no_of_persons,customer_id,hotel_id from reservation where customer_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Reservation r = new Reservation(rs.getString(1),rs.getString(2),rs.getInt(3),new Customer(rs.getInt(4)),new Hotel(rs.getInt(5)));
				list.add(r);
				
			}
	    }catch(ClassNotFoundException e1){
	            e1.printStackTrace();
	    }catch(SQLException e2){
	            e2.printStackTrace();
	    }
	    return list;
	}
	
	public boolean deleteReservation(int id) {
		System.out.println("start delete reservation......");
		Connection con = null;
		PreparedStatement pstmt = null;    
		int n=0;
		try{
			con = DBConnection.getConnection();
			String query = "DELETE FROM reservation WHERE id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			n = pstmt.executeUpdate();
			System.out.println("delete 1"+n);
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
		System.out.println("delete "+n);
		return false; 
	}
	
	public List<Reservation> getReservationByOwnerId(int ownerId){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reservation> list = new ArrayList<>();
		try{
			con = DBConnection.getConnection();
			String query = "select reservation.check_in,reservation.check_out,reservation.no_of_persons,reservation.customer_id,reservation.hotel_id FROM reservation,hotel WHERE reservation.hotel_id=hotel.id AND hotel.hotel_owner_id=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ownerId);
			rs = pstmt.executeQuery(); 
			while(rs.next()){
				Reservation r = new Reservation(rs.getString(1),rs.getString(2),rs.getInt(3),new Customer(rs.getInt(4)),new Hotel(rs.getInt(5)));
				list.add(r);					
			}
		}catch(ClassNotFoundException e1){
		            e1.printStackTrace();
		}catch(SQLException e2){
		            e2.printStackTrace();
		}		
		return list;		
	}

}
