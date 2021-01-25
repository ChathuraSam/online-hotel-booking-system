package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.entities.Customer;
import com.hcl.ohbs.services.RegisterCustomerService;


@WebServlet("/CustomerLoginServ")
public class CustomerLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String uname= request.getParameter("username");
		String pwd = request.getParameter("password");
		
		Customer c = new Customer();
		c.setUsername(uname);
		c.setPassword(pwd);
		
		CustomerDAO dao = new CustomerDAO();
		RegisterCustomerService custService = new RegisterCustomerService();
		out.println("<html><boby>");
		if(dao.LoginCustomer(c)) {
			HttpSession session = request.getSession();
			//int sessionId = (int) session.getAttribute("id");
			int sessionId = custService.getIdByUsernameAndPassword(uname, pwd);
			String sessionName = custService.getNameByUsernameAndPassword(uname, pwd);
			//if(id>0) {
				out.println("<font>customer login success!!<font>");
			//}else{
				//out.println("<font color='red'>internal error! try again!<font>");
			//}
			//call ownerHome.jsp and pass the id in session
			session.setAttribute("customerId", sessionId);
			session.setAttribute("CustomerName", sessionName);
			//request.setAttribute("errorMsg", "");
			request.getRequestDispatcher("Customer-Home.jsp").include(request, response);	
		}else {
			out.println("<font color='red'>Invalid Username or Password!!<font>");
			request.getRequestDispatcher("Customer-Login.jsp").include(request, response);
		}
		out.println("</boby><html>");
	}
}
