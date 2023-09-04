<!DOCTYPE html>
<%@ page import="com.spring.reckathon.model.Internships" %>
<%@ page import="com.spring.reckathon.model.MyInterns" %>
<%@ page import="java.util.*" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="common.css" rel="stylesheet">
</head>
<body>
    <header>
        <h2>ALL INTERNS</h2>
        <a class="logout-button" href="login">Logout</a>
        <nav role="navigation">
            <div id="menuToggle">
                <input type="checkbox" />

            <span></span>
            <span></span>
            <span></span>

            <ul id="menu">
                <a class="mybookings-button" href='admin-dashboard'>
                    <li><b>BACK</b></li>
                </a>
            </ul>
        </div>
    </nav>
</header>
<%
    List<MyInterns> myInternsList = (List<MyInterns>) request.getAttribute("myInternsList");
    List<Internships> internships = (List<Internships>) request.getAttribute("internships");
    List<String> companyNames = (List<String>) request.getAttribute("companyNames");

    // Create a mapping of interns based on email ID
    Map<String, List<MyInterns>> internsByEmailId = new HashMap<>();
    for (MyInterns intern : myInternsList) {
        String emailId = intern.getEmail();
        if (!internsByEmailId.containsKey(emailId)) {
            internsByEmailId.put(emailId, new ArrayList<>());
        }
        internsByEmailId.get(emailId).add(intern);
    }
%>

<% for (String emailId : internsByEmailId.keySet()) {
    List<MyInterns> interns = internsByEmailId.get(emailId);
%>
    <h3>Interns for Email ID: <%= emailId %></h3>
    <table>
        <% for (int i = 0; i < interns.size(); i++) {
            MyInterns intern = interns.get(i);
            Internships internship = internships.get(i);
            String companyName = companyNames.get(i);
        %>
        <tr>
            <td>
                <b>Email ID:</b> <%= intern.getEmail() %><br>
                <b>Company ID:</b> <%= internship.getCompanyID() %><br>
                <b>Company Name:</b> <%= companyName %><br>
                <b>Title:</b> <%= internship.getTitle() %><br>
                <b>Description:</b> <%= internship.getDescription() %><br>
                <b>Requirements:</b> <%= internship.getRequirements() %><br>
                <b>Stipend:</b> <%= internship.getStipend() %><br>
                <b>Location:</b> <%= internship.getLocation() %><br>
            </td>
        </tr>
        <% } %>
    </table>
<% } %>
</body>
</html>
