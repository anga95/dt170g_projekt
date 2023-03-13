package se.miun.dt170g_projekt.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.entities.DailyLunchEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;
//import se.miun.dt170g_projekt.persistanceManager.dailyLunch;

import java.io.IOException;
import java.rmi.ServerException;
@WebServlet(name = "AdminPage", value = "/AdminPage")
public class AdminAddDailyFoodToDataBase extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String day = request.getParameter("selectedDay");
        String dish1 = request.getParameter("dish1");
        String dish2 = request.getParameter("dish2");
        String dish3 = request.getParameter("dish3");
        String price = request.getParameter("price");
        String time = request.getParameter("time");

        String savedValues = "Day: " + day + ", Dish 1: " + dish1 + ", Dish 2: " + dish2 + ", Dish 3: " + dish3;
        System.out.println(savedValues); // Print the saved values to the console for debugging purposes

        // Set the saved values as an attribute in the request object
        request.setAttribute("savedValues", savedValues);

        // Forward the request to a JSP page to display the saved values

        DailyLunchEntity Daily = new DailyLunchEntity();

        Daily.setWeekday(day);
        Daily.setLunch1(dish1);
        Daily.setLunch2(dish2);
        Daily.setLunch3(dish3);
        Daily.setPrice(Integer.valueOf(price));
        Daily.setTime(Integer.valueOf(time));

        ServletManager newdailyLunch = null;

        try {
            newdailyLunch = new ServletManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

        newdailyLunch.changeLunch(Daily);

        // Redirect to employee list page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPanel.jsp");
        dispatcher.forward(request, response);
    }
}

