package com.hcl.ohbs.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.dao.HotelDAO;
import com.hcl.ohbs.dao.HotelOwnerDAO;
import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.entities.HotelOwner;
import com.hcl.ohbs.services.HotelOwnerService;
@WebServlet("/AdminApproveOwnerRequest")
public class AdminApproveOwnerRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int ownerId = Integer.parseInt(request.getParameter("ownerId"));
		HotelOwnerService hotelOwnerService = new HotelOwnerService();
		HotelOwnerDAO hotelOwnerDao = new HotelOwnerDAO();
		HotelOwner hotelOwner = hotelOwnerDao.findOwnerById(ownerId);
		if(hotelOwnerService.updateStatus(hotelOwner)) {
			out.println("Successfully approved");
			request.getRequestDispatcher("ViewHotelOwnerRequests.jsp").forward(request, response);
		}else {
			out.println("Error in approving");
			request.getRequestDispatcher("ViewHotelOwnerRequests.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}