package se.miun.dt170g.scheduleapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ExecutionException;

import se.miun.dt170g.scheduleapp.R;
import se.miun.dt170g.scheduleapp.utils.HttpUtils;

public class LoginActivity extends AppCompatActivity {

    private static final String ANTONS_SKAFFERI_URL = "http://10.0.2.2:8080/AntonsSkafferi/api";

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
                String uuid = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                String email = findViewById(R.id.editTextUserEmail).toString();
                String empId = "";

                // Check if the UUID is in the database
                if (isEmailInDatabase(email, uuid)) {
                    // If the UUID is in the database, retrieve the user info

                    if (getUserInfoByUuid(uuid)) {
                        empId = "1";
                    } else {
                        empId = "0";
                    }

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
                    // If the email is not in the database, prompt the user to contact an admin
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("User not found");
                    builder.setMessage("Please contact the manager to register your account.");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }
            }
        });

    }

    private Boolean getUserInfoByUuid(String uuid) {
        // api call to get user info by uuid
        String url = ANTONS_SKAFFERI_URL + "/test";
        HttpUtils httpUtils = new HttpUtils();

        String result;
        try {
            result = httpUtils.execute(url).get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (result.equals("Hello World")) {
            return true;
        }
        return true; //TODO: fix this
    }

    private boolean isEmailInDatabase(String email, String uuid) {
        // api call to check if email is in database

        // api call to get user info by uuid
        String url = ANTONS_SKAFFERI_URL + "/verify-emp?email=" + email + "&uuid=" + uuid;
        HttpUtils httpUtils = new HttpUtils();

        String result;
        try {
            result = httpUtils.execute(url).get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (result.equals("Hello World")) {
            return true;
        }
        return true;
    }
}