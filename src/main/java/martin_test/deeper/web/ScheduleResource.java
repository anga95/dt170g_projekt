package martin_test.deeper.web;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.Schedule;

import java.util.List;

@Path("/schedule")
public class ScheduleResource {
    @Inject
    ScheduleBean scheduleBean;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Schedule> getSchedule() {
        return scheduleBean.getSchedule();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Schedule getScheduleById(@PathParam("id") int id) {
        return scheduleBean.getScheduleById(id);
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
    public Schedule create(Schedule schedule) {
        return scheduleBean.create(schedule);
    }
}
