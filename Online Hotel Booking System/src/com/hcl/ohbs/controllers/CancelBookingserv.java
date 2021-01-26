package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.dao.ReservationDAO;


@WebServlet("/CancelBookingserv")
public class CancelBookingserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ReservationDAO reserv =new ReservationDAO();
		
		out.println("<html><body>");
		if(reserv.deleteReservation(1)) {
			response.sendRedirect("Customer-Home.jsp");
		}
		else {
			out.println("<font color='red'>Internal Server Error!!!</font>");
		}
		out.println("</body></html>");
	}



}