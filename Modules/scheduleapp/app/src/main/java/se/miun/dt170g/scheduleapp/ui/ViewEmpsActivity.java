package se.miun.dt170g.scheduleapp.ui;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import se.miun.dt170g.scheduleapp.R;
import se.miun.dt170g.scheduleapp.utils.Constants;
import se.miun.dt170g.scheduleapp.utils.HttpAsyncTask;

public class ViewEmpsActivity extends AppCompatActivity {

    private JSONObject empRollingWeeksObj = null;
    private JSONObject empLeavesObj = null;
    private JSONObject empExtraDaysObj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_emps);


        // custom image for action bar start
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflator = LayoutInflater.from(this);
        View view = inflator.inflate(R.layout.custom_title, null);
        actionBar.setCustomView(view);


        // Set the column width to a fixed size
        final int COLUMN_WIDTH_DP = 100; // replace with your desired width in dp
        final float SCALE = getResources().getDisplayMetrics().density;
        final int COLUMN_WIDTH_PX = (int) (COLUMN_WIDTH_DP * SCALE + 0.5f);

        TableLayout tableLayout = findViewById(R.id.schedule_table2);

        // Get the number of days in the current month and the name of the current month
        Calendar calendar = Calendar.getInstance();
        int numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Set the calendar to the first day of the current month
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // format the month and year to display in the TextView
        String monthYearTitle = (String) android.text.format.DateFormat.format("MMM yyyy", new Date());
        // Obtain a reference to the TextView using its ID
        TextView textView = findViewById(R.id.month_year_title2);
        // Set the text of the TextView
        textView.setText(monthYearTitle);






        // Create an instance of HttpAsyncTask
        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(new HttpAsyncTask.HttpAsyncTaskListener() {
            @Override
            public void onSuccess(HttpAsyncTask.HttpResponse response) {
                if(response != null) {
                    int statusCode = response.getStatusCode();
                    if (statusCode >= 200 && statusCode < 300) {

                       empRollingWeeksObj = response.getResponseData();

                       Log.d("=========== empRollingWeeksObj", empRollingWeeksObj.toString());


                        // loop through the json array and create a new json object with the empId as key
                        JSONObject newJson = new JSONObject();

                        for (int i = 0; i < empRollingWeeksObj.length(); i++) {
                            try {
                                JSONObject jsonObject = empRollingWeeksObj.getJSONObject(String.valueOf(i));
                                String empId = jsonObject.getString("empId");
                                newJson.put(empId, jsonObject);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        Log.d("newJson", newJson.toString());



                    } else {
                        // Handle null response
                        Log.d(TAG, "Empty json response");
                    }
                } else {
                    // Handle null response
                    AlertDialog.Builder builder = new AlertDialog.Builder(ViewEmpsActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("Bad response from server. Please try again.");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }
            }

            @Override
            public void onError(HttpAsyncTask.HttpResponse response) {
                // Handle error response
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewEmpsActivity.this);

                if(response == null) {
                    builder.setTitle("Error");
                    builder.setMessage("Could not connect to server. Please try again.");
                    builder.setPositiveButton("OK", null);
                } else {
                    int statusCode = response.getStatusCode();
                    if (statusCode >= 400 && statusCode < 500) {
                        // Client error
                        builder.setTitle("Client error");
                        builder.setMessage("Something went wrong. Please try again.");
                    } else if (statusCode >= 500 && statusCode < 600) {
                        // Server error

                        builder.setTitle("Server error");
                        builder.setMessage("Something went wrong. Please try again.");
                    } else {
                        // Other error
                        builder.setTitle("Employee shcedules not found");
                        builder.setMessage("Please report this to an admin.");
                    }
                }


                // If the email is not in the database, prompt the user to contact an admin
                builder.setPositiveButton("OK", null);
                builder.show();

            }
        });

        String url = Constants.API_BASE_URL + "/employee/joined-schedules";
        // Make a GET request
        httpAsyncTask.execute(url, "GET");









        Button forgetUser = findViewById(R.id.forget_user_button2);
        forgetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("empId", ""); //userInfo.getUsername()
                editor.apply();

                Intent intent = new Intent(ViewEmpsActivity.this, MainActivity.class);
                // Change view to ViewScheduleActivity
                startActivity(intent);
            }
        });
    }
}