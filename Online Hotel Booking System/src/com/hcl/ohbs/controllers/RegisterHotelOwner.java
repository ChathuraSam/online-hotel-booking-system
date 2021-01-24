package com.hcl.ohbs.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hcl.ohbs.services.HotelOwnerService;
@WebServlet("/RegisterHotelOwner")
public class RegisterHotelOwner extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><boby>");
		HotelOwnerService hotelOwnerService = new HotelOwnerService();
		if(hotelOwnerService.registerHotelOwner()) {
			out.println("<font>hotel owner registration success!!<font>");
		}else {
			out.println("<font color='red'>Error in registering the hotel owner<font>");
		}
		out.println("</boby><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}