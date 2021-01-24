package com.hcl.ohbs.services;
import com.hcl.ohbs.dao.HotelOwnerDAO;
import com.hcl.ohbs.entities.HotelOwner;
public class HotelOwnerService {
	
	public boolean registerHotelOwner(String fistName, String lastName, String nic, String phoneNumber, String email, String username, String password) {
		HotelOwnerDAO h = new HotelOwnerDAO();
		return h.addHotelOwner(new HotelOwner(fistName, lastName, nic, phoneNumber, email, username, password));
	}
	
	public boolean logInHotelOwner(String username, String password) {
		HotelOwnerDAO h = new HotelOwnerDAO();
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
		HotelOwnerDAO h = new HotelOwnerDAO();
		return h.findIdByUsernamePassword(username, password);
	}
}
