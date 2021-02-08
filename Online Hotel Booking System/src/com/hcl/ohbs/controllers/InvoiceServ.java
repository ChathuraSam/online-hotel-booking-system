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
		
		List<Reservation> rList = new ArrayList<>();
		rList = dao.getReservationByCustomerId(custId);
		Invoice invoice = dao.getInvoiceByCustomerId(custId);
		
		out.println("<html><body>");
		out.println("<center>");
		out.println("<h1>Thank You for the Reservation!! </h1>");
		out.println("<h2>Your Invoice Details...</h2>");
		out.println("</center>");
		out.println("OHBS System,35,2nd Lane,Ratmalana<br/><br/>");
		out.println("Invoice To: <br/>");			
		out.println(customer.getFirstName()+ " " + customer.getLastName() + "<br/>");
		out.println(customer.getAddress() + "<br/>");
		out.println(customer.getEmail()+"<br/><br/>");
		
		for(Integer i :list) {
			Totprice =Totprice+dao.getPriceByRoomId(i);
		}
			out.println("<table border='1'>");
			out.println("<tr><th>Invoice ID</th><th>Invoice Generated Date</th><th>Total Price</th><th>Reservation ID</th></tr>");
			
			Reservation r = null;
			for(Reservation i1 :rList) {
				if(dao.generateInvoice(new Invoice(dao.getPriceByRoomId(i1.getRoom().getId()),custId,i1.getId()))) {
					out.println("<tr>");
					out.println("<td>"+invoice.getId()+"</td>");
					out.println("<td>"+invoice.getDateGenerated()+"</td>");
					out.println("<td>"+dao.getPriceByRoomId(i1.getRoom().getId())+"</td>");
					out.println("<td>"+i1.getId()+"</td>");
					out.println("</tr><br>");
				}
				else {
					out.println("<font color='red'>error in generating invoice</font>");
				}
			}

			
			out.println("</table>");
			out.println("</body></html>");
		
		

			
			
			out.println("Total Amount : "+invoice.getTotalAmount()+"0<br>");
			out.println("</body></html>");
		
		
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