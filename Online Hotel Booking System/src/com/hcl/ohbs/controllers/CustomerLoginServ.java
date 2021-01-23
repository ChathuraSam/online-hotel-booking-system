package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.entities.Customer;


@WebServlet("/CustomerLoginServ")
public class CustomerLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String uname= "sithara";
		String pwd = "sithara123";
		
		Customer c = new Customer();
		c.setUsername(uname);
		c.setPassword(pwd);
		
		CustomerDAO dao = new CustomerDAO();
		
		out.println("<html><boby>");
		if(dao.LoginCustomer(c)) {
			out.println("<font>Login Successfull!!<font>");
		}
		else {
			out.println("<font color='red'>Invalid Username or Password!!<font>");
		}
		out.println("</boby><html>");
	}



}
