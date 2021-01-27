package com.hcl.ohbs.services;

import java.util.Date;
import java.util.List;

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.entities.Customer;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.Reservation;



public class BookingService {

	public boolean checkAvailability(int noOfPersons, int hid) {
		
		HotelDAO hotel = new HotelDAO();
		int max = hotel.getMaxCapacityById(hid);
		int available = hotel.getAvailableCapacityById(hid);
		
		if(noOfPersons<=available && noOfPersons<=max) {
			return true;
		}
		return false;
	}
	
	public boolean booking(String checkIn, String checkOut, int noOfPersons, int cid,int hid) {
		boolean status=false;
		
		ReservationDAO reservation = new ReservationDAO();
		if(checkAvailability(noOfPersons,hid)) {
			status = reservation.bookingHotel(new Reservation(checkIn,checkOut,noOfPersons,new Customer(cid),new Hotel(hid)));
		}
		
		if(status) {
			return true;
		}
		
		return false;
	}
	
	public List<Reservation> getReservationByOwnerId(int ownerId){
		ReservationDAO r = new ReservationDAO();
		return r.getReservationByOwnerId(ownerId);
	}
}
