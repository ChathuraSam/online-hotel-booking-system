package com.hcl.ohbs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


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

}
