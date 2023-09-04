<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.User" %> <%@ page
import="com.spring.reckathon.model.Education" %> <%@ page
import="java.util.*" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Education Details</title>
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
    	alert("Internship Applied Successful!")
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
		<h2>PROFILE</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<a class="mybookings-button" href='profile'>
						<li><b>UPDATE PROFILE</b></li>
					</a>
				</ul>
			</div>
		</nav>
	</header>
</head>
<body>
	<div >
		<form action="addeducation" method="post">
			<table>
				<tr>
					<td>Degree:</td>
					<td><select name="degree" required readonly>
							<option value="M.Com">M.Com</option>
							<option value="MBA">MBA</option>
							<option value="ME">ME</option>
							<option value="MTech">MTech</option>
							<option value="B.Com">B.Com</option>
							<option value="BE">BE</option>
							<option value="B Tech">B.Tech</option>
							<option value="Diploma">Diploma</option>
							<option value="X">X</option>
							<option value="XII">XII</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Field of Study:</td>
					<td><select name="fieldOfStudy" required readonly>
							<!-- Add existing field options -->
							<option value="Mechanical Engineering">Mechanical
								Engineering</option>
							<option value="Electrical Engineering">Electrical
								Engineering</option>
							<option value="Electronic Engineering">Electronic
								Engineering</option>
							<option value="Civil Engineering">Civil Engineering</option>
							<option value="Chemical Engineering">Chemical
								Engineering</option>
							<option value="Computer Engineering">Computer
								Engineering</option>
							<option value="Computer Science and Engineering">Computer
								Science and Engineering</option>
							<option value="Biomedical Engineering">Biomedical
								Engineering</option>
							<option value="Aerospace Engineering">Aerospace
								Engineering</option>
							<option value="Environmental Engineering">Environmental
								Engineering</option>
							<option value="Materials Science">Materials Science</option>
							<option value="Computer Science">Computer Science</option>
							<option value="Systems Engineering">Systems Engineering</option>
							<option value="Industrial Engineering">Industrial
								Engineering</option>
							<option value="Information Technology">Information
								Technology</option>
							<option value="Chemistry">Chemistry</option>
							<option value="Automobile Engineering">Automobile
								Engineering</option>
							<option value="Marine Engineering">Marine Engineering</option>
							<option value="Petroleum Engineering">Petroleum
								Engineering</option>
							<option value="Structural Engineering">Structural
								Engineering</option>
							<option value="Manufacturing Engineering">Manufacturing
								Engineering</option>
							<option value="Mining Engineering">Mining Engineering</option>
							<option value="Bioengineering">Bioengineering</option>
							<option value="B.Com - Tax Procedure">B.Com - Tax
								Procedure</option>
							<option value="B.Com - Accounts">B.Com - Accounts</option>
							<option value="B.Com - Tax Procedure & Practice">B.Com -
								Tax Procedure & Practice</option>
							<option value="B.Com - International Banking">B.Com -
								International Banking</option>
							<option value="B.Com - Accounting & Taxation">B.Com -
								Accounting & Taxation</option>
							<option value="B.Com - Foreign Trade">B.Com - Foreign
								Trade</option>
							<option value="State Board">State Board</option>
							<option value="CBSE">CBSE</option>
							<option value="ICSE">ICSE</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Institute:</td>
					<td><input type="text" name="institute" required ></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><input type="date" name="startDate" id="startDate" required></td>
				</tr>
				<tr>
					<td>End Date:</td>
					<td><input type="date" name="endDate" id="endDate" required></td>
				</tr>
				<tr>
					<td>Percentage:</td>
					<td><input type="number" name="percentage" required ></td>
				</tr>
			</table>
			<br> <br>
			<button type="submit" onclick="showPopup()">Submit</button>
		</form>
	</div>


</body>
</html>
