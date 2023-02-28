package se.miun.dt170g_projekt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import se.miun.dt170g_projekt.entity.Employee_entity;
import se.miun.dt170g_projekt.persistanceManager.Employee_pm;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "addEmployeeServlet", value = "/addEmployee")
public class addEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String telephone = request.getParameter("telephone");

        // Create new employee
/*
        Employee_entity employee = new Employee_entity(id, email, firstName, lastName, restaurantId, telephone);
*/
        Employee_entity employee = new Employee_entity();
        employee.setId(10);
        employee.setEmail(email);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setRestaurantId(1);
        employee.setTelephone(telephone);


        Employee_pm employee_pm = null;
        try {
            employee_pm = new Employee_pm();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        employee_pm.saveEmployee(employee);

        // Redirect to employee list page
        response.sendRedirect("index.jsp");
    }
}
