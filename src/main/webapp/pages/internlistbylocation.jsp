<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.Internships"%> <%@page
import="java.util.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="common.css" rel="stylesheet">
</head>
<body>
	<header>
		<h2>AVAILABLE INTERNSHIPS</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<a class="profile-button" href="profile"><li><b>UPDATE
								PROFILE</b></li></a>
					<a class="mybookings-button" href='searchinternship'><li><b>SEARCH
								INTERNSHIP</b></li></a>
					<a class="mybookings-button" href='my-interns'><li><b>MY INTERNS</b></li></a>
				</ul>
			</div>
		</nav>
	</header>
	<% List<Internships> list_1 = (List<Internships>) request.getAttribute("internships"); List<String> list_2 =
	(List<String>) request.getAttribute("companyNames"); 
	int i=0;%> 
	<% if(list_1.size() == 0){ %>
	<p class="error">No internships available in the entered location!</p>
	<% } else { %>
	<table>
		<tr>
			<th>Company ID</th>
			<th>Company Name</th>
			<th>Title</th>
			<th>Location</th>


		</tr>
		<% for (Internships intern : list_1) { %>
		<tr>
			<td><%= intern.getCompanyID() %></td>
			<form action="intern-details" method="post">
				<input type="hidden" name="companyID"
					value="<%= intern.getCompanyID() %>"> <input type="hidden"
					name="title" value="<%= intern.getTitle() %>">
				<td><button type="submit"><%= list_2.get(i++) %></button></td>
			</form>

			<td><%= intern.getTitle() %></td>
			<td><%= intern.getLocation() %></td>


		</tr>
		<% } 
		} %>
	</table>
</body>
</html>