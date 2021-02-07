<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.hcl.ohbs.entities.Hotel,com.hcl.ohbs.entities.Room, java.util.*"%>
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

<style>



/*panel*/
.panel {
    border: none;
    box-shadow: none;
}

.panel-heading {
    border-color:#eff2f7 ;
    font-size: 16px;
    font-weight: 300;
}

.panel-title {
    color: #2A3542;
    font-size: 14px;
    font-weight: 400;
    margin-bottom: 0;
    margin-top: 0;
    font-family: 'Open Sans', sans-serif;
}

/*product list*/

.prod-cat li a{
    border-bottom: 1px dashed #d9d9d9;
}

.prod-cat li a {
    color: #3b3b3b;
}

.prod-cat li ul {
    margin-left: 30px;
}

.prod-cat li ul li a{
    border-bottom:none;
}
.prod-cat li ul li a:hover,.prod-cat li ul li a:focus, .prod-cat li ul li.active a , .prod-cat li a:hover,.prod-cat li a:focus, .prod-cat li a.active{
    background: none;
    color: #ff7261;
}

.pro-lab{
    margin-right: 20px;
    font-weight: normal;
}

.pro-sort {
    padding-right: 20px;
    float: left;
}

.pro-page-list {
    margin: 5px 0 0 0;
}

.product-list img{
    width: 100%;
    border-radius: 4px 4px 0 0;
    -webkit-border-radius: 4px 4px 0 0;
}

.product-list .pro-img-box {
    position: relative;
}
.adtocart {
    background: #fc5959;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    -webkit-border-radius: 50%;
    color: #fff;
    display: inline-block;
    text-align: center;
    border: 3px solid #fff;
    left: 45%;
    bottom: -25px;
    position: absolute;
}

.adtocart i{
    color: #fff;
    font-size: 25px;
    line-height: 42px;
}

.pro-title {
    color: #5A5A5A;
    display: inline-block;
    margin-top: 20px;
    font-size: 16px;
}

.product-list .price {
    color:#fc5959 ;
    font-size: 15px;
}

.pro-img-details {
    margin-left: -15px;
}

.pro-img-details img {
    width: 100%;
}

.pro-d-title {
    font-size: 16px;
    margin-top: 0;
}

.product_meta {
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
    padding: 10px 0;
    margin: 15px 0;
}

.product_meta span {
    display: block;
    margin-bottom: 10px;
}
.product_meta a, .pro-price{
    color:#fc5959 ;
}

.pro-price, .amount-old {
    font-size: 18px;
    padding: 0 10px;
}

.amount-old {
    text-decoration: line-through;
}

.quantity {
    width: 120px;
}

.pro-img-list {
    margin: 10px 0 0 -15px;
    width: 100%;
    display: inline-block;
}

.pro-img-list a {
    float: left;
    margin-right: 10px;
    margin-bottom: 10px;
}

.pro-d-head {
    font-size: 18px;
    font-weight: 300;
}

</style>


</head>
<body>

<%@include file="./comp/Navbar-Customer.jsp" %>

<!-- ------------- -->
<%-- 
<% Hotel hotel = (Hotel) request.getAttribute("hotelDetails");
	List<Room> roomList = (List<Room>) request.getAttribute("roomList");
%>
<!-- <h1>Hotel Details wil be display in this section.</h1> -->
<div id="hotelDetails">
	<h4><%=hotel.getName()%></h3>
	<h2><%=hotel.getCategory()%></h4>
	<h2><%=hotel.getPhoneNumber()%></h4>
	<h2><%=hotel.getAddress()%></h4>
	<% String[] features = hotel.getFeatures().split(",");%>
	<ul>
		<% for(String feature: features){%>
		<li><%=feature%></li>
		<% }%>
	</ul>
</div> --%>




<!-- All the rooms in this hotel will be display in below. A dummy room component is added -->
<%-- <%if(roomList==null || roomList.isEmpty()){%>
<font color="red">This hotel has no added rooms yet</font>
<%}else{}%> --%>

-------------------------
Hotel Details
-------------------------
<div class="container bootdey">
<div class="col-md-12">
<section class="panel">
      <div class="panel-body">
          <div class="col-md-6">
              <div class="pro-img-details">
                  <img src="./img/hotel2.jpg" alt="">
              </div>
              
          </div>
          <div class="col-md-6">
              <h4 class="pro-d-title">
                  <a href="#" class="">
                      Hotel Name
                  </a>
              </h4>
              <p>
                  City 
              </p>
              
              
          </div>
      </div>
  </section>
  </div>
  </div>




<div class='container center_div m-5 p-2'>
		<div class='row'>
		
			<c:forEach items="${roomList}" var="room">

				<div class="card m-1" style="width: 18rem;">
					<img class="card-img-top" src="./img/hotel1.jpg"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${room.getName()}</h5>
						<p class="card-text">Price : ${room.getPrice()}</p>
						<p class="card-text">Features : ${room.getFeatures()}</p>
						<p class="card-text">No of Persons : ${room.getNoOfPersons()}</p>
						<p class="card-text">Availability ${room.getIsAvailable()}</p>
						
						<!--  <a href="Book/${hotel.getId()}" class="btn btn-primary">Book Online</a> -->
						<a href="./ViewRoomDetails?hotelid=${room.getPrice()}" class="btn btn-primary">Book Online</a>
					</div>
				</div>


			</c:forEach>
		</div>
	</div>








<!-- ----------------------- -->

</body>
</html>