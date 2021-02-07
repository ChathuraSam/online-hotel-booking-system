package com.hcl.ohbs.services;
import java.util.List;

import com.hcl.ohbs.dao.HotelOwnerDAO;
import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.entities.HotelOwner;
public class HotelOwnerService {
	HotelOwnerDAO h;
	
	public HotelOwnerService() {
		h = new HotelOwnerDAO();
	}

	public boolean registerHotelOwner(String fistName, String lastName, String nic, String phoneNumber, String email, String username, String password, int status) {	
		return h.addHotelOwner(new HotelOwner(fistName, lastName, nic, phoneNumber, email, username, password, 0));
	}
	
	public boolean logInHotelOwner(String username, String password) {
		boolean isLogInSuccess = false;
		if(h.logInHotelOwner(username)==null) {
			System.out.println("Incorrect username");
			isLogInSuccess = false;
		}else if(!h.logInHotelOwner(username).getPassword().equals(password)) {
			System.out.println("username and passwrod not matching");
			isLogInSuccess = false;
		}else{
			System.out.println("log in success");
			isLogInSuccess = true;
		}
		return isLogInSuccess;
	}
	
	public int getIdByUsernameAndPassword(String username, String password) {
		return h.findIdByUsernamePassword(username, password);
	}
	
	public int getStatusByUsernameAndPassword(String username, String password) {
		return h.findStatusByUsernamePassword(username, password);
	}
	
	public String getNameByUsernameAndPassword(String username, String password) {
		return h.findNameByUsernamePassword(username, password);
	}
	
	public List<HotelOwner> getAllHotelOwners() {
		return h.getAllHotelOwners();
	}
	
	public boolean updateStatus(HotelOwner hotelOwner) {
		return h.updateStatus(hotelOwner);
	}
}
