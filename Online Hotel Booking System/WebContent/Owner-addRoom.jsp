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
<title>Owner Add Room</title>
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
							<li><a href="Owner-homepage.jsp" class="">OWNER
									DASHBOARD</a></li>

							<li><a href="Owner-updateViewHotels.jsp">VIEW HOTEL
									RESERVATIONS</a></li>
							<!--  <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown">UI ELEMENTS <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="ui.html">UI ELEMENTS</a></li>
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="#">EXAMPLE LINK</a></li>
                                </ul>
                            </li> -->
							<li><a href="Owner-addHotel.jsp" class="">ADD
									HOTEL</a></li>
							<li><a href="Owner-addRoom.jsp" class="menu-top-active">ADD
									ROOM</a></li>
							<li><a href="Owner-hotelsReport.jsp">HOTELS REPORT</a></li>


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

			<div class="col-md-2 col-sm-2"></div>
			<div class="col-md-8 col-sm-8 col-xs-12">

				<div class="panel panel-danger">
					<div class="panel-heading">ADD ROOM DETAILS</div>
					<div class="panel-body">
						<!-- <form action="AddHotel" method="post" enctype="multipart/form-data"> -->	
					<form action="AddRoom" method="post">
					
					<div class="form-group">
								<label>Room Type</label>
								<select class="form-control" name="roomType" id="rooms" required>
									<option value="luxurys">Luxury Suite</option>
									<option value="deluxs">Delux Suite</option>
									<option value="premiers">Premier Suite</option>
									<option value="Luxuryr">Luxury Room</option>
									<option value="deluxs">Delux Room</option>
									<option value="premierr">Premier Room</option>
								</select>
							</div>
							<div class="form-group">
								<label>Room Price</label> <input name="roomprice"
									class="form-control" type="text" required />
								<p class="help-block"></p>
							</div>
					
					
							<!-- <div class="form-group">
								<label>Enter Hotel Name</label> <input name="hotelname"
									class="form-control" type="text" required />
								<p class="help-block">Ex: Kingsbury Hotel</p>
							</div> -->
							<!-- <div class="form-group">
								<label>City</label> <input name="hotelcity" class="form-control"
									type="text" required />
								<p class="help-block">Hotel Destination city</p>
							</div> -->
							<!-- <div class="form-group">
								<label>Contact Number</label> <input name="hotelcontact"
									class="form-control" type="tel" required />
								<p class="help-block">Hotel Contact number</p>
							</div> -->
							<!-- <div class="form-group">
								<label>Hotel Address</label> <input name="hoteladdress"
									class="form-control" type="text" required />
								<p class="help-block"></p>
							</div> -->
							<div class="form-group">
								<label>Room Status</label> <input name="roomstatus"
									class="form-control" type="text" required />
								<p class="help-block">Available/Reserved</p>
							</div>
							<!-- <div class="form-group">
								<label>Maximum Guests</label> <input name="roomcapacity"
									class="form-control" type="number" required />
								<p class="help-block"></p>
							</div> -->
							<div class="form-group">
								<label>Available Slots</label> <input name="roomslots"
									class="form-control" type="number" required />
								<p class="help-block"></p>
							</div>
							
							
							
							
							
							<!-- 
							<div class="row">
								<div class="col-sm-4">
									<div class="custom-file">
										<input multiple name="hotelimg1" type="file"
											class="custom-file-input" id="customFile" required> <label
											class="custom-file-label" for="customFile">Add image</label>
									</div>
								</div>
 							
								
							</div>-->

							<div class="form-group">
								<label>Room Description</label>
								<textarea name="roomdesc" class="form-control" rows="3"
									required></textarea>
							</div><br>
							
							
							<div class="row">
								<div class="col-sm-4">
									<div class="custom-file">
										<input multiple name="roomimg1" type="file"
											class="custom-file-input" id="customFile" required> <label
											class="custom-file-label" for="customFile">Add Room images</label>
									</div>
								</div>
 							
								
							</div><br>

							<button type="reset" class="btn btn-danger">Reset</button>
							<button type="submit" class="btn btn-info">Add Room</button>

						</form>
					</div>
				</div>
			</div>

			<div class="col-md-2 col-sm-2"></div>
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