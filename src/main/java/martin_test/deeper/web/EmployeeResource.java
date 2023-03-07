package martin_test.deeper.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.Employee;

import java.util.List;

@Path("/employee")
public class EmployeeResource {
    @Inject
    EmployeeBean employeeBean;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployee() {
        return employeeBean.getEmployee();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@PathParam("id") int id) {
        return employeeBean.getEmployeeById(id);
    }

    @GET
    @Path("/device-id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByDeviceId(@PathParam("id") String deviceId) {
        return employeeBean.getEmployeeByDeviceId(deviceId);
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByEmail(@PathParam("email") String email) {
        return employeeBean.getEmployeeByEmail(email);
    }

    @PUT
    @Path("/id/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEmployeeById(@PathParam("id") int id, Employee employee) {
        employeeBean.updateEmployeeById(id, employee.getName(), employee.getDeviceId(), employee.getEmail(), employee.getPhone());
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee create(Employee employee) {
        return employeeBean.create(employee);
    }

    @POST
    @Path("/verify/{email}/{deviceId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee verify(@PathParam("email") String email, @PathParam("deviceId") String deviceId) {
        // is employee with email and deviceId in database?
        Employee empInDB = employeeBean.getEmployeeByEmail(email);
        if (empInDB != null) {
            if (!empInDB.getDeviceId().equals(deviceId)) {
                empInDB.setDeviceId(deviceId);
                employeeBean.updateEmployeeById((int)empInDB.getId(), empInDB.getName(), empInDB.getDeviceId(), empInDB.getEmail(), empInDB.getPhone());
            }
            return empInDB;
        } else {
            // update with device id
            return null;
        }
    }
}
