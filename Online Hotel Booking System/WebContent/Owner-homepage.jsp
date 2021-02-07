<%@ page language="java" import="com.hcl.ohbs.entities.Hotel,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Owner Dashboard</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="css/ownerhotelsdashtable.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    
    
    <script>
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
});
</script>

</head>
<body>


    <div class="navbar navbar-inverse set-radius-zero" >
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
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
			
            <div class="col-sm-4 right-div">
                <a href="LogOutServlet" class="btn btn-danger pull-right">LOG ME OUT</a>
            </div>
            
            
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
                            <li><a href="Owner-homepage.jsp" class="menu-top-active">OWNER DASHBOARD</a></li>
                           
                            <li><a href="ViewBookingsOwner">VIEW HOTEL RESERVATIONS</a></li>
                           <!--  <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown">UI ELEMENTS <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="ui.html">UI ELEMENTS</a></li>
                                     <li role="presentation"><a role="menuitem" tabindex="-1" href="#">EXAMPLE LINK</a></li>
                                </ul>
                            </li> -->
                            <li><a href="Owner-addHotel.jsp">ADD HOTEL</a></li>
                            <li><a href="Owner-addRoom.jsp" class="">ADD
									ROOM</a></li>
                             <li><a href="table.html">HOTELS REPORT</a></li>
                            

                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
    
    
    
    <!-- +++++++++ Hotel Owner - Your Hotels ++++++++++++ -->

<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
                        <h2>Your <b>Hotels</b></h2>
                    </div>
                    <div class="col-sm-7">
                        <a href="Owner-addHotel.jsp" class="btn btn-secondary"><i class="material-icons">&#xE147;</i> <span>Add New Hotel</span></a>
                        <a href="#" class="btn btn-secondary"><i class="material-icons">&#xE24D;</i> <span>Export Report PDF</span></a>						
                    </div>
                </div>
            </div>
            <% // retrieve your list from the request, with casting 
			List<Hotel> list = (ArrayList<Hotel>) request.getAttribute("hotels");
            if(list!=null){ %>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Hotel Id</th>
                        <th>Hotel Name</th>						
                        <th>City</th>
                        <th>Phone number</th>
                        <th>Maximum Capacity</th>
                        <th>Available Capacity</th>
                       	<th>Category</th>
                       	<th>Price</th>
                    </tr>
                </thead>
                <tbody>	
				<% 	// print the information about every hotel of the list
					for(Hotel hotel : list) { %> 
				              
                    <tr>
                        <td><%=hotel.getId()%></td>
                        <td><a href="#"><img src="images/hoicon1.jpg" class="avatar" alt="Avatar"><%=hotel.getName()%></a></td>
                        <td><%=hotel.getCity()%></td>                        
                        <td><%=hotel.getPhoneNumber()%></td>
                        <td><%=hotel.getMaximum_capacity()%></td>
                        <td><%=hotel.getAvailable_capacity()%></td>
                        <td><%=hotel.getCategory()%></td>
                        <td><%=hotel.getPrice()%></td>
                        <td>
                            <a href="#" class="settings" title="Update" data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
                            <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE5C9;</i></a>
                        </td>
                    </tr>
				<%	} %>
                </tbody>
            </table>
            <%	}else{  %>
            <font color="red">You have not added any Hotels yet.</font>
           	<%	} %>
            <div class="clearfix">
                <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>   




<!-- ++++++++++++++ End Your hotels table ++++++++++++++++++= -->
    
    
    
    
    
    
    
     <!-- MENU SECTION END-->
    <div class="content-wrapper">
         <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">HOTEL OWNER DASHBOARD</h4>
                
                            </div>

        </div>
             
             <div class="row">
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            HOTEL 01
                        </div>
                        <div class="panel-body">
                            <p>Description - tibulum tincidunt est vitae</p>
                        </div>
                        <div class="panel-footer">
                            Availability
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            HOTEL 02
                        </div>
                        <div class="panel-body">
                            <p>Beautiful and Spacious hotel </p>
                        </div>
                        <div class="panel-footer">
                            Availability
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                             HOTEL 03
                        </div>
                        <div class="panel-body">
                            <p>Relaxing and Fun activities</p>
                        </div>
                        <div class="panel-footer">
                            Availability
                        </div>
                    </div>
                </div>
            </div>
                   <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            HOTEL 04
                        </div>
                        <div class="panel-body">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                        </div>
                        <div class="panel-footer">
                            Availability
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            HOTEL 05
                        </div>
                        <div class="panel-body">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                        </div>
                        <div class="panel-footer">
                            Availability
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-4">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            HOTEL 06
                        </div>
                        <div class="panel-body">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                        </div>
                        <div class="panel-footer">
                            Availability
                        </div>
                    </div>
                </div>
            </div>
                    <!-- /. ROW  -->
            
        
        <div class="row">
<div class="col-sm-3">
<div class="custom-file">
  <input type="file" class="custom-file-input" id="customFile">
  <label class="custom-file-label" for="customFile">Add image</label>
</div>
</div>

<div class="col-sm-3">
<div class="custom-file">
  <input type="file" class="custom-file-input" id="customFile">
  <label class="custom-file-label" for="customFile">Add image</label>
</div>
</div>

<div class="col-sm-3">
<div class="custom-file">
  <input type="file" class="custom-file-input" id="customFile">
  <label class="custom-file-label" for="customFile">Add image</label>
</div>
</div>

<div class="col-sm-3">
<div class="custom-file">
  <input type="file" class="custom-file-input" id="customFile">
  <label class="custom-file-label" for="customFile">Add image</label>
</div>
</div>



</div>              
             
                 
             
                 
             
                 
     
      <!-- FOOTER SECTION END-->
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
   <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
      <!-- CUSTOM SCRIPTS  -->
    <script src="assets/js/custom.js"></script>
  
</body>
</html>
