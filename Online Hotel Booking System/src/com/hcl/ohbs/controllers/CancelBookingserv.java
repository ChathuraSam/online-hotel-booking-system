package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.dao.ReservationDAO;


@WebServlet("/CancelBookingserv")
public class CancelBookingserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ReservationDAO reserv =new ReservationDAO();
		
		HttpSession session = request.getSession();
		int custId = (int) session.getAttribute("customerId");
		
		out.println("<html><body>");
		if(reserv.deleteReservation(custId)) {
			System.out.println("delete order");
			response.sendRedirect("Customer-Home.jsp");
		}
		else {
			System.out.println("error page");
			out.println("<font color='red'>Internal Server Error!!!</font>");
		}
		out.println("</body></html>");
	}



}
