<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.Internships" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="common.css" rel="stylesheet">
</head>
<body>
    <header>
        <h2>MY INTERNS</h2>
        <a class="logout-button" href="login">Logout</a>
        <nav role="navigation">
            <div id="menuToggle">
                <input type="checkbox" />

            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">
                <a class="profile-button" href="profile">
                    <li><b>UPDATE PROFILE</b></li>
                </a>
                <a class="mybookings-button" href='searchinternship'>
                    <li><b>SEARCH INTERNSHIPS</b></li>
                </a>
            </ul>
        </div>
    </nav>
</header>
<% List<Internships> internships = (List<Internships>) request.getAttribute("internships");
    List<String> companyNames = (List<String>) request.getAttribute("companyNames");
%>
<% if(internships.size() == 0) { %>
    <p class="error">No internships applied yet!</p>
<% } else{
    for (int i = 0; i < internships.size(); i++) {
        Internships internship = internships.get(i);
        String companyName = companyNames.get(i);
%>
    <h3><li><%= internship.getTitle() %></li></h3>
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td><b>Company ID:</b></td>
                        <td><%= internship.getCompanyID() %></td>
                    </tr>
                    <tr>
                        <td><b>Company Name:</b></td>
                        <td><%= companyName %></td>
                    </tr>
                    <tr>
                        <td><b>Description:</b></td>
                        <td><%= internship.getDescription() %></td>
                    </tr>
                    <tr>
                        <td><b>Requirements:</b></td>
                        <td><%= internship.getRequirements() %></td>
                    </tr>
                    <tr>
                        <td><b>Stipend:</b></td>
                        <td><%= internship.getStipend() %></td>
                    </tr>
                    <tr>
                        <td><b>Location:</b></td>
                        <td><%= internship.getLocation() %></td>
                    </tr>
                </table>
                <form action="delete-intern" method="post">
                    <input type="hidden" name="title" value="<%= internship.getTitle() %>">
                    <button class="error" type="submit">Delete Application</button>
                </form>
            </td>
        </tr>
    </table>
<% }
} %>
</body>
</html>
	