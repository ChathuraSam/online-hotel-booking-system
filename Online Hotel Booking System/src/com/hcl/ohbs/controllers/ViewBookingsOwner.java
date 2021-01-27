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
import com.hcl.ohbs.entities.Reservation;
import com.hcl.ohbs.services.BookingService;
import com.hcl.ohbs.services.HotelService;
import com.hcl.ohbs.services.RegisterCustomerService;
@WebServlet("/ViewBookingsOwner")
public class ViewBookingsOwner extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start owner view bookings servlet");
		PrintWriter out = response.getWriter();
		RegisterCustomerService custmerService = new RegisterCustomerService();
		HotelService hotelService = new HotelService();
		// recieve the id from coming from the session and assign into id variable
		HttpSession session = request.getSession();
		int ownerId = (int) session.getAttribute("hotelOwnerId");
		System.out.println("owner id in view booking page = " + ownerId);
		String hotelOwnerName = (String) session.getAttribute("hotelOwnerName");
		System.out.println("owner name in view booking page = " + hotelOwnerName);
		BookingService bookingService = new BookingService();
		List<Reservation> reservationList = bookingService.getReservationByOwnerId(ownerId);
		for(Reservation r:reservationList) {
			r.setCustomer(custmerService.getCustomerById(r.getCustomer().getId()));
			r.setHotel(new Hotel(hotelService.getHotelNameById(r.getHotel().getId())));
			System.out.println(r);
		}
		request.setAttribute("bookings", reservationList);
		out.println("<font>view booking success!!<font>");
		System.out.println("end owner view bookings servlet");
		request.getRequestDispatcher("Owner-updateViewHotels.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
