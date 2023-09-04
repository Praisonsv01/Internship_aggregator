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
<script>
    function onButtonClick_1(id) {
        var textInput = document.getElementById('textInput_' + id);
        textInput.style.display = textInput.style.display === 'none' ? '' : 'none';
    }
</script>
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
                    <a class="mybookings-button" href='searchinternship'><li><b>SEARCH
                                INTERNSHIPS</b></li></a>
                    <a class="mybookings-button" href='my-interns'><li><b>MY INTERNS</b></li></a>
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
                <td><% out.println(education.getDegree());%> <input
                    type="button" name="update" class="logout-button"
                    onclick="onButtonClick_1('degree<%=i%>')" value="Update" />
                    <div id="textInput_degree<%=i%>" style="display: none">
                        <br>
                        <form action="updatedegree" method="post">
                        <!-- Inside each form -->
							<input type="hidden" name="courseId" value="<%= education.getCourseId() %>">
                            <select name="degree" required>
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
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </td>
            </tr>


            <tr>
                <th>Field of Study</th>
                <td><% out.println(education.getFieldOfStudy());%> <input
                    type="button" name="update" class="logout-button"
                    onclick="onButtonClick_1('fieldOfStudy<%=i%>')" value="Update" />
                    <div id="textInput_fieldOfStudy<%=i%>" style="display: none">
                        <br>
                        <form action="updateFieldOfStudy" method="post">
							<input type="hidden" name="courseId" value="<%= education.getCourseId() %>">
                            <select name="fieldOfStudy" required>
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
                            </select>
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </td>
            </tr>

            <tr>
                <th>Institue</th>
                <td><% out.println(education.getInstitute()); %> <input
                    type="button" name="update" class="logout-button"
                    onclick="onButtonClick_1('institute<%=i%>')" value="Update" />
                    <div id="textInput_institute<%=i%>" style="display: none">
                        <br>
                        <form action="updateInstitute" class="hide" method="post">
                            <input type="text" name="institute" required />
                            <input type="hidden" name="courseId" value="<%= education.getCourseId() %>">
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </td>
            </tr>

            <tr>
                <th>Start date</th>
                <td><% out.println(education.getStartDate()); %> <input
                    type="button" name="update" class="logout-button"
                    onclick="onButtonClick_1('startDate<%=i%>')" value="Update" />
                    <div id="textInput_startDate<%=i%>" style="display: none">
                        <br>
                        <form action="updateStartDate" class="hide" method="post">
                            <input type="date" name="startDate" required />
                            <input type="hidden" name="courseId" value="<%= education.getCourseId() %>">
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </td>
            </tr>

            <tr>
                <th>End date</th>
                <td><% out.println(education.getEndDate()); %> <input
                    type="button" name="update" class="logout-button"
                    onclick="onButtonClick_1('endDate<%=i%>')" value="Update" />
                    <div id="textInput_endDate<%=i%>" style="display: none">
                        <br>
                        <form action="updateEndDate" class="hide" method="post">
                            <input type="date" name="endDate" required />
                            <input type="hidden" name="courseId" value="<%= education.getCourseId() %>">
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </td>
            </tr>

            <tr>
                <th>Percentage</th>
                <td><% out.println(education.getPercentage()); %> <input
                    type="button" name="update" class="logout-button"
                    onclick="onButtonClick_1('percentage<%=i%>')" value="Update" />
                    <div id="textInput_percentage<%=i%>" style="display: none">
                        <br>
                        <form action="updatePercentage" class="hide" method="post">
                            <input type="number" name="percentage" required />
                            <input type="hidden" name="courseId" value="<%= education.getCourseId() %>">
                            <button type="submit">Submit</button>
                        </form>
                    </div>
                </td>
            </tr>
        </table>
        <br>
        <br>
        <% } } else { %>
        <p class = "error">No education records found.</p>
        <% } %>
        <a class="addeducation-button" href='addeducation'><b>Add Education</b></a>
    </body>
    </html>
</body>
</html>
