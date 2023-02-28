package se.miun.dt170g_projekt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "AdminAddFood", value = "/AdminAddFood")
public class AdminGetFoodFromDatabase extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the attributes in the request object
        request.setAttribute("dish1Mon", "Dish 1 for Monday");
        request.setAttribute("dish2Mon", "Dish 2 for Monday");
        request.setAttribute("dish3Mon", "Dish 3 for Monday");



        // Forward the request to the JSP page
        // Forward the request to a JSP page to display the saved values
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

        System.out.println();
    }
}
