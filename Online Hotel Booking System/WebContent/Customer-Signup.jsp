<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	
	<title>Customer Signup</title>
	 
	 <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	
</head>


<body >

<%@include file="./comp/Navbar.jsp" %>

<form action="" style="border:1px solid #ccc">
  <div class="container">
    <center><h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p></center>
    <hr>

    <label for="Fname"><b>First Name</b></label>
    <input type="text" placeholder="Enter Your First Name" name="fname" required>

    <label for="Lname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Your Last Name" name="lname" required>

    <label for="contact"><b>Contact Number</b></label>
    <input type="text" placeholder="Enter Contact Number" name="contact" required>

    <label for="NIC"><b>National Identity Card Number</b></label>
    <input type="text" placeholder="Enter NIC No" name="nic" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
    
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>
    
    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <p>Already have an account <a href="#" style="color:dodgerblue">Sign in</a>.</p>

    <div class="clearfix">
      
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>


</body>
</html>