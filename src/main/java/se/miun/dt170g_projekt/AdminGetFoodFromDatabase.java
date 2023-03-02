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
import se.miun.dt170g_projekt.persistanceManager.dailyLunch;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

@WebServlet(name = "AdminAddFood", value = "/AdminAddFood")
public class AdminGetFoodFromDatabase extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DailyLunchEntity d");
        List<DailyLunchEntity> resultList = query.getResultList();

        request.setAttribute("dish1Mon", resultList.get(0).getLunch1());
        request.setAttribute("dish2Mon", resultList.get(0).getLunch2());
        request.setAttribute("dish3Mon", resultList.get(0).getLunch3());

        request.setAttribute("dish1Tis", resultList.get(1).getLunch1());
        request.setAttribute("dish2Tis", resultList.get(1).getLunch2());
        request.setAttribute("dish3Tis", resultList.get(1).getLunch3());

        request.setAttribute("dish1Ons", resultList.get(2).getLunch1());
        request.setAttribute("dish2Ons", resultList.get(2).getLunch2());
        request.setAttribute("dish3Ons", resultList.get(2).getLunch3());

        request.setAttribute("dish1Tor", resultList.get(3).getLunch1());
        request.setAttribute("dish2Tor", resultList.get(3).getLunch2());
        request.setAttribute("dish3Tor", resultList.get(3).getLunch3());

        request.setAttribute("dish1Fre", resultList.get(4).getLunch1());
        request.setAttribute("dish2Fre", resultList.get(4).getLunch2());
        request.setAttribute("dish3Fre", resultList.get(4).getLunch3());



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
