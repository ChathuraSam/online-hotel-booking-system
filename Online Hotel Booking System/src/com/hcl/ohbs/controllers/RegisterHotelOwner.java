package com.hcl.ohbs.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.entities.Hotel;
import com.hcl.ohbs.services.HotelOwnerService;
@WebServlet("/RegisterHotelOwner")
public class RegisterHotelOwner extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String confirmPassword = request.getParameter("confirmPassword");
		out.println("<html><boby>");
		HotelOwnerService hotelOwnerService = new HotelOwnerService();
		if(hotelOwnerService.registerHotelOwner(firstName, lastname, nic, phone, email, username, password)) {		
			HttpSession session = request.getSession();
	    	//int sessionId = (int) session.getAttribute("id");
	    	int sessionId = hotelOwnerService.getIdByUsernameAndPassword(username, password);
			/*if(id>0) {
				out.println("<font>hotel owner registration success!!<font>");
			}else{
				out.println("<font color='red'>internal error! try again!<font>");
			}*/
			//call ownerHome.jsp and pass the id in session
			session.setAttribute("hotelOwnerId", sessionId);
			session.setAttribute("hotelOwnerName", firstName);
			List<Hotel> hotelList = null;
			request.setAttribute("hotels", hotelList);
			request.getRequestDispatcher("Owner-homepage.jsp").include(request, response);
		}else {
			out.println("<font color='red'>Error in registering the hotel owner<font>");
			request.getRequestDispatcher("Owner-signup.jsp").include(request, response);			
		}
		out.println("</boby><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}