package se.miun.dt170g_projekt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.ServerException;
@WebServlet(name = "AdminPage", value = "/AdminPage")
public class AdminPageBackEnd extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        String day = request.getParameter("selectedDay");
        String dish1 = request.getParameter("dish1");
        String dish2 = request.getParameter("dish2");
        String dish3 = request.getParameter("dish3");

        String savedValues = "Day: " + day + ", Dish 1: " + dish1 + ", Dish 2: " + dish2 + ", Dish 3: " + dish3;
        System.out.println(savedValues); // Print the saved values to the console for debugging purposes

        // Set the saved values as an attribute in the request object
        request.setAttribute("savedValues", savedValues);

        // Forward the request to a JSP page to display the saved values
        RequestDispatcher dispatcher = request.getRequestDispatcher("/savedValues.jsp");
        dispatcher.forward(request, response);
    }
}

