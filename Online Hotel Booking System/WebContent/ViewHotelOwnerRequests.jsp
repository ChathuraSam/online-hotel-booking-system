<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.hcl.ohbs.entities.HotelOwner,com.hcl.ohbs.services.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<style>
	body{
		padding-top:100px;
	}
	
	</style>

</head>
<body>


<h1>Owner's requests for register</h1>


<%
	HotelOwnerService hotelOwnerService = new HotelOwnerService();
	List<HotelOwner> hotelOwnerList = hotelOwnerService.getAllHotelOwners();
	if(hotelOwnerList.isEmpty() || hotelOwnerList==null) { %>
	<font color="red">Owner list is empty.</font>
<% }else { %>
	<table border="1">
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last name</th>
		<th>NIC</th>
		<th>Phone</th>
		<th>email</th>
		<th>Status</th>
		<th>Approve</th>
		<th>Reject</th>
	</tr>
	<% for(HotelOwner hotelOwner: hotelOwnerList) { %>
	<tr>
		<td><%=hotelOwner.getId()%></td>
		<td><%=hotelOwner.getFistName()%></td>
		<td><%=hotelOwner.getFistName()%></td>
		<td><%=hotelOwner.getNic()%></td>
		<td><%=hotelOwner.getPhoneNumber()%></td>
		<td><%=hotelOwner.getEmail()%></td>
		<td><%=hotelOwner.getStatus()%></td>
		<td><a href="AdminApproveOwnerRequest?ownerId=<%=hotelOwner.getId()%>">Approve</a></td>
    	<td><a href="AdminRejectOwnerRequest?ownerId=<%=hotelOwner.getId()%>">Reject</a></td>
	</tr>
<%	} %>
	</table>
<%	}%>
	





</body>
</html>