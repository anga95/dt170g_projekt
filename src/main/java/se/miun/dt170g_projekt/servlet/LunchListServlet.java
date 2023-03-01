package se.miun.dt170g_projekt.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import se.miun.dt170g_projekt.entities.DailyLunch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LunchListServlet", value = "/LunchListServlet")
public class LunchListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Lunch List</h1>");
        out.println(getLunchList());
        out.println("</body></html>");
    }

    public static String getLunchList() {
        String lunchList = "<ul>";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DailyLunch d");
        List<DailyLunch> resultList = query.getResultList();
        for (DailyLunch dailyLunch : resultList) {
            String weekday = dailyLunch.getWeekday();
            String lunch1 = dailyLunch.getLunch1();
            String lunch2 = dailyLunch.getLunch2();
            String lunch3 = dailyLunch.getLunch3();
            lunchList += "<li>" + weekday + ": " + lunch1 + ", " + lunch2 + ", " + lunch3 + "</li>";
        }
        lunchList += "</ul>";
        em.close();
        emf.close();
        return lunchList;
    }
/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/
}
