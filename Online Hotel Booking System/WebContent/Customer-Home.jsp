<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="com.hcl.ohbs.dao.*"%>
<%@page import="com.hcl.ohbs.entities.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

	<%@include file="./comp/Navbar.jsp"%>

	<br>
	<form class="form-inline center_div" action="SearchHotel" method="get">

		<div class="form-group mb-2 m-2">Search Hotels</div>

		<div class="form-group mx-sm-3 mb-2">
			<label for="inputPassword2" class="sr-only">Room Type</label> <input
				type="text" class="form-control" id="hotelName"
				placeholder="Hotel Name" name="hotelName">
		</div>
		<div class="form-group mx-sm-3 mb-2">
			<label for="inputPassword2" class="sr-only">City</label> <input
				type="text" class="form-control" id="city" placeholder="City"
				name="city">
		</div>

		<input type="submit" value="Search" />
	</form>
	<hr>





	<div class='container center_div m-5 p-2'>
		<div class='row'>
		
			<c:forEach items="${hotels}" var="hotel">

				<div class="card m-1" style="width: 18rem;">
					<img class="card-img-top" src="./img/hotel1.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${hotel.getName()}</h5>
						<p class="card-text">${hotel.getCity()}</p>
						<p class="card-text">${hotel.getPrice()}</p>
						<!--  <a href="Book/${hotel.getId()}" class="btn btn-primary">Book Online</a> -->
						<a href="./Customer-hotelBooking.jsp?id=${hotel.getId()}" class="btn btn-primary">Book Online</a>
					</div>
				</div>


			</c:forEach>
		</div>
	</div>
	<%@include file="./comp/Footer.jsp"%>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>