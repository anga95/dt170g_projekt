package se.miun.dt170g_projekt.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g_projekt.bean.DailyLunchBean;
import se.miun.dt170g_projekt.entities.DailyLunchEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import java.time.DayOfWeek;

import java.time.LocalDate;
import java.util.List;

@Path("/dailylunch")
public class DailyLunchResource {

    @Inject
    DailyLunchBean dailyLunchBean;

    public List<DailyLunchEntity> list = ServletManager.getAllDaily();

    @GET
    @Path("/getTodaysLunch")
    @Produces(MediaType.APPLICATION_JSON)
    public DailyLunchEntity getLunches(){
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDay = currentDate.getDayOfWeek();
        String dayString = currentDay.toString().toLowerCase();
        for(DailyLunchEntity obj : list){
            if(obj.getWeekday().equals(dayString))
                return obj;
        }
        return null;
    }
}
