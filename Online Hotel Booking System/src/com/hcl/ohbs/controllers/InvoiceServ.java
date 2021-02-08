package com.hcl.ohbs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.ohbs.dao.CustomerDAO;
import com.hcl.ohbs.dao.InvoiceDAO;
import com.hcl.ohbs.dao.ReservationDAO;
import com.hcl.ohbs.entities.Customer;
import com.hcl.ohbs.entities.Invoice;
import com.hcl.ohbs.entities.Reservation;


@WebServlet("/InvoiceServ")
public class InvoiceServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		List<Integer> list = new ArrayList<>();
		InvoiceDAO dao = new InvoiceDAO();
		CustomerDAO cdao = new CustomerDAO();
		CustomerDAO custDao = new CustomerDAO();		
		HttpSession session = request.getSession();
		int custId = (int) session.getAttribute("customerId");
		Customer customer = custDao.findCustomerInvoiceDetailsById(custId);
		list=dao.getRoomsById(custId);
		
		System.out.println(list);
		Double Totprice = 0.0;
		
		for(Integer i :list) {
			Totprice = Totprice+dao.getPriceByRoomId(i);
			
		}
		System.out.println(Totprice);
		
		List<Integer> rList = new ArrayList<>();
		rList = dao.getReservationIdByCustomerId(custId);
		Integer resrv = 0;
		for(Integer i :rList) {
			resrv = rList.get(rList.size()-1);
		}
		if(dao.generateInvoice(new Invoice(Totprice,custId,resrv))) {
			//out.println("<font color='green'>Successfully generated the invoice</font>");
			Invoice invoice = dao.getInvoiceByCustomerId(custId);
			System.out.println(invoice);
			out.println("<html><body style='background-color:#ffc180;'>");
			out.println("<center>");
			out.println("<h1>Thank You for the Reservation!! </h1>");
			out.println("<h2>Your Invoice Details...</h2>");
			out.println("</center>");
			out.println("OHBS System,35,2nd Lane,Ratmalana<br/><br/>");
			out.println("Invoice To: <br/>");			
			out.println(customer.getFirstName()+ " " + customer.getLastName() + "<br/>");
			out.println(customer.getAddress() + "<br/>");
			out.println(customer.getEmail()+"<br/><br/>");
			out.println("Invoice ID : "+invoice.getId()+"Invoice Generated Date : " + invoice.getDateGenerated()+"<br/><br/>");
			
			out.println("<table border='1'>");
			out.println("<tr><th>Hotel Name</th><th>Contact Details</th><thRoom Name</th><th>No of Person</th><th>Price</th></tr>");			
			
			out.println("Reservation ID : "+invoice.getReservationId()+"<br>");
			out.println("/table");
			
			
			out.println("Total Amount : "+invoice.getTotalAmount()+"0<br>");
			out.println("</body></html>");
		}
		else {
			out.println("<font color='red'>error in generating invoice</font>");
		}
		
		/*out.println("<table border='1'>");
		out.println("<tr><th>Check In</th><th>Check Out</th><th>No of Persons</th><th>Reserved By</th><th>Hotel Name</th><th>Room Name</th><th>Price</th></tr>");
		for(Reservation r:list) {
			int roomId = r.getRoom().getId();
			int hotelId = roomService.getHotelIdByRoomID(roomId);
			String hname = hotel.getNameById(hotelId);
			String roomName = roomService.getNameById(roomId);
			Double price = roomService.getPriceById(roomId);
			out.println("<tr><td>"+r.getCheckIn()+"</td><td>"+r.getCheckOut()+"</td><td>"+r.getNoOfPersons()+"</td><td>"+fname+"</td><td>"+hname+"</td><td>"+roomName+"</td><td>"+price+"</td><td><a href='CancelBookingserv="+ r.getId() +"'>Cancel Order</a></td></tr>");
		}*/
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
