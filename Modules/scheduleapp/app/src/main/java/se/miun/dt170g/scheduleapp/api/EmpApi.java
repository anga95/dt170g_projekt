package se.miun.dt170g.scheduleapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import se.miun.dt170g.scheduleapp.model.EmpExtras;
import se.miun.dt170g.scheduleapp.model.EmpLeaves;
import se.miun.dt170g.scheduleapp.model.EmpSchedule;

public interface EmpApi {
    @GET("emp-schedules")
    Call<List<EmpSchedule>> getEmpSchedules(String apiKey);

    @GET("emp-leaves")
    Call<List<EmpLeaves>> getEmpLeaves(String apiKey);

    @GET("emp-extras")
    Call<List<EmpExtras>> getEmpExtras(String apiKey);
}
