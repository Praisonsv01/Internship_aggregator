<%@ page import="com.spring.reckathon.model.Company"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<header>
		<h2>ADMIN DASHBOARD</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>WELCOME <font color="fick">ADMIN!</font></h2>
					<a class="mybookings-button" href="registered-users"><li><b>REGISTERED USERS</b></li></a>
					<a class="mybookings-button" href='allregistered-interns'><li><b>ALL INTERNS</b></li></a>
					<a class="mybookings-button" href='addcompany'><li><b>ADD COMPANIES</b></li></a>
				</ul>
			</div>
		</nav>
	</header>
	<h2 class="heading">Companies Available!!!</h2>
	<table>
		<tr>
			<th>Company ID</th>
			<th>Company Name</th>
			<th>Website</th>
			<th>Contact Email</th>
		</tr>

		<% List<Company> companies =(List<Company>) request.getAttribute("companies");
		if(companies!=null) for(Company obj : companies){ %>
		<tr>
			<td><% out.println(obj.getCompanyID());%></td>
			<td><% out.println(obj.getCompanyName());%></td>
			<td><% out.println(obj.getWebsite()); %></td>
			<td><% out.println(obj.getContactEmail());%></td>
		<tr><% }%>
	</table>
</body>
</html>