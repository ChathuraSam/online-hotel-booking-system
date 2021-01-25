package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.entities.Hotel;

@WebServlet("/SearchHotelByCity")
public class SearchHotelByCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String city = "colombo";
		
		HotelDAO dao = new HotelDAO();
		List<Hotel> hotellist =new ArrayList<>();
	
		hotellist = dao.findHotelByCity(city);
		
		out.println("<html><body>");
		for(Hotel h:hotellist) {
			out.println("<p>"+h.getName()+"</p>");
			out.println("<p>"+h.getFeatures()+"</p><br>");
		}

		out.println("</body></html>");
	}


}
