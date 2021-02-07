package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.services.BookingService;

@WebServlet("/MakeReservation")
public class MakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int custId = (int) session.getAttribute("customerId");
		//String checkin = "05-02-2021";
		//String checkout="10-02-2021";
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		
		Date check_in_date=null;
		Date check_out_date =null;
		Date current_date = new Date();
		
	try {
		
		 	DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
			check_in_date = format.parse(checkin);
			check_out_date = format.parse(checkout);
			
			 			 
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//int noOfPersons = 300;
		int noOfPersons = Integer.parseInt(request.getParameter("number1"));
		//int customer = 1;
		int hotel = 1;

		out.println("<html><body>");
		BookingService book = new BookingService();
		if(check_in_date.compareTo(current_date)>0 || check_in_date.compareTo(current_date)==0) {
			if(check_in_date.compareTo(check_out_date)<0) {
				if(!book.checkAvailability(noOfPersons, hotel)) {
					out.println("<font>Not Avilable!!<font>");
				}
				else {
					if(book.booking(checkin,checkout,noOfPersons,custId,hotel)) {
						
						out.println("<font>Reservation added success!!<font>");
					}
					else {
						out.println("<font color='red'>Error in adding the reservation<font>");
						request.getRequestDispatcher("Customer-hotelBooking.jsp").include(request, response);
					}
				}
			}
			else {
				out.println("<font color='red'>Cannot reserv!!!checkin date is after checkout date</font>");
				request.getRequestDispatcher("Customer-hotelBooking.jsp").include(request, response);
			}
		}
		else {
			out.println("<font color='red'>Cannot Reserv!!! checkin date is before current date</font>");
			request.getRequestDispatcher("Customer-hotelBooking.jsp").include(request, response);
		}
		out.println("</boby></html>");
	}
}
