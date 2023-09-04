<%@ page import="com.spring.reckathon.model.User"%> 
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registered Users</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<header>
		<h2>REGISTERED USERS</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>WELCOME <font color="fick">ADMIN!</font></h2>
					<a class="mybookings-button" href='allregistered-interns'><li><b>ALL INTERNS</b></li></a>
					<a class="mybookings-button" href='admin-dashboard'><li><b>BACK</b></li></a>
				</ul>
			</div>
		</nav>
	</header>
	</nav>
	<table>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Email ID</th>
			<th>Phone Number</th>
		</tr>
		<% List
		<User> userList = (List<User>)
		request.getAttribute("userList");%> <% for(int i = 0; i <
		userList.size(); i++) { User user = userList.get(i); %>
		<tr>
			<td><%= i+1 %></td>
			<td><a class="username"  href="userprofile?name=<%= user.getName() %>&email=<%= user.getEmail() %>">
					<%= user.getName() %> </a></td>
			<td><%= user.getEmail() %></td>
			<td><%= user.getPhoneNo() %></td>
		</tr>
		<% } %> 
	</table>
</body>
</html>