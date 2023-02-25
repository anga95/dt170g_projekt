package se.miun.dt170g_projekt.persistanceManager;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;
import se.miun.dt170g_projekt.entity.Employee_entity;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.List;

public class Employee_pm implements Serializable {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    public Employee_pm() throws NamingException {
        emf = Persistence.createEntityManagerFactory("dbPU");
        utx = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        em = emf.createEntityManager();
    }
    public void saveEmployee(Employee_entity employee) {
        em.persist(employee);
    }

    public Employee_entity getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee_entity employee = em.find(Employee_entity.class, id);
        em.close();
        return employee;
    }
    public List<Employee_entity> getAllEmployees() {
/* EntityManager em = emf.createEntityManager(); */
        TypedQuery<Employee_entity> query = em.createQuery("SELECT e FROM Employee_entity e", Employee_entity.class);
        List<Employee_entity> employees = query.getResultList();
        em.close();
        emf.close();

        return employees;
    }
}
