package se.miun.dt170g_projekt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.entites.EmployeeEntity;
import se.miun.dt170g_projekt.persistanceManager.Manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet(name = "AddEmp", value = "/AddEmp")
public class AddEmployeeToDataBase extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String fname = request.getParameter("fname");
        String lname = request.getParameter("ename");
        String email = request.getParameter("email");
        String telnumber = request.getParameter("telnr");

        System.out.println(fname);

        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName(fname);
        employee.setLastName(lname);
        employee.setEmail(email);
        employee.setPhone(telnumber);

        Manager newEmployee = null;
        try {
            newEmployee = new Manager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        newEmployee.saveData(employee);
    }
}
