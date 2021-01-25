package com.hcl.ohbs.controllers;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.entities.HotelOwner;
import com.hcl.ohbs.services.HotelOwnerService;
import com.hcl.ohbs.services.HotelService;
@WebServlet("/AddHotel")
public class AddHotel extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><boby>");
		HotelService hotelService = new HotelService();
		String[] images = {"path of image 1","path of image 2"};
		//recieve the id from coming from the session and assign into id variable
		//HttpSession session = request.getSession();
    	//int ownerId = (int) session.getAttribute("id");
		int ownerId = 1;
		if(hotelService.addHotelAndImages("HotelA", "Nugegoda", "0756789364", "abc", "status", 1000, 450, ownerId, "World class", "feature1,feature2", 5000.00, images)) {
			out.println("<font>hotel added success!!<font>");
		}else {
			out.println("<font color='red'>Error in adding the hotel<font>");
		}
		out.println("</boby><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
