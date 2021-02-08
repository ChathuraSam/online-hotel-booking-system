package com.hcl.ohbs.services;
import java.util.List;

import com.hcl.ohbs.dao.RoomDAO;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.Room;
public class RoomService {
	private RoomDAO roomDao;	
	public RoomService() {
		roomDao = new RoomDAO();
	}
	public boolean addRoomAndImages(String name, Double price, String features, int noOfPersons, 
										int isAvailable, Hotel hotel, String imagePath) { 
		System.out.println("Begin addRoomAndImages: ");
		//HotelImageDAO hImage = new HotelImageDAO();
		boolean isAddRoomSuccess = roomDao.addRoom(new Room(name, price, features, noOfPersons, isAvailable, hotel));
		System.out.println("Is add room succes: " + isAddRoomSuccess);
		int roomId = roomDao.getRoomIdByName(name);
		/*for(String imagePath: images) {
			isAddHotelImageSuccess = hImage.addHotelImage(new HotelImage(new Hotel(hotelId),imagePath));
			if(!isAddHotelImageSuccess) {
				break;
			}
		}*/
		//boolean isAddHotelImageSuccess = hImage.addHotelImage(new HotelImage(new Hotel(hotelId),imagePath));
		//System.out.println("Is add image succes: " + isAddHotelImageSuccess);
		//if(isAddHotelImageSuccess && isAddHotelImageSuccess) {
		if(isAddRoomSuccess) {
			System.out.println("End addRoomAndImages: ");
			return true;
		}else {
			System.out.println("End addRoomAndImages: ");
			return false;
		}
	}
	
	public List<Room> getAllRoomsByHotelId(int hotelId){
		return roomDao.getAllRoomsByHotelId(hotelId);
	}
	
	public boolean updateAvailability(int roomId){
		return roomDao.updateIsAvailablity(roomId);
	}
	
	public int getHotelIdByRoomID(int roomId){
		return roomDao.getHotelIdByRoomId(roomId);
	}
	
	public String getNameById(int roomId){
		return roomDao.getNameById(roomId);
	}
	
	public Double getPriceById(int roomId){
		return roomDao.getPriceById(roomId);
	}
	
	public Room getRoomById(int roomId){
		return roomDao.getRoomById(roomId);
	}
}
