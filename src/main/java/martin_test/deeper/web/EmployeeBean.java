package martin_test.deeper.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import martin_test.deeper.entities.Employee;

import java.util.List;

@Named
@RequestScoped
public class EmployeeBean {
    @PersistenceContext(unitName = "default")
    EntityManager em;

    public List<Employee> getEmployee() {
        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.selectAll", Employee.class);
        return EmployeeList.getResultList();
    }

    // create
    public Employee create(Employee employee) {
        em.persist(employee);
        return employee;
    }

    public Employee getEmployeeById(int id) {
        TypedQuery<Employee> emp = em.createNamedQuery("employee.selectById", Employee.class);
        emp.setParameter("id", id);
        return emp.getSingleResult();
    }

    public Employee getEmployeeByDeviceId(String deviceId) {
        TypedQuery<Employee> emp = em.createNamedQuery("employee.selectByDeviceId", Employee.class);
        emp.setParameter("deviceId", deviceId);
        return emp.getSingleResult();
    }

    // by email
    public Employee getEmployeeByEmail(String email) {
        TypedQuery<Employee> emp = em.createNamedQuery("employee.selectByEmail", Employee.class);
        emp.setParameter("email", email);
        return emp.getSingleResult();
    }

    // update by id
    @Transactional
    public void updateEmployeeById(int id, String name, String deviceId, String email, String phone) {
        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.updateById", Employee.class);
        EmployeeList.setParameter("id", id);
        EmployeeList.setParameter("name", name);
        EmployeeList.setParameter("deviceId", deviceId);
        EmployeeList.setParameter("email", email);
        EmployeeList.setParameter("phone", phone);
        EmployeeList.executeUpdate();
    }

    public void deleteEmployee(int id) {
        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.removeById", Employee.class);
        EmployeeList.setParameter("id", id);
        EmployeeList.executeUpdate();
    }
}
