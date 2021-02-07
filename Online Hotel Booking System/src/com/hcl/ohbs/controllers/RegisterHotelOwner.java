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
		System.out.println("Start RegisterHotelOwner");
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("cpassword");
		out.println("<html><boby>");
		if(!phone.matches("^07[0-9]{8}$")){
			out.println("<center><font color='red'><B>Phone Number is invalid!</B></font>");
			request.getRequestDispatcher("Owner-signup.jsp").include(request, response);
		}else if(!nic.matches("^[0-9]{9}[vVxX]$") && !nic.matches("^[0-9]{12}$")){
			out.println("<center><font color='red'><B>NIC is invalid!</B></font>");
			request.getRequestDispatcher("Owner-signup.jsp").include(request, response);
		}else if(!email.matches("^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$")){
			out.println("<center><font color='red'><B>Email is invalid!</B></font>");
			request.getRequestDispatcher("Owner-signup.jsp").include(request, response);
		}else if(!confirmPassword.equals(password)) {
			out.println("<center><font color='red'><B>Confirm Password & Password should match</B></font>");
			request.getRequestDispatcher("Owner-signup.jsp").include(request, response);
		}else {
			HotelOwnerService hotelOwnerService = new HotelOwnerService();
			if(hotelOwnerService.registerHotelOwner(firstName, lastname, nic, phone, email, username, password,0)) {		
				/*HttpSession session = request.getSession();
				//int sessionId = (int) session.getAttribute("id");
				int sessionId = hotelOwnerService.getIdByUsernameAndPassword(username, password);
				session.setAttribute("hotelOwnerId", sessionId); //call ownerHome.jsp and pass the id in session
				session.setAttribute("hotelOwnerName", firstName);
				List<Hotel> hotelList = null;
				request.setAttribute("hotels", hotelList);
				request.getRequestDispatcher("Owner-homepage.jsp").include(request, response);*/
				out.println("<font color='red'>Your request is pending<font>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}else {
				out.println("<font color='red'>Error in registering the hotel owner<font>");
				request.getRequestDispatcher("Owner-signup.jsp").include(request, response);			
			}
		}
		out.println("</boby><html>");
		System.out.println("End RegisterHotelOwner");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}