package dbFunctions;
import app.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/set-employee")
public class SetEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String telephone = request.getParameter("telephone");
        setEmployee(fname, lname, telephone);
        response.setStatus(200);
    }
    public void setEmployee(String fname, String lname, String telephone){
        Employee employee = new Employee();
        employee.setFirst_name(fname);
        employee.setLast_name(lname);
        employee.setTelephone(telephone);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Employee added to database");
    }

}
