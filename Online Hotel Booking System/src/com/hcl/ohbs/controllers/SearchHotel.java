package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.entities.Hotel;


@WebServlet("/SearchHotel")
public class SearchHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hotelName = request.getParameter("hotelName");
		String city = request.getParameter("city");
		
		HotelDAO dao = new HotelDAO();
		
		List<Hotel> hotellist =new ArrayList<>();
		hotellist = dao.getAllHotels();
		for(Hotel h : hotellist) {
			System.out.println(h);
		}
		
		// hotel and city both
		if(hotelName !="" && city!="") {
			
		}
		
		//hotel name only
		else if(hotelName !="" && city=="") {
			hotellist =new ArrayList<>();
			hotellist= dao.findHotelByName(hotelName);
			request.setAttribute("hotels", hotellist);
			request.setAttribute("msg", "City Name only");
			request.getRequestDispatcher("Customer-Home.jsp").include(request, response);
			
		//city name only
		}else if(hotelName =="" && city!="") {
			
			hotellist =new ArrayList<>();
			hotellist = dao.findHotelByCity(city);
			request.setAttribute("hotels", hotellist);
			request.setAttribute("msg", "City Name only");
			request.getRequestDispatcher("Customer-Home.jsp").include(request, response);
			
		// both hotel name and city are empty
		}else {
			hotellist = dao.getAllHotels();
			if(hotellist.size()==0) {
				request.setAttribute("error", "No hotels availabl");
			}else {
				request.setAttribute("error", "No error");
				request.setAttribute("hotels", hotellist);
			}
			
			request.getRequestDispatcher("Customer-Home.jsp").include(request, response);
			
		}
			
		
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
