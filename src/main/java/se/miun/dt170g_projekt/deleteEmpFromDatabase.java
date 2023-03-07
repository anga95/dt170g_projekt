package se.miun.dt170g_projekt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.persistanceManager.Manager;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "deleteEmp", value = "/deleteEmployee")
public class deleteEmpFromDatabase extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Manager.removeEmployee(id);
    }

}
