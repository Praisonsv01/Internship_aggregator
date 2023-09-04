<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.User"%> <%@ page
import="com.spring.reckathon.model.Education"%> <%@page
import="java.util.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Education Details</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
hr {
	border: none;
	border-top: 1px solid black;
	margin-top: 20px;
}
</style>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<header>
		<h2>PROFILE</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<a class="mybookings-button" href='registered-users'><li><b>BACK</b></li></a>
				</ul>
			</div>
		</nav>
	</header>
</head>
<body>
	<% List<Education> educationList =(List<Education>)request.getAttribute("educationList");
		int i = 1;
		if (educationList != null && !educationList.isEmpty()) { %>
		<% for (Education education : educationList) { %>
		<h3>Course <%= i++ %></h3>		 
		<div>
	<table>
		<tr>
			<th>Degree</th>
			<td><% out.println(education.getDegree());%> 
			</td>
		</tr>


		<tr>
			<th>Field of Study</th>
			<td><% out.println(education.getFieldOfStudy());%> 
			</td>
		</tr>

		<tr>
			<th>Institue</th>
			<td><% out.println(education.getInstitute()); %> 
			</td>
		</tr>

		<tr>
			<th>Start date</th>
			<td><% out.println(education.getStartDate()); %> 
			</td>
		</tr>

		<tr>
			<th>End date</th>
			<td><% out.println(education.getEndDate()); %> 
			</td>
		</tr>

		<tr>
			<th>Percentage</th>
			<td><% out.println(education.getPercentage()); %> 
			</td>
		</tr>
	</table>
	<br>
	<br>
	<% } } else { %>
	<p class = "error">No education records found.</p>
	<% } %>
</body>
</html>

</body>
</html>