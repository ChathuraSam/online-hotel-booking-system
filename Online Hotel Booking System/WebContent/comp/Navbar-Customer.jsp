<nav class="navbar navbar-expand-lg navbar-light fixed-top"
	style="background-color: #ecf0f1">
	<a class="navbar-brand" href="./index.jsp"> <img
		src="./images/largelogo.png" width="70px"> OHBS
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
	
		
	
		<img src="img/user-regular.svg" width="10%"> 
		<%
		if(session.getAttribute("CustomerName")!=null) {
			out.print(session.getAttribute("CustomerName"));
		}else{
			out.print("Guest");
		}
		
		
		%>
		
		
		
		<%
		if(session.getAttribute("CustomerName")!=null) {
			out.print("<a href='./LogOutServlet'>Logout</a>");
			
		}else{
			out.print("<ul class='navbar-nav'>");
			out.print("<li class='nav-item dropdown'>");
			out.print("<a class='nav-link dropdown-toggle' href='#' id='navbarDropdown'");
			out.print("role='button' data-toggle='dropdown' aria-haspopup='true'");
			out.print("aria-expanded='false'> Signin as </a>");
			out.print("<div class='dropdown-menu' aria-labelledby='navbarDropdown'>");
			out.print("<a class='dropdown-item' href='./Owner-Login.jsp'>Hotel Owner</a>");
			out.print("<a class='dropdown-item' href='./Customer-Login.jsp'>Customer</a>");
			out.print("</div></li>");
			out.print("</ul>");
		}
		
		
		
		%>
		
	</div>

</nav>