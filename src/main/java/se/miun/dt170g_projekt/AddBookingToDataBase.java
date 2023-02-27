package se.miun.dt170g_projekt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.ServerException;
@WebServlet(name = "BookingPage", value = "/bookingPage")
public class AddBookingToDataBase extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {

        System.out.println("BookingServlet");
        // read form fields
        String username = request.getParameter("fname");

        String savedValues = "username: " + username;
        System.out.println(savedValues); // Print the saved values to the console for debugging purposes

        // Set the saved values as an attribute in the request object
        request.setAttribute("savedValues2", savedValues);

        // Forward the request to a JSP page to display the saved values
        RequestDispatcher dispatcher = request.getRequestDispatcher("/savedValues.jsp");
        dispatcher.forward(request, response);



    }

}
