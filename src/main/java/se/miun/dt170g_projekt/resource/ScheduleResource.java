package se.miun.dt170g_projekt.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g_projekt.entities.Schedule;
import se.miun.dt170g_projekt.bean.ScheduleBean;

import java.util.List;

@Path("/schedule")
public class ScheduleResource {
    @Inject
    ScheduleBean scheduleBean;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    // Response
    public Response getSchedules() {
        // if is empty return 404 else return 200
        List<Schedule> schedules = scheduleBean.getSchedules();
        if (schedules.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(schedules).build();
        }
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    // Response
    public Response getScheduleById(@PathParam("id") int id) {
        Schedule schedule = scheduleBean.getScheduleById(id);
        if (schedule == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(schedule).build();
        }
    }

//    @GET
//    @Path("/emp-id/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Schedule getScheduleByEmployeeId(@PathParam("id") int employeeId) {
//        return scheduleBean.getScheduleByEmployeeId(employeeId);
//    }

//    @PUT
//    @Path("/emp-id/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void updateScheduleByEmployeeId(@PathParam("id") int employeeId, Schedule schedule) {
//        scheduleBean.updateScheduleByEmployeeId(employeeId, schedule.getMon(), schedule.getTue(), schedule.getWed(), schedule.getThu(), schedule.getFri(), schedule.getSat(), schedule.getSun());
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Schedule schedule) {
        scheduleBean.create(schedule);
    }
}
