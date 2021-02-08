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
import com.hcl.ohbs.entities.Room;
import com.hcl.ohbs.services.HotelService;
import com.hcl.ohbs.services.RoomService;
@WebServlet("/HotelBooking")
public class HotelBooking extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int roomId = Integer.parseInt(request.getParameter("roomId"));
		HttpSession session = request.getSession();
		/*if(session.getAttribute("customerId")==null) {
			System.out.println("Guest");
			out.println("<font color='red'>Log in or Sign up before continue<font>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			System.out.println("Customer");*/
			session.setAttribute("roomId",roomId);
	 		request.getRequestDispatcher("Customer-hotelBooking.jsp").forward(request, response);
		//}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
