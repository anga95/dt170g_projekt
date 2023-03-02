package se.miun.dt170g_projekt.persistanceManager;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entites.EmployeeEntity;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class EmployeeManager {

    private static EntityManager em = null;

    public EmployeeManager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }
    public void saveEmployee(EmployeeEntity Employee) {
        em.getTransaction().begin();
        em.persist(Employee);
        em.getTransaction().commit();
    }
    public EmployeeEntity getEmployeeById(int id) {
        EmployeeEntity employee = em.find(EmployeeEntity.class, id);
        em.close();
        return employee;
    }
    public static List<EmployeeEntity> getAllEmployee() {
        TypedQuery<EmployeeEntity> query = em.createQuery("SELECT e FROM EmployeeEntity  e", EmployeeEntity.class);
        List<EmployeeEntity> employee = query.getResultList();
        return employee;
    }
}
