package martin_test.deeper.web;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.transaction.*;
import jakarta.transaction.RollbackException;
import martin_test.deeper.entities.Employee;
import martin_test.deeper.pm.Manager;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class EmployeeBean {
    @PersistenceContext(name = "default")

//    @Resource
//    private UserTransaction utx;

    private EntityManager em = null;

    public List<Employee> getEmployee() {
//        final TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.selectAll", Employee.class);
//        return EmployeeList.getResultList();
        return null;
    }

    public Employee create(Employee employee) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//        em = emf.createEntityManager();
        // add new employee to database
        System.out.println("EmployeeBean.create: " + employee);
        em.persist(employee);
        return employee;
    }

    public Employee getEmployeeById(int id) {
//        TypedQuery<Employee> emp = em.createNamedQuery("employee.selectById", Employee.class);
//        emp.setParameter("id", id);
//        return emp.getSingleResult();
        return null;
    }

    public Employee getEmployeeByDeviceId(String deviceId) {
//        TypedQuery<Employee> emp = em.createNamedQuery("employee.selectByDeviceId", Employee.class);
//        emp.setParameter("deviceId", deviceId);
//        return emp.getSingleResult();
        return null;
    }

    // query database, get employee by email transactional

    public Employee getEmployeeByEmail(String email) {
//        TypedQuery<Employee> emp = em.createQuery("SELECT e FROM Employee e WHERE e.email = :email", Employee.class);
//        emp.setParameter("email", email);
//        return emp.getSingleResult();
        return null;
    }

    // update by id
    public void updateEmployeeById(int id, String name, String deviceId, String email, String phone) {
//        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.updateById", Employee.class);
//        EmployeeList.setParameter("id", id);
//        EmployeeList.setParameter("name", name);
//        EmployeeList.setParameter("deviceId", deviceId);
//        EmployeeList.setParameter("email", email);
//        EmployeeList.setParameter("phone", phone);
//        EmployeeList.executeUpdate();
    }

    public void deleteEmployee(int id) {
//        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.removeById", Employee.class);
//        EmployeeList.setParameter("id", id);
//        EmployeeList.executeUpdate();
    }
}
