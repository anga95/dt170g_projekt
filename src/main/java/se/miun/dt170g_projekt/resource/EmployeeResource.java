package se.miun.dt170g_projekt.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g_projekt.bean.EmployeeBean;
import se.miun.dt170g_projekt.entities.Employee;
import se.miun.dt170g_projekt.entities.Schedule;

import javax.naming.NamingException;
import java.util.List;

@Path("/employee")
public class EmployeeResource {
    @Inject
    EmployeeBean empBean;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Employee employee) throws NamingException {
        try{
            empBean = new EmployeeBean();
            empBean.create(employee);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        // if is empty return 404 else return 200
        List<Employee> employees = empBean.getEmployees();
        if (employees.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(employees).build();
        }
    }


    @GET
    @Path("/joined-schedules")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesWithSchedules() {
        // if is empty return 404 else return 200
        Object employees = empBean.getEmployeesWithSchedules(Schedule.class, Employee.class, "EMP_ID", "ID");

        if (employees == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(employees).build();
        }
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // Response
    public Response getEmployeeById(@PathParam("id") int id) {
        Employee employee = empBean.getEmployeeById(id);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(employee).build();
        }
    }

    @GET
    @Path("/device-id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeByDeviceId(@PathParam("id") String deviceId) {
        Employee employee = empBean.getEmployeeByDeviceId(deviceId);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(employee).build();
        }
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeByEmail(@PathParam("email") String email) {
        Employee employee = empBean.getEmployeeByEmail(email);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(employee).build();
        }
    }

//    @PUT
//    @Path("/id/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void updateEmployeeById(@PathParam("id") int id, Employee employee) {
//        empBean.updateEmployeeById(id, employee.getFirstName(), employee.getLastName(), employee.getDeviceId(), employee.getEmail(), employee.getPhone(), employee.getHourlyRate(), employee.getDeviceId());
//    }


//    @POST
//    @Path("/verify")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response verify(@Valid VerifyRequest request) {
////         is employee with email and deviceId in database?
//        Employee empInDB = empBean.getEmployeeByEmail(request.getEmail());
//        return Response.ok(empInDB).build();
//        if (empInDB != null) {
//            if (empInDB.getDeviceId().equals(deviceId)) {
//                // status code 200
//                return Response.ok(empInDB).build();
//            } else if (empInDB.getDeviceId().equals("")) {
//                empInDB.setDeviceId(deviceId);
//                empBean.updateEmployeeById((int)empInDB.getId(), empInDB.getName(), empInDB.getDeviceId(), empInDB.getEmail(), empInDB.getPhone());
//                return Response.ok(empInDB).build();
//            }
//        }
    // status code 404
//        return Response.status(Response.Status.NOT_FOUND).build();
//        return Response.ok("email: " + email + ", device-id: " + deviceId).build();
//    }
}

