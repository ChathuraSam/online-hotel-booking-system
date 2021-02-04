package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.entities.Reservation;



@WebServlet("/ViewCustomerReservationServ")
public class ViewCustomerReservationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<Reservation> list = new ArrayList<>();
		
		ReservationDAO reservation = new ReservationDAO();
		
		//viewReservationById method should contains the logged in customer id
		list = reservation.viewReservationById(1);
		
		//get the customer name by logged in customer id
		CustomerDAO cust = new CustomerDAO();
		String fname = cust.getNameById(1);
		
		
		//get the hotel name by hotel id
		HotelDAO hotel = new HotelDAO();
		//String hname = hotel.getNameById(1);
		double price = hotel.getPriceById(1);
		
		out.println("<html><body>");
		out.println("<h1>My Reservation Details</h1>");
		out.println("<form action='CancelBookingserv' method='GET'>");
		out.println("<table border='1'>");
		out.println("<tr><th>Check In</th><th>Check Out</th><th>No of Persons</th><th>Reserved By</th><th>Hotel Name</th><th>Total Price</th></tr>");
		for(Reservation r:list) {
			String hname = hotel.getNameById((r.getHotel().getId()));
			out.println("<tr><td>"+r.getCheckIn()+"</td><td>"+r.getCheckOut()+"</td><td>"+r.getNoOfPersons()+"</td><td>"+fname+"</td><td>"+hname+"</td><td>"+price+"</td><td><a href='#'>Cancel Order</a></td></tr>");
		}
		out.println("</form>");
		out.println("</table>");
		out.println("</body></html>");
	}


}
