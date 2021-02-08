package com.hcl.ohbs.services;

import java.util.Date;
import java.util.List;

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.dao.RoomDAO;
import com.hcl.ohbs.entities.Customer;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.Reservation;
import com.hcl.ohbs.entities.Room;



public class ReservationService {

	public boolean checkAvailability(int noOfPersons, int roomId) {
		System.out.println("Begin checkAvailability: no of persons=" + noOfPersons + " room Id=" + roomId);
		RoomDAO roomDao = new RoomDAO();
		Room room = roomDao.getnoOfPersonsAndAvailablityById(roomId);	
		if(noOfPersons<=room.getNoOfPersons() && room.getIsAvailable()==1) {
			System.out.println("End checkAvailability: true");
			return true;
		}
		System.out.println("End checkAvailability: false");
		return false;
	}
	
	public boolean booking(String checkIn, String checkOut, int noOfPersons, int cid,int roomId) {
		boolean status=false;
		
		ReservationDAO reservation = new ReservationDAO();
		if(checkAvailability(noOfPersons,roomId)) {
			status = reservation.bookingRoom(new Reservation(checkIn,checkOut,noOfPersons,new Customer(cid),new Room(roomId)));
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
