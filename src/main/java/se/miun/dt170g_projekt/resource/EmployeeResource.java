package se.miun.dt170g_projekt.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g_projekt.bean.EmployeeBean;
import se.miun.dt170g_projekt.entities.*;

import javax.naming.NamingException;
import java.util.List;

@Path("/employee")
public class EmployeeResource {
    @Inject
    EmployeeBean empBean;

    public EmployeeResource() throws NamingException {
        try {
            empBean = new EmployeeBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Employee employee) {
        empBean.create(employee);
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
    @Path("/shifts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShifts() {
        List<Shift> shifts = empBean.getShifts();
        if (shifts.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(shifts).build();
        }
    }

    @GET
    @Path("/joined-schedules")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesWithSchedules() {
        // if is empty return 404 else return 200
        List<EmpScheduleJoined> empScheduleJoined =
                empBean.getEmployeesWithSchedules(Schedule.class,
                        Employee.class,
                        "EMP_ID",
                        "ID",
                        EmpScheduleJoined.class);

        if (empScheduleJoined == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(empScheduleJoined).build();
        }
    }

    @GET
    @Path("/leaves/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaves(@PathParam("date") String datum) {
        // find leaves for a specific month on a specific year
        List<LeaveDay> leaves = empBean.getLeaves(datum);
        if (leaves == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(leaves).build();
        }
    }

    @GET
    @Path("/extras/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExtras(@PathParam("date") String datum) {
        // find leaves for a specific month on a specific year
        List<ExtraDay> extras = empBean.getExtras(datum);
        if (extras == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(extras).build();
        }
    }
//    @GET
//    @Path("/id/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getEmployeeById(@PathParam("id") int id) {
//        Employee employee = empBean.getEmployeeById(id);
//        if (employee == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(employee).build();
//        }
//    }
//
//    @GET
//    @Path("/device-id/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getEmployeeByDeviceId(@PathParam("id") String deviceId) {
//        Employee employee = empBean.getEmployeeByDeviceId(deviceId);
//        if (employee == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(employee).build();
//        }
//    }

//    @GET
//    @Path("/email/{email}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getEmployeeByEmail(@PathParam("email") String email) {
//        Employee employee = empBean.getEmployeeByEmail(email);
//        if (employee == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        } else {
//            return Response.ok(employee).build();
//        }
//    }

//    @PUT
//    @Path("/id/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void updateEmployeeById(@PathParam("id") int id, Employee employee) {
//        empBean.updateEmployeeById(id, employee.getFirstName(), employee.getLastName(), employee.getDeviceId(), employee.getEmail(), employee.getPhone(), employee.getHourlyRate(), employee.getDeviceId());
//    }


    @POST
    @Path("/verify")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verify(Employee requestEmp) {
        Employee empInDB = empBean.getEmployeeByEmail(requestEmp.getEmail());
        if (empInDB != null) {
            if (empInDB.getDeviceId().equals(requestEmp.getDeviceId())) {
                return Response.ok(empInDB).build();
            } else if (empInDB.getDeviceId().equals("")) {
                empInDB.setDeviceId(requestEmp.getDeviceId());
                empBean.updateEmployeeById(empInDB);
                return Response.ok(empInDB).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).entity(empInDB).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/new-leave")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response leaveUpdateOrCreate(LeaveDay requestLeave) {
        LeaveDay leaveInDB = empBean.getLeaveByDateAndEmp(requestLeave.getLeaveDate(), requestLeave.getEmpId());
        if (leaveInDB != null) {
            // update leave
            leaveInDB.setShiftId(requestLeave.getShiftId());
            empBean.updateLeave(leaveInDB);
        } else {
            empBean.createLeave(requestLeave);
        }
        return Response.ok().build();
    }


    @POST
    @Path("/new-extra")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response extraUpdateOrCreate(ExtraDay requestLeave) {
        ExtraDay extraInDB = empBean.getExtraByDateAndEmp(requestLeave.getExtraDate(), requestLeave.getEmpId());
        if (extraInDB != null) {
            // update extra
            extraInDB.setShiftId(requestLeave.getShiftId());
            empBean.updateExtra(extraInDB);
        } else {
            empBean.createExtra(requestLeave);
        }
        return Response.ok().build();
    }
}

