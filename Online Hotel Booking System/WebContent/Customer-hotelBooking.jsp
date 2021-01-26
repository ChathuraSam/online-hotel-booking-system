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

</head>
<body>

	<%@include file="./comp/Navbar.jsp" %>



<section class="tm-main">
           <p>Booking</p>
    </section>
    
    
    
    <section class="tm-booking">
    
    <form>
        <div class="tm-form1">
     
    <label  for="rooms" id="inlinelable">Hotel Type</label>
    <select name="Rooms" id="rooms">
        <option value="luxurys">Luxury Suite</option>
        <option value="deluxs">Delux Suite</option>
        <option value="premiers">Premier Suite</option>
        <option value="Luxuryr">Luxury Room</option>
        <option value="deluxs">Delux Room</option>
        <option value="premierr">Premier Room</option>
    </select> 
            
            
            

            
            
    <div class="tm-num1" id="handleCounter1">    
    <label for="number1" ></label><br/>
        
        </div>
    <div>      
        <label for="number2">Number of Guests</label><br/>
        <button type="button" class="counter-minus btn btn-primary">-</button>
        <input type="text" name="number2" id="number2" value="1">
            <button type="button" class="counter-plus btn btn-primary">+</button>
            </div>
              
            
            
  
    
    </div>
        
        <div class="vertical-line"> </div>
        
    <div class="tm-form2">
   <div class="tm-cl">
        <label for="date1" class="arrival">Visiting Dates from Arrival to Departure</label>

     <input type="text" name="date1" class="range" readonly="readonly"> 
        

     <input type="submit" id="sub" value="Proceed">
    </div>
    </div>
        </form>
  </section>


<%@include file="./comp/Footer.jsp" %>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>