<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.persistence.EntityManagerFactory, jakarta.persistence.Persistence, java.util.List" %>
<%@ page import="se.miun.dt170g_projekt.persistanceManager.*" %>
<%@ page import="se.miun.dt170g_projekt.entities.Employee" %>
<%@page import="se.miun.dt170g_projekt.servlet.LunchListServlet" %>

<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <title>JSP - Hello World</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<h1><%= "Hello World!" %></h1>
<br/>
<h1>Lunch List</h1>
<%= se.miun.dt170g_projekt.servlet.LunchListServlet.getLunchList() %>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<%
Employee_pm employee_pm = new Employee_pm();
List<Employee> employees = employee_pm.getAllEmployees();


%>
#{employee_pm.}
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Email</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Phone</th>
    <th>Hourly Rate</th>
    <th>Start Date</th>
  </tr>
  </thead>
  <tbody>
  <% for (Employee employee : employees) { %>
  <tr>
    <td><%= employee.getId() %></td>
    <td><%= employee.getEmail() %></td>
    <td><%= employee.getFirstName() %></td>
    <td><%= employee.getLastName() %></td>
    <td><%= employee.getPhone() %></td>
    <td><%= employee.getHourlyRate() %></td>
    <td><%= employee.getStartDate() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
<!-- Create new employee form -->
<h2>Create New Employee</h2>
<form action="${pageContext.request.contextPath}/addEmployee" method="post">
  <label for="email">Email:</label>
  <input type="text" id="email" name="email"><br>

  <label for="firstName">First Name:</label>
  <input type="text" id="firstName" name="firstName"><br>

  <label for="lastName">Last Name:</label>
  <input type="text" id="lastName" name="lastName"><br>

  <label for="telephone">Telephone:</label>
  <input type="text" id="telephone" name="telephone"><br>

  <input type="submit" name="submit" value="Submit" />
</form>

</body>
</html>