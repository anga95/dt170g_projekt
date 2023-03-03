package se.miun.dt170g.scheduleapp.repository;


import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import se.miun.dt170g.scheduleapp.api.EmpApi;
import se.miun.dt170g.scheduleapp.model.EmpExtras;
import se.miun.dt170g.scheduleapp.model.EmpLeaves;
import se.miun.dt170g.scheduleapp.model.EmpSchedule;
import se.miun.dt170g.scheduleapp.utils.Constants;
import se.miun.dt170g.scheduleapp.utils.RetrofitClient;

public class EmployeeRepository {

    private EmpApi empApi;

    public EmployeeRepository() {
        empApi = RetrofitClient.getEmployeeApi();
    }

    public void getEmpSchedules(Callback<List<EmpSchedule>> callback) {
        Call<List<EmpSchedule>> call = empApi.getEmpSchedules(Constants.API_KEY);
        call.enqueue(callback);
    }

    public void getEmpLeaves(Callback<List<EmpLeaves>> callback) {
        Call<List<EmpLeaves>> call = empApi.getEmpLeaves(Constants.API_KEY);
        call.enqueue(callback);
    }

    public void getEmpExtras(Callback<List<EmpExtras>> callback) {
        Call<List<EmpExtras>> call = empApi.getEmpExtras(Constants.API_KEY);
        call.enqueue(callback);
    }
}
