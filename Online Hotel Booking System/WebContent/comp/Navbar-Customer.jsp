
<nav class="navbar navbar-expand-lg navbar-light bg-light">


	<a class="navbar-brand" href="index.jsp"><img
		src="images/largelogo.png" height="150px" width="130px" alt="logo"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">About
					Us <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ViewCustomerReservationServ">My Bookings</a></li>
			<li class="nav-item"><a class="nav-link"
				href="SearchHotel?hotelName=&city=">Find Hotels</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Signup as </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="./Owner-signup.jsp">Hotel Owner</a>
					<a class="dropdown-item" href="./Customer-Signup.jsp">Customer</a>
				</div></li>

			</li>
			<li class="nav-item"><a class="nav-link"
				href="./Owner-addHotel.jsp">Add a Hotel</a></li>
		</ul>

	</div>
	<div class="col-sm-4 right-div">
		<a href="./Customer-Login.jsp" name="login"
			class="btn btn-info pull-right">Login As Customer</a> <a
			href="./Owner-Login.jsp" name="login" class="btn btn-info pull-right">Login
			As Hotel Owner</a>
	</div>
</nav>

