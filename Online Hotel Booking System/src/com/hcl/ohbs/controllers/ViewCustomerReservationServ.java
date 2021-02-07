package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.entities.Reservation;
import com.hcl.ohbs.services.RoomService;



@WebServlet("/ViewCustomerReservationServ")
public class ViewCustomerReservationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<Reservation> list = new ArrayList<>();
		ReservationDAO reservationDao = new ReservationDAO();
		RoomService roomService = new RoomService();
		HttpSession session = request.getSession();
		int custId = (int) session.getAttribute("customerId");
		//viewReservationById method should contains the logged in customer id
		list = reservationDao.viewReservationById(custId);
		
		//get the customer name by logged in customer id
		CustomerDAO cust = new CustomerDAO();
		String fname = cust.getNameById(custId);
		
		
		//get the hotel name by hotel id
		HotelDAO hotel = new HotelDAO();
		//String hname = hotel.getNameById(1);
		//double price = hotel.getPriceById(custId);
		
		out.println("<html><body>");
		out.println("<h1>My Reservation Details</h1>");
		out.println("<form action='CancelBookingserv' method='GET'>");
		out.println("<table border='1'>");
		out.println("<tr><th>Check In</th><th>Check Out</th><th>No of Persons</th><th>Reserved By</th><th>Hotel Name</th><th>Room Name</th><th>Price</th></tr>");
		for(Reservation r:list) {
			int roomId = r.getRoom().getId();
			int hotelId = roomService.getHotelIdByRoomID(roomId);
			String hname = hotel.getNameById(hotelId);
			String roomName = roomService.getNameById(roomId);
			Double price = r.getRoom().getPrice();
			out.println("<tr><td>"+r.getCheckIn()+"</td><td>"+r.getCheckOut()+"</td><td>"+r.getNoOfPersons()+"</td><td>"+fname+"</td><td>"+hname+"</td><td>"+roomName+"</td><td>"+price+"</td><td><a href='CancelBookingserv'>Cancel Order</a></td></tr>");
		}		
		out.println("</form>");
		out.println("</table>");
		out.println("</body></html>");		
		RequestDispatcher disp = request.getRequestDispatcher("MyBookings.jsp");
		disp.forward(request, response);		
	}
}
