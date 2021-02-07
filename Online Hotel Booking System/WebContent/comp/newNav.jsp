<nav class="navbar navbar-expand-lg navbar-light fixed-top"
	style="background-color: #ecf0f1;">
	<a class="navbar-brand" href="./index.jsp"> <img
		src="./images/largelogo.png" width="70px"> OHBS - Admin Panel
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
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

		</ul>
	</div>

	<div class="inline my-2 my-lg-0">
		<img src="img/user-regular.svg" width="10%"> Guest
		
		<ul class="navbar-nav">
		<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Signin as </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="./Owner-Login.jsp">Hotel Owner</a>
					<a class="dropdown-item" href="./Customer-Login.jsp">Customer</a>
				</div></li>
		</ul>
		
	</div>

</nav>