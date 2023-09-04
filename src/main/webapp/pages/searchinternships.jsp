<!DOCTYPE html>
<%@ page import="java.util.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="common.css" rel="stylesheet">
<script>
	var x = 0;
	var y = 0;
	function onButtonClick_1() {
		x += 1

		if (x % 2 != 0) {
			document.getElementById('div1').style.display = 'flex'
		} else {
			document.getElementById('div1').style.display = 'none'
		}
	}
	function onButtonClick_2() {
		y += 1

		if (y % 2 != 0) {
			document.getElementById('div2').style.display = 'flex'
		} else {
			document.getElementById('div2').style.display = 'none'
		}
	}
</script>
</head>
<body>

	<header>
		<h2>SEARCH INTERNSHIPS</h2>
		<a class="logout-button" href="login">Logout</a>
		<nav role="navigation">
			<div id="menuToggle">
				<input type="checkbox" /> <span></span> <span></span> <span></span>

				<ul id="menu">
					<a class="profile-button" href="profile"><li><b>UPDATE
								PROFILE</b></li></a>
					<a class="mybookings-button" href='my-interns'><li><b>MY INTERNS</b></li></a>
				</ul>
			</div>
		</nav>
	</header>



	<div class="radio"
		><br>
		<br>
		<br>
		   	<input type="radio" class=".radio-input" id="location" name="searchbycompany" onclick="onButtonClick_1()"
			value="by company"> 
			<label for="company" class=".radio-label">SEARCH BY COMPANY</label>
			<input type="radio" class=".radio-input" id="location" name="searchbylocation" onclick="onButtonClick_2()"
			value="by location"> 
			<label for="location" class=".radio-label">SEARCH BY LOCATION</label>
	</div>
	<form action="searchinternshipbycompany" method="post">
		<br>
		<div id="div1" class="classic"
			style="display: none; justify-content: center; align-items: center;">

			<br> <br> <select id="city_1" name="company" class="form-select">
				<option value="">Select Company</option>
				<option value="Wipro">Wipro</option>
				<option value="Infosys">Infosys</option>
				<option value="Cognizant">Cognizant</option>
				<option value="Reliance">Reliance</option>
				<option value="State Bank of India">State Bank of India</option>
				<option value="Tech Mahindra">Tech Mahindra</option>
				<option value="L & T">L & T</option>
				<option value="HCL Technologies">HCL Technologies</option>
				<option value="Tata Motors">Tata Motors</option>
				<option value="tcs">TCS</option>

			</select> <br>
			<br> <br>
			<br>
			<button type="submit" class="search-button">SearchInternship</button>
		</div>
	</form>


	<form action="searchinternshipbylocation" method="post">

		<div id="div2" class="classic"
			style="display: none; justify-content: center; align-items: center;">

			<br> <select id="city_2" name="location" class="form-select">
				<option value="">Select Location</option>
				<option value="Coimbatore">Coimbatore</option>
				<option value="Bengaluru">Bengaluru</option>
				<option value="Chennai">Chennai</option>
				<option value="Hyderabad">Hyderabad</option>

			</select>

			<button type="submit" class="search-button">SearchInternship</button>
		</div>


	</form>

</body>
</html>