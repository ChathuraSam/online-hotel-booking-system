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
							<li><a href="Owner-homepage.jsp" class="">DASHBOARD</a></li>

							<li><a href="Owner-updateViewHotels.jsp">VIEW HOTEL RESERVATIONS</a></li>
							<!--  <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown">UI ELEMENTS <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="ui.html">UI ELEMENTS</a></li>
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="#">EXAMPLE LINK</a></li>
                                </ul>
                            </li> -->
							<li><a href="Owner-addHotel.jsp" >ADD
									HOTEL</a></li>
							<li><a href="Owner-hotelsReport.jsp" class="menu-top-active">HOTELS REPORT</a></li>


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







			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">Monthly income Progress Bars</div>

						<div class="panel-body">
							<div class="progress">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%">
									<span class="sr-only">40% Complete (success)</span>
								</div>
							</div>
							<div class="progress">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									style="width: 20%">
									<span class="sr-only">20% Complete</span>
								</div>
							</div>
							<div class="progress">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (warning)</span>
								</div>
							</div>
							<div class="progress">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: 80%">
									<span class="sr-only">80% Complete</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-heading">Yearly income Progress Bars</div>

						<div class="panel-body">
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%">
									<span class="sr-only">40% Complete (success)</span>
								</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									style="width: 20%">
									<span class="sr-only">20% Complete</span>
								</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (warning)</span>
								</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: 80%">
									<span class="sr-only">80% Complete</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<!-- ++++++ Report Table ++++++ -->
			
			
			<!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             Hotels Revenue Report
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Hotel Name</th>
                                            <th>City</th>
                                            <th>Status</th>
                                            <th>Guests Checked-In</th>
                                            <th>Income</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="odd gradeX">
                                            <td>Hotel Hilton</td>
                                            <td>Colombo</td>
                                            <td>Not Available</td>
                                            <td class="center">4</td>
                                            <td class="center">Rs.100000.00</td>
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>Mt.Lavinia Hotel</td>
                                            <td>Mt.Lavinia</td>
                                            <td>Available</td>
                                            <td class="center">5</td>
                                            <td class="center">Rs.80000.00</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Hotel Hilton</td>
                                            <td>Colombo</td>
                                            <td>Not Available</td>
                                            <td class="center">4</td>
                                            <td class="center">Rs.100000.00</td>
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>Mt.Lavinia Hotel</td>
                                            <td>Mt.Lavinia</td>
                                            <td>Available</td>
                                            <td class="center">5</td>
                                            <td class="center">Rs.80000.00</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Hotel Hilton</td>
                                            <td>Colombo</td>
                                            <td>Not Available</td>
                                            <td class="center">4</td>
                                            <td class="center">Rs.100000.00</td>
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>Mt.Lavinia Hotel</td>
                                            <td>Mt.Lavinia</td>
                                            <td>Available</td>
                                            <td class="center">5</td>
                                            <td class="center">Rs.80000.00</td>
                                        </tr>
                                        <tr class="odd gradeX">
                                            <td>Regency Hotel</td>
                                            <td>Kandy</td>
                                            <td>Reserved</td>
                                            <td class="center">4</td>
                                            <td class="center">Rs.500000.00</td>
                                        </tr>
                                        <tr class="even gradeC">
                                            <td>Hotel Galadhari</td>
                                            <td>Colombo</td>
                                            <td>Available</td>
                                            <td class="center">6</td>
                                            <td class="center">Rs.200000.00</td>
                                        </tr>
                                        
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
			
			
			
			<!-- +++ Report Table End ++++ -->
			
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