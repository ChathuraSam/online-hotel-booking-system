package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.services.HotelOwnerService;
import com.hcl.ohbs.services.RegisterCustomerService;

@WebServlet("/RegisterCustomerServ")
public class RegisterCustomerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("begin RegisterCustomerServ");
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
		if(!phone.matches("^07[0-9]{8}$")){
			out.println("<center><font color='red'><B>Phone Number is invalid!</B></font>");
			request.getRequestDispatcher("Customer-Signup.jsp").include(request, response);
		}else if(!email.matches("^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$")){
			out.println("<center><font color='red'><B>Email is invalid!</B></font>");
			request.getRequestDispatcher("Customer-Signup.jsp").include(request, response);
		}else if(!confirmPassword.equals(password)) {
			out.println("<center><font color='red'><B>Confirm Password & Password should match</B></font>");
			request.getRequestDispatcher("Customer-Signup.jsp").include(request, response);
		}else{
			RegisterCustomerService custService = new RegisterCustomerService();
			if(custService.registerCustomer(firstName, lastname, phone, address, email, username, password, confirmPassword )) {
				out.println("<font>Customer registration success!!<font>");
				HttpSession session = request.getSession();
				int sessionId = custService.getIdByUsernameAndPassword("username", "password");
				session.setAttribute("customerId", sessionId); //call Customer-Home.jsp and pass the id in session
				session.setAttribute("customerName", firstName);
				request.getRequestDispatcher("Customer-Home.jsp").include(request, response);	
			}else {
			out.println("<font color='red'>Error in registering the Customer<font>");
			request.getRequestDispatcher("Customer-Signup.jsp").include(request, response);
			}
		}
		out.println("</boby><html>");
		System.out.println("end RegisterCustomerServ");
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
