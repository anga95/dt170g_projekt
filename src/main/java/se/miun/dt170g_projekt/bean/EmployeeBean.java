package se.miun.dt170g_projekt.bean;
import jakarta.ejb.Stateless;
import se.miun.dt170g_projekt.entities.*;
import se.miun.dt170g_projekt.persistanceManager.Manager;

import javax.naming.NamingException;
import java.sql.Date;
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
    public void createLeave(LeaveDay leaveEntity){
        pm.create(leaveEntity);
    }

    public void createExtra(ExtraDay extraEntity){
        pm.create(extraEntity);
    }

    public List<Employee> getEmployees() {
        return pm.getAll(Employee.class);
    }


    public Employee getEmployeeById(int id) {
        return pm.getById(Employee.class, id);
    }

//    public Employee getEmployeeByDeviceId(String deviceId) {
//        return pm.getByEmail(Employee.class, "DEVICE_ID", deviceId);
//    }

    public Employee getEmployeeByEmail(String email) {
        return pm.getByEmail(Employee.class, email);
    }

    public <T, U, X> List<X> getEmployeesWithSchedules(Class<T> table1, Class<U> table2, String column1, String column2, Class<X> returnType) {
        return pm.getJoinedTables(table1, table2, column1, column2, returnType);
    }

    // update by id
    public void updateEmployeeById(Employee empEntity) {
        pm.update(empEntity);
    }

    public List<LeaveDay> getLeaves(String datum) {
        return pm.getLeaves(LeaveDay.class, datum);
    }
    public List<ExtraDay> getExtras(String datum) {
        return pm.getExtras(ExtraDay.class, datum);
    }

    public LeaveDay getLeaveByDateAndEmp(Date leaveDate, int empId) {
        return pm.getLeaveByDateAndEmp(LeaveDay.class, leaveDate, empId);
    }

    public void updateLeave(LeaveDay leaveInDB) {
        pm.update(leaveInDB);
    }

    public ExtraDay getExtraByDateAndEmp(Date extraDate, int empId) {
        return pm.getExtraByDateAndEmp(ExtraDay.class, extraDate, empId);
    }

    public void updateExtra(ExtraDay extraInDB) {
        pm.update(extraInDB);
    }

    public List<Shift> getShifts() {
        return pm.getAll(Shift.class);
    }
//    public void deleteEmployee(int id) {
//        TypedQuery<Employee> EmployeeList = em.createNamedQuery("employee.removeById", Employee.class);
//        EmployeeList.setParameter("id", id);
//        EmployeeList.executeUpdate();
//    }
}


