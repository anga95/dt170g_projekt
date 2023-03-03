package se.miun.dt170g.scheduleapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import se.miun.dt170g.scheduleapp.api.EmpApi;
import se.miun.dt170g.scheduleapp.model.EmpExtras;
import se.miun.dt170g.scheduleapp.model.EmpLeaves;
import se.miun.dt170g.scheduleapp.model.EmpSchedule;
import se.miun.dt170g.scheduleapp.utils.Constants;
import se.miun.dt170g.scheduleapp.utils.RetrofitClient;

public class EmpScheduleViewModel extends ViewModel {

        private MutableLiveData<List<EmpSchedule>> mEmployeeScheduleLiveData;
        private MutableLiveData<List<EmpLeaves>> mEmployeeLeavesLiveData;
        private MutableLiveData<List<EmpExtras>> mEmployeeExtrasLiveData;

        public LiveData<List<EmpSchedule>> getEmployeeScheduleLiveData() {
            if (mEmployeeScheduleLiveData == null) {
                mEmployeeScheduleLiveData = new MutableLiveData<>();
            }
            return mEmployeeScheduleLiveData;
        }
        public LiveData<List<EmpLeaves>> getEmployeeLeavesLiveData() {
            if (mEmployeeLeavesLiveData == null) {
                mEmployeeLeavesLiveData = new MutableLiveData<>();
            }
            return mEmployeeLeavesLiveData;
        }
        public LiveData<List<EmpExtras>> getEmployeeExtrasLiveData() {
            if (mEmployeeExtrasLiveData == null) {
                mEmployeeExtrasLiveData = new MutableLiveData<>();
            }
            return mEmployeeExtrasLiveData;
        }

        public void loadEmployeeSchedule() {
            // Use RetrofitClient to make the API call and update the LiveData with the response
            EmpApi api = RetrofitClient.getEmployeeApi();
            api.getEmpSchedules(Constants.API_KEY).enqueue(new Callback<List<EmpSchedule>>() {
                @Override
                public void onResponse(Call<List<EmpSchedule>> call, Response<List<EmpSchedule>> response) {
                    if (response.isSuccessful()) {
                        mEmployeeScheduleLiveData.setValue(response.body());
                    } else {
                        // Handle error response
                    }
                }

                @Override
                public void onFailure(Call<List<EmpSchedule>> call, Throwable t) {
                    // Handle failure
                }
            });
            api.getEmpLeaves(Constants.API_KEY).enqueue(new Callback<List<EmpLeaves>>() {
                @Override
                public void onResponse(Call<List<EmpLeaves>> call, Response<List<EmpLeaves>> response) {
                    if (response.isSuccessful()) {
                        mEmployeeLeavesLiveData.setValue(response.body());
                    } else {
                        // Handle error response
                    }
                }

                @Override
                public void onFailure(Call<List<EmpLeaves>> call, Throwable t) {
                    // Handle failure
                }
            });
            api.getEmpExtras(Constants.API_KEY).enqueue(new Callback<List<EmpExtras>>() {
                @Override
                public void onResponse(Call<List<EmpExtras>> call, Response<List<EmpExtras>> response) {
                    if (response.isSuccessful()) {
                        mEmployeeExtrasLiveData.setValue(response.body());
                    } else {
                        // Handle error response
                    }
                }

                @Override
                public void onFailure(Call<List<EmpExtras>> call, Throwable t) {
                    // Handle failure
                }
            });
        }
    }
