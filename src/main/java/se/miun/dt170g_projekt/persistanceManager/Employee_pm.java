/*
package se.miun.dt170g_projekt.persistanceManager;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entities.Employee;
import javax.naming.NamingException;
import java.util.List;

@Stateless
public class Employee_pm {

    private final EntityManager em;

    public Employee_pm() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }
    public void saveEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }
    public Employee getEmployeeById(int id) {
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
}
*/
