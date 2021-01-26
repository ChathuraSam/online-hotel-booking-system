package com.hcl.ohbs.services;

import java.util.List;

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.HotelImageDAO;
import com.hcl.ohbs.dao.HotelOwnerDAO;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelImage;
import com.hcl.ohbs.entities.HotelOwner;
public class HotelService {
	HotelDAO h;
	public boolean addHotelAndImages(String name, String city, String phoneNumber, String address, String status, int maximum_capacity, int available_capacity, int id,
								String category, String features, double price, String imagePath) { 
		h = new HotelDAO();
		HotelImageDAO hImage = new HotelImageDAO();
		boolean isAddHotelSuccess = h.addHotel(new Hotel(name, city, phoneNumber, address, status, maximum_capacity, available_capacity, new HotelOwner(id), category, features, price));
		System.out.println("Is add hotel succes: " + isAddHotelSuccess);
		int hotelId = h.getIdByName(name);
		/*for(String imagePath: images) {
			isAddHotelImageSuccess = hImage.addHotelImage(new HotelImage(new Hotel(hotelId),imagePath));
			if(!isAddHotelImageSuccess) {
				break;
			}
		}*/
		boolean isAddHotelImageSuccess = hImage.addHotelImage(new HotelImage(new Hotel(hotelId),imagePath));
		System.out.println("Is add image succes: " + isAddHotelImageSuccess);
		if(isAddHotelImageSuccess && isAddHotelImageSuccess) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Hotel> getHotelsByOwnerId(int ownerId){
		h = new HotelDAO();
		return h.findHotelByOwnerId(ownerId);
	}
}