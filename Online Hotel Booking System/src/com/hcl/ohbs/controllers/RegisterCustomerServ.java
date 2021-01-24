package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.services.HotelOwnerService;
import com.hcl.ohbs.services.RegisterCustomerService;

@WebServlet("/RegisterCustomerServ")
public class RegisterCustomerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("inputAddress");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
	
		
		PrintWriter out = response.getWriter();
		out.println("<html><boby>");
		RegisterCustomerService custService = new RegisterCustomerService();
		if(custService.registerCustomer(firstName, lastname, phone, address, email, username, password, confirmPassword )) {
			out.println("<font>Customer registration success!!<font>");
		}else {
			out.println("<font color='red'>Error in registering the Customer<font>");
		}
		out.println("</boby><html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
