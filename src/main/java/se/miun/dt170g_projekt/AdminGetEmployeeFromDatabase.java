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
import se.miun.dt170g_projekt.entites.EmployeeEntity;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminGetEmployee", value = "/AdminGetEmployee")
public class AdminGetEmployeeFromDatabase extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM EmployeeEntity d");
        List<EmployeeEntity> resultList = query.getResultList();

        request.setAttribute("employee1", resultList.get(0).getFirstName());
        request.setAttribute("employee2", resultList.get(1).getFirstName());;
        System.out.println(resultList.get(0).getFirstName());
        System.out.println(resultList.get(1).getFirstName());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPanel.jsp");
        dispatcher.forward(request, response);

    }
}
