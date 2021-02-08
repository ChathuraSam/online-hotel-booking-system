<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hotel Booking Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!-- +++++Booking page CSS & JS tags++++++ -->

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="dist/pickmeup.min.js"></script>
    <script type="text/javascript" src="dist/handleCounter.js"></script>
    <link rel="stylesheet" type="text/css" href="css/pickmeup.css">
    <link rel="stylesheet" type="text/css" href="css/handle-counter.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <script type="text/javascript" src="dist/jquery.scrollUp.js"></script>
     <script type="text/javascript" src="dist/demo.js"></script>


<!-- ++++++++++++++End tags++++++++++++++++++++ -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
	body{
		padding-top:100px;
	}
	
	</style>
</head>
<body>

	<%@include file="./comp/Navbar-Customer.jsp" %>



<section class="tm-main">
           <p>Booking</p>
    </section>
    
    
    
    <section class="tm-booking">
    
    <form method='GET' action='MakeReservation'>
        <div class="tm-form1">
     
    
            
            
            

            
            
    
    <div class="tm-num1" id="handleCounter1">      
        <label for="number2">Number of Guests</label><br/>
        <button type="button" class="counter-minus btn btn-primary">-</button>
        <input type="text" name="number1" id="number1" value="1">
            <button type="button" class="counter-plus btn btn-primary">+</button>
            </div>
              
            
            
  
    
    </div>
        
        <div class="vertical-line"> </div>
        
    <div class="tm-form2">
      
  <div class="row">
   <div class="tm-cl">
        <label for="checkin">Check-In:</label><br>
  		<input class="datearrive" type="date" id="checkin" name="checkin">
        </div>
        <div class="w-100"></div>
	<div class="tm-cl">
        <label for="checkout">Check-Out:</label><br>
  		<input class="datearrive" type="date" id="checkout" name="checkout">
        </div>
        <div class="w-100"></div>
	<div>
    
     <input type="submit" id="sub" value="Proceed">
    </div>
    
    </div>
    </div>
    
        </form>
  </section>


<%@include file="./comp/Footer.jsp" %>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


</body>
</html>