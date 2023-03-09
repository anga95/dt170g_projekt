package se.miun.dt170g_projekt.bean;
import jakarta.ejb.Stateless;
import se.miun.dt170g_projekt.entities.*;
import se.miun.dt170g_projekt.persistanceManager.Manager;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class EmployeeBean {

    private Manager pm = null;
    public EmployeeBean() throws NamingException {
        pm = new Manager();
    }
    public void create(Employee empEntity){
        pm.create(empEntity);
    }

    public List<Employee> getEmployees() {
        return pm.getAll(Employee.class);
    }


    public Employee getEmployeeById(int id) {
        return pm.getById(Employee.class, id);
    }

    public Employee getEmployeeByDeviceId(String deviceId) {
        return pm.getByColumnName(Employee.class, "device_id", deviceId);
    }

    public Employee getEmployeeByEmail(String email) {
        return pm.getByColumnName(Employee.class, "email", email);
    }

//    public <T, U> Object getEmployeesWithSchedules(Class<T> table1, Class<U> table2, String column1, String column2) {
//        return pm.getJoinedTables(table1, table2, column1, column2);
//    }

    // update by id
//    public void updateEmployeeById(int id, String name, String deviceId, String email, String phone) {
//        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.updateById", Employee.class);
//        EmployeeList.setParameter("id", id);
//        EmployeeList.setParameter("name", name);
//        EmployeeList.setParameter("deviceId", deviceId);
//        EmployeeList.setParameter("email", email);
//        EmployeeList.setParameter("phone", phone);
//        EmployeeList.executeUpdate();
//    }

//    public void deleteEmployee(int id) {
//        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.removeById", Employee.class);
//        EmployeeList.setParameter("id", id);
//        EmployeeList.executeUpdate();
//    }
}


