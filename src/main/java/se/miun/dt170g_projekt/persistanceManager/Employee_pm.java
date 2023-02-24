package se.miun.dt170g_projekt.persistanceManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import se.miun.dt170g_projekt.entity.Employee_entity;

public class Employee_pm {
    private EntityManagerFactory emf;

    public Employee_pm() {
        emf = Persistence.createEntityManagerFactory("dbPU");
    }
    public void saveEmployee(Employee_entity employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

    public Employee_entity getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee_entity employee = em.find(Employee_entity.class, id);
        em.close();
        return employee;
    }
}
