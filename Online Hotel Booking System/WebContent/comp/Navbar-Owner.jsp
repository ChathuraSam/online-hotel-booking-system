<div class="navbar navbar-inverse set-radius-zero">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="Owner-homepage.jsp"> <a
				href="index.jsp"><img src="images/largelogo.png" height="150px"
					width="130px" alt="logo" /></a>
			</a>

		</div>

		<div class="row right-div">
			<div class="col-sm-4">
				<% String ownerName = (String) session.getAttribute("hotelOwnerName"); %>
				<label class="right-div">Hi.. <%=ownerName%></label>
			</div>
			<div class="col-sm-4">

				<a href="#"><img
					style="vertical-align: middle; height: 50px; width: 50px; border-radius: 50%;"
					src="images/profileavatar.jpg" alt="MY Profile"></a>

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

							<li><a href="Owner-updateViewHotels.jsp"
								class="menu-top-active">VIEW HOTEL RESERVATIONS</a></li>
							<!--  <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown">UI ELEMENTS <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="ui.html">UI ELEMENTS</a></li>
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="#">EXAMPLE LINK</a></li>
                                </ul>
                            </li> -->
							<li><a href="Owner-addHotel.jsp">ADD HOTEL</a></li>
							<li><a href="Owner-addRoom.jsp" class="">ADD ROOM</a></li>
							<li><a href="Owner-hotelsReport.jsp">HOTELS REPORT</a></li>


						</ul>
					</div>
				</div>

			</div>
		</div>
	</section>
	<!-- MENU SECTION END-->