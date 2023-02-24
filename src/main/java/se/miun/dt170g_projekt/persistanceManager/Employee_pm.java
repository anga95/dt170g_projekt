package se.miun.dt170g_projekt.persistanceManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.UserTransaction;
import se.miun.dt170g_projekt.entity.Employee_entity;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class Employee_pm {
    private EntityManagerFactory emf;
    private UserTransaction utx;

    public Employee_pm() throws NamingException {
        emf = Persistence.createEntityManagerFactory("dbPU");
        utx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");

    }
    public void saveEmployee(Employee_entity employee) {
        try (EntityManager em = emf.createEntityManager()) {
            utx.begin();
            em.persist(employee);
            utx.commit();
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    public Employee_entity getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee_entity employee = em.find(Employee_entity.class, id);
        em.close();
        return employee;
    }
    public List<Employee_entity> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employee_entity> query = em.createQuery("SELECT e FROM Employee_entity e", Employee_entity.class);
        List<Employee_entity> employees = query.getResultList();
        em.close();
        return employees;
    }
}
