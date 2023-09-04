<%@page import="java.util.*"%> 
<%@ page import="com.spring.reckathon.model.User"%>
<%@ page import="com.spring.reckathon.model.Company"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User dashboard</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<header>
		<h2>USER DASHBOARD</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<% User user = (User) request.getAttribute("user"); %>
					<h2>
						Welcome <font color="fick"><%= user.getName()%></font>!
					</h2>
					<a class="profile-button" href="profile"><li><b>UPDATE
								PROFILE</b></li></a>
					<a class="mybookings-button" href='searchinternship'><li><b>SEARCH
								INTERNSHIPS</b></li></a>
					<a class="mybookings-button" href='my-interns'><li><b>MY INTERNS</b></li></a>
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