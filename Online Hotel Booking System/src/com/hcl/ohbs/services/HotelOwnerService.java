package com.hcl.ohbs.services;
import com.hcl.ohbs.dao.HotelOwnerDAO;
import com.hcl.ohbs.entities.HotelOwner;
public class HotelOwnerService {
	
	public boolean registerHotelOwner() {
		HotelOwnerDAO h = new HotelOwnerDAO();
		return h.addHotelOwner(new HotelOwner("Shanuka", "Hettiarachchi", "946786934V", "0715678974", "abc@gmail.com", "username", "password"));
	}
}
