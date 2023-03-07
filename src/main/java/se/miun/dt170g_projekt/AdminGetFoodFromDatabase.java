package se.miun.dt170g_projekt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.entites.DailyLunchEntity;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminAddFood", value = "/AdminAddFood")
public class AdminGetFoodFromDatabase extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DailyLunchEntity d");
        List<DailyLunchEntity> resultList = query.getResultList();

        String[] days = {"Mon", "Tis", "Ons", "Tor", "Fre"};
        for (int i = 0; i < days.length; i++) {
            request.setAttribute("dish1" + days[i], resultList.get(i).getLunch1());
            request.setAttribute("dish2" + days[i], resultList.get(i).getLunch2());
            request.setAttribute("dish3" + days[i], resultList.get(i).getLunch3());
        }



        // Forward the request to the JSP page
        // Forward the request to a JSP page to display the saved values
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        /*
        // Set the attributes in the request object
        request.setAttribute("dish1Mon", "Dish 1 for Monday");
        request.setAttribute("dish2Mon", "Dish 2 for Monday");
        request.setAttribute("dish3Mon", "Dish 3 for Monday");

        */
    }
}
