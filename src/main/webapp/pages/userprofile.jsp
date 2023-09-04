<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.User"%> 
<%@page import="java.util.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Profile</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<header>
		<h2>USER PROFILE</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>
				<ul id="menu">
					<h2>
						WELCOME <font color="fick">ADMIN!</font>
					</h2>
					<a class="mybookings-button" href='admin-dashboard'><li><b>BACK</b></li>
                </a>
				</ul>
			</div>
		</nav>
	</header>

	<table>

		<% User user =(User)request.getAttribute("user"); if(user!=null) { %>
		<tr>
			<th>Email ID</th>
			<td><% out.println(user.getEmail());%></td>
		</tr>

		<tr>
			<th>Password</th>
			<td><% out.println(user.getPassword());%></td>
		</tr>

		<tr>
			<th>Name</th>
			<td><% out.println(user.getName()); %></td>
		</tr>

		<tr>
			<th>Phone number</th>
			<td><% out.println(user.getPhoneNo());%></td>
		</tr>
		<tr>
			<td>
				<form action="getEducationalDetails" method="post">
					<input type="hidden" name="userName" value="<%= user.getName() %>">
					<button type="submit">Get Education</button>
				</form>
			</td>
		</tr>
		<% }%>

	</table>
</body>
</html>