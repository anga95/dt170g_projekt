package se.miun.dt170g.scheduleapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.miun.dt170g.scheduleapp.api.EmpApi;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static EmpApi getEmployeeApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(EmpApi.class);
    }
}
