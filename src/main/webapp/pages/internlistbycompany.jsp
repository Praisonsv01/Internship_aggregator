<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.Internships"%>
<%@page import="java.util.*"%>
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
          <input type="checkbox" />
          
          <span></span>
          <span></span>
          <span></span>
         
          <ul id="menu">
            <a class="profile-button" href="profile"><li><b>UPDATE PROFILE</b></li></a>
            <a class="mybookings-button" href='searchbus'><li><b>SEARCH JOBS</b></li></a>
          </ul>
        </div>
      </nav>
	</header>
    <%
    List<Internships> list_1 = (List<Internships>) request.getAttribute("internships");
    String companyName = String request.getAttribute("companyName");
    int i=0;
%>

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
           	<td><%= companyName %></td>
            <td><%= intern.getTitle() %></td>
            <td><%= intern.getLocation() %></td>
            
           
        </tr>
    <% } %>
</table>
</body>
</html>