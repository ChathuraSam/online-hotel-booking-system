<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.hcl.ohbs.dao.CustomerDAO,com.hcl.ohbs.dao.HotelDAO,com.hcl.ohbs.dao.ReservationDAO,com.hcl.ohbs.entities.Reservation,com.hcl.ohbs.services.RoomService,java.util.*"%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

<%@include file="./comp/Navbar-Customer.jsp" %>

<center>
<h1>By Bookings</h1>

	
	<table border='1'>
		<tr><th>Check In</th><th>Check Out</th><th>No of Persons</th><th>Reserved By</th><th>Hotel Name</th><th>Room Name</th><th>Price</th></tr>
		
		<% 
			List<Reservation> list = (List<Reservation>) request.getAttribute("reservationList");
			//get the customer name by logged in customer id
			String fname = (String)request.getAttribute("firstName");
		HotelDAO hotel = new HotelDAO();
		RoomService roomService = new RoomService();
		for(Reservation r:list) {
			int roomId = r.getRoom().getId();
			int hotelId = roomService.getHotelIdByRoomID(roomId);
			String hname = hotel.getNameById(hotelId);
			String roomName = roomService.getNameById(roomId);
			Double price = roomService.getPriceById(roomId); %>
			<tr><td><%=r.getCheckIn()%></td><td><%=r.getCheckOut()%></td><td><%=r.getNoOfPersons()%></td><td><%=fname%></td><td><%=hname%></td><td><%=roomName%></td><td><%=price%></td><td><a href='CancelBookingserv?reservId=<%=r.getId()%>'>Cancel Order</a></td></tr>
		<%}%>		

	</table>
</center>
</body>
</html>