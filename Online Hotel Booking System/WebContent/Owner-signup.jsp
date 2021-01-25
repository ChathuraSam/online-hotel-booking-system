<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	
	<title>Owner Sign-up</title>
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
</head>

<body >

	<%@include file="./comp/Navbar.jsp" %>

	<form action="RegisterHotelOwner">
		<div class="container center_div">
			<h2>Hotel Owner Sign-Up</h2><hr>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="firstName">First Name</label>
					<input type="text" class="form-control" id="firstName" placeholder="First Name" required>
				</div>
				<div class="form-group col-md-4">
					<label for="lastName">Last Name</label>
					<input type="text" class="form-control" id="lastName" placeholder="Last Name" required>
				</div>
				<div class="form-group col-md-4">
					<label for="phone">Phone Number</label>
					<input type="text" class="form-control" id="phone" placeholder="Ex: 07xxxxxxxx" required>
				</div>
			</div>
			<div class="form-group">
				<label for="nic">NIC</label>
				<input type="text" class="form-control" id="nic" placeholder="NIC no." required>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input type="email" class="form-control" id="email" placeholder="example@abc.com" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="username">Username</label>
					<input type="text" class="form-control" id="username" required>
				</div>
				<div class="form-group col-md-3">
					<label for="password">Password</label>
					<input type="password" class="form-control" id="password" required>
				</div>
				
				<div class="form-group col-md-3">
					<label for="confirmPassword">Confirm Password</label>
					<input type="password" class="form-control" id="cpassword" required>
				</div>
				
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck" required>
					<label class="form-check-label" for="gridCheck">
						Remember me
					</label>
				</div>
			</div>
			
			<button type="reset" value="clear" class="btn btn-primary">Reset</button>
			<button type="submit" value="" class="btn btn-primary">Sign up</button>
			
			<div class="container center_div">
			</form>

			<script src="/js/jquery-3.2.1.slim.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
			<script src="/js/formValidation.js"></script>
			
			<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


			</body>
			</html>