<%@ page language="java" import="com.hcl.ohbs.entities.Reservation,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Owner Add Hotel</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME STYLE  -->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="assets/css/style.css" rel="stylesheet" />
<link href="/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONT -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>
<body>
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Owner-homepage.jsp"> 
				<a href="index.jsp"><img src="images/largelogo.png" height="150px" width="130px" alt="logo" /></a>
				</a>

			</div>
			
			<div class="row right-div">
            <div class="col-sm-4">
			<% String ownerName = (String) session.getAttribute("hotelOwnerName"); %>      
			<label class="right-div">Hi.. <%=ownerName%></label>
			</div>
			<div class="col-sm-4">
            
                <a  href="#" ><img style="vertical-align: middle; height: 50px; width: 50px;  border-radius: 50%;" src="images/profileavatar.jpg" alt="MY Profile" ></a>
           
            </div>
			
			<div class="right-div">
				<a href="index.jsp" class="btn btn-danger pull-right">LOG ME OUT</a>
			</div>
		</div>
	</div>
	<!-- LOGO HEADER END-->
	<section class="menu-section">
		<div class="container">
			<div class="row ">
				<div class="col-md-12">
					<div class="navbar-collapse collapse ">
						<ul id="menu-top" class="nav navbar-nav navbar-right">
							<li><a href="Owner-homepage.jsp" class="">OWNER DASHBOARD</a></li>

							<li><a href="Owner-updateViewHotels.jsp" class="menu-top-active">VIEW HOTEL RESERVATIONS</a></li>
							<!--  <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown">UI ELEMENTS <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="ui.html">UI ELEMENTS</a></li>
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="#">EXAMPLE LINK</a></li>
                                </ul>
                            </li> -->
							<li><a href="Owner-addHotel.jsp" >ADD
									HOTEL</a></li>
							<li><a href="Owner-addRoom.jsp" class="">ADD
									ROOM</a></li>
							<li><a href="Owner-hotelsReport.jsp" >HOTELS REPORT</a></li>


						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row pad-botm">
				<div class="col-md-12">
					<!-- <h4 class="header-line">ADD HOTEL</h4> -->

				</div>

			</div>



<div class="col-md-2"></div>
<div class="col-md-8">
                     <!--    Context Classes  -->
                    <div class="panel panel-default">
                       
                        <div class="panel-heading">
                            YOUR HOTEL RESERVATION DETAILS
                        </div>
                        
                        <div class="panel-body">
                            <div class="table-responsive">
                            <% // retrieve your list from the request, with casting 
							List<Reservation> list = (ArrayList<Reservation>) session.getAttribute("bookings");
            				if(list!=null){ %>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Hotel Name</th>
                                            <th>Customer Name</th>
                                            <th>Contact Number</th>
                                            <th>Check In</th>
                                            <th>Check Out</th>
                                            <th>No of Persons</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% 	// print the information about every hotel of the list
										for(Reservation reservation : list) { %> 
				              
                    					<tr>
                        					<td><%=reservation.getHotel().getName()%></td>
                        					<td><%=reservation.getCustomer().getFirstName()%></td>
                        					<td><%=reservation.getCustomer().getPhoneNumber()%></td>
                        					<td><%=reservation.getCheckIn()%></td>
                        					<td><%=reservation.getCheckOut()%></td>
                        					<td><%=reservation.getNoOfPersons()%></td>
                                        </tr>
										<%	} %>    
                                    </tbody>
                                </table>
                                <%	}else{  %>
            					<font color="red">You do not have any reservation details to view yet</font>
           						<%	} %>
                            </div>
                        </div>
                    </div>
                    <!--  end  Context Classes  -->
                </div>
                
                <div class="col-md-2"></div>
</div>
</div>



<!-- CORE JQUERY  -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS  -->
	<script src="assets/js/custom.js"></script>

</body>
</html>