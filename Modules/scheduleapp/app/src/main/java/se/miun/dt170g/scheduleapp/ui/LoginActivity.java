package se.miun.dt170g.scheduleapp.ui;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


import se.miun.dt170g.scheduleapp.R;
import se.miun.dt170g.scheduleapp.utils.Constants;
import se.miun.dt170g.scheduleapp.utils.HttpAsyncTask;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // custom image for action bar start
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflator = LayoutInflater.from(this);
        View view = inflator.inflate(R.layout.custom_title, null);
        actionBar.setCustomView(view);

        // Get the UUID of the device
        Button identifyButton = findViewById(R.id.buttonIdentifyEmail);
        identifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject requestData = new JSONObject();
                String uuid = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                TextView emailView = findViewById(R.id.editTextUserEmail);
                String email = emailView.getText().toString();

                // Check if email is not like an email address using regex
                if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Please enter your email address");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // user clicked OK, continue with operation
                            emailView.setText("");
                            emailView.requestFocus();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                try {
                    requestData.put("email", email);
                    requestData.put("deviceId", uuid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Create an instance of HttpAsyncTask
                HttpAsyncTask httpAsyncTask = new HttpAsyncTask(new HttpAsyncTask.HttpAsyncTaskListener() {
                    @Override
                    public void onSuccess(HttpAsyncTask.HttpResponse response) {
                        if(response != null) {
                            int statusCode = response.getStatusCode();
                            String empId = "";
                            if (statusCode >= 200 && statusCode < 300) {
                                JSONObject responseJson = response.getResponseData();
                                empId = responseJson.optString("id");

                                // Save the user info in shared preferences
                                SharedPreferences prefs = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("empId", empId); //empId.getUsername()
                                editor.apply();

                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("You are now logged in. Continue to schedule page?");
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // user clicked OK, continue with operation
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        // Change view to ViewScheduleActivity
                                        startActivity(intent);
                                    }
                                });
                                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // user cancelled the dialog, do nothing
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            } else {
                                // Handle null response
                                Log.d(TAG, "Empty json response");
                            }
                        } else {
                            // Handle null response
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setTitle("Error");
                            builder.setMessage("Bad response from server. Please try again.");
                            builder.setPositiveButton("OK", null);
                            builder.show();
                        }
                    }

                    @Override
                    public void onError(HttpAsyncTask.HttpResponse response) {
                        // Handle error response
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

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
                                builder.setTitle("User not found");
                                builder.setMessage("Please contact the manager to register your account.");
                            }
                        }


                        // If the email is not in the database, prompt the user to contact an admin
                        builder.setPositiveButton("OK", null);
                        builder.show();


                    }
                });


                String url = Constants.API_BASE_URL + "/employee/verify";
                // Make a GET request
                //httpAsyncTask.execute(url, "GET");

                // Make a POST request
                httpAsyncTask.execute(url, "POST", requestData.toString());


            }
        });
    }
}