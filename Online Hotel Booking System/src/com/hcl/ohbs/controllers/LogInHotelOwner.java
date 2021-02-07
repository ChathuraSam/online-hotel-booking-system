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
import com.hcl.ohbs.services.HotelOwnerService;
import com.hcl.ohbs.services.HotelService;
@WebServlet("/LogInHotelOwner")
public class LogInHotelOwner extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start Log in hotel owner servlet");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		out.println("<html><boby>");
		HotelOwnerService hotelOwnerService = new HotelOwnerService();		
		if(hotelOwnerService.logInHotelOwner(username, password)) {
			HttpSession session = request.getSession();
		    int sessionId = hotelOwnerService.getIdByUsernameAndPassword(username, password);
		    String sessionName = hotelOwnerService.getNameByUsernameAndPassword(username, password);
			session.setAttribute("hotelOwnerId", sessionId);
			session.setAttribute("hotelOwnerName", sessionName);
			HotelService hotelService = new HotelService();			
			List<Hotel> hotelList = hotelService.getHotelsByOwnerId(sessionId);
			request.setAttribute("hotels", hotelList);
			request.setAttribute("OwnerName", sessionName);
			out.println("<font>hotel owner login success!!<font>");
			System.out.println("end Log in hotel owner servlet");
			request.getRequestDispatcher("Owner-homepage.jsp").include(request, response);
		}else {
			out.println("<font color='red'>Error in login the hotel owner<font>");
			System.out.println("end Log in hotel owner servlet");
			request.getRequestDispatcher("Owner-Login.jsp").include(request, response);
		}
		out.println("</boby><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
