package com.hcl.ohbs.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.services.HotelService;
@WebServlet("/OwnerViewHotel")
public class OwnerViewHotel extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// recieve the id from coming from the session and assign into id variable
		HttpSession session = request.getSession();
		int ownerId = (int) session.getAttribute("hotelOwnerId");
		System.out.println("owner id in add hotel page = " + ownerId);
		String hotelOwnerName = (String) session.getAttribute("hotelOwnerName");
		System.out.println("owner name in add hotel page = " + hotelOwnerName);
		HotelService hotelService = new HotelService();
		List<Hotel> hotelList = hotelService.getHotelsByOwnerId(ownerId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
