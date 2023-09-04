<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.Education" %> 
<%@ page import="java.util.*" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Comapny Details</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	function makeEditable(element) {
		var inputs = element.parentNode.parentNode
				.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			inputs[i].removeAttribute("readonly");
		}
		element.style.display = "none";
	}

	function addAnotherEducation() {
		var formHtml = document.getElementById("educationForm").innerHTML;
		var newForm = "<hr>" + formHtml.replace(/education1/g, "education2");
		document.getElementById("educationContainer").innerHTML += newForm;
	}
	function showPopup(){
    	alert("Company added Successful!")
    }
</script>
<style>
hr {
	border: none;
	border-top: 1px solid black;
	margin-top: 20px;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}
</style>
<link rel="stylesheet" href="common.css">
</head>
<body>
	<header>
		<h2>COMPANIES</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<a class="mybookings-button" href="registered-users"><li><b>REGISTERED USERS</b></li></a>
					<a class="mybookings-button" href='allregistered-interns'><li><b>ALL INTERNS</b></li></a>
					<a class="mybookings-button" href='admin-dashboard'><li><b>BACK</b></li>
                </a>
				</ul>
			</div>
		</nav>
	</header>
</head>
<body>
	<div >
		<form action="addcompany" method="post">
			<table>
				<tr>
					<td>Company ID:</td>
					<td><input type="text" name="companyid" required ></td>
				</tr>
				<tr>
					<td>Company Name:</td>
					<td><input type="text" name="companyname" required ></td>
				</tr>
				<tr>
					<td>Website:</td>
					<td><input type="text" name="website" required ></td>
				</tr>
		
				<tr>
					<td>Contact email:</td>
					<td><input type="text" name="contactemail" required ></td>
				</tr>
			</table>
			<br> <br>
			<button type="submit" onclick="showPopup()">Submit</button>
		</form>
	</div>


</body>
</html>
