package se.miun.dt170g_projekt.persistanceManager;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entity.Employee_entity;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.List;

@Stateless
public class Employee_pm {

    private final EntityManager em;

    public Employee_pm() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }
    public void saveEmployee(Employee_entity employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    public Employee_entity getEmployeeById(int id) {
        Employee_entity employee = em.find(Employee_entity.class, id);
        em.close();
        return employee;
    }
    public List<Employee_entity> getAllEmployees() {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbPU");
        EntityManager em = emf.createEntityManager();*/
        TypedQuery<Employee_entity> query = em.createQuery("SELECT e FROM Employee_entity e", Employee_entity.class);
        List<Employee_entity> employees = query.getResultList();
/*        em.close();
        emf.close();*/
        return employees;
    }
}
