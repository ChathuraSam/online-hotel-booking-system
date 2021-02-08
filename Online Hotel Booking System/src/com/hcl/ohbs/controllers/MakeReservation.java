package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
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
import com.hcl.ohbs.services.ReservationService;
import com.hcl.ohbs.services.RoomService;

@WebServlet("/MakeReservation")
public class MakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside /MakeReservation");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int custId = (int) session.getAttribute("customerId");
		int hotel = (int) session.getAttribute("hotelId");				
		//String checkin = "05-02-2021";
		//String checkout="10-02-2021";
		String checkin = request.getParameter("checkin");
        String checkout = request.getParameter("checkout");
        
        Date check_in_date=null;
        Date check_out_date =null;
        Date current_date = new Date();
        
    try {
        
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
            check_in_date = format.parse(checkin);
            check_out_date = format.parse(checkout);
            
                          
        } catch (ParseException e) {
            e.printStackTrace();
        }
		//int noOfPersons = 300;
		int noOfPersons = Integer.parseInt(request.getParameter("number1"));
		int roomId = (int) session.getAttribute("roomId");
		System.out.println(roomId);
		//int roomId = Integer.parseInt();
		//int customer = 1;
		//int hotel = 1;
		//int roomId = 1;

		out.println("<html><body>");
		ReservationService book = new ReservationService();
		RoomService roomService = new RoomService();
		if(check_in_date.compareTo(current_date)>0 || check_in_date.compareTo(current_date)==0) {
			if(check_in_date.compareTo(check_out_date)<0) {
				if(!book.checkAvailability(noOfPersons, roomId)) {
					out.println("<font>Not Avilable!!<font>");
					request.getRequestDispatcher("Room-Details.jsp").include(request, response);
				}
				else {
					if(book.booking(checkin,checkout,noOfPersons,custId,roomId)) {
						if(roomService.updateAvailability(roomId)) {
							int hotelId = (int) session.getAttribute("hotelId");
					 		List<Room> roomList = roomService.getAllRoomsByHotelId(hotelId);
					 		session.setAttribute("roomList", roomList);							
							out.println("<font>Reservation added success!!<font>");
							request.getRequestDispatcher("Room-Details.jsp").include(request, response);
						}else {
							out.println("<font color='red'>Error in updating room availability<font>");
							request.getRequestDispatcher("Customer-hotelBooking.jsp").include(request, response);
						}
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
