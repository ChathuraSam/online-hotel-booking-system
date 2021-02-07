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
@WebServlet("/ViewRoomDetails")
public class ViewRoomDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HotelService hotelService = new HotelService();
		RoomService roomService = new RoomService();
		HttpSession session = request.getSession();
		int hotelId = Integer.parseInt(request.getParameter("hotelid"));
		Hotel hotel = hotelService.getHotelDetailsById(hotelId);		
 		session.setAttribute("hotelId",hotelId);
 		request.setAttribute("hotelDetails", hotel);
 		List<Room> roomList = roomService.getAllRoomsByHotelId(hotelId);
 		request.setAttribute("roomList", roomList);
 		request.getRequestDispatcher("Room-Details.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
