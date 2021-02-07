package com.hcl.ohbs.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.entities.HotelOwner;
import com.hcl.ohbs.services.HotelOwnerService;
@WebServlet("/AdminApproveOwnerRequest")
public class AdminApproveOwnerRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HotelOwnerService hotelOwnerService = new HotelOwnerService();
		List<HotelOwner> hotelOwnerList = hotelOwnerService.getAllHotelOwners();
		out.println("<html><body>");
		if(hotelOwnerList.isEmpty() || hotelOwnerList==null) {
			System.out.println("Owner list is empty");
		}else {
			for(HotelOwner hotelOwner: hotelOwnerList) {
				hotelOwner.getFistName();
				hotelOwner.getFistName();
				hotelOwner.getNic();
				hotelOwner.getPhoneNumber();
				hotelOwner.getEmail();
				hotelOwner.getStatus();
			}
		}
		
		/*if(hotelOwnerService.updateStatus(hotelOwner)) {
			System.out.println("Successfully approved");
		}else {
			System.out.println("Error in approving");
		}*/		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
