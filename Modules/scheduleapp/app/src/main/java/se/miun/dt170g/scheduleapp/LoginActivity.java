package se.miun.dt170g.scheduleapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;

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
        String uuid = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        System.out.println("our uuid " + uuid);

// Check if the UUID is in the database
        if (isUuidInDatabase(uuid)) {
            // If the UUID is in the database, retrieve the user info
            boolean userInfo = getUserInfoByUuid(uuid);

            // Save the user info in shared preferences
            SharedPreferences prefs = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("userIdentified", "1"); //userInfo.getUsername()
            editor.apply();

            // Change view to ViewScheduleActivity
            Intent intent = new Intent(this, ViewSchduleActivity.class);
            startActivity(intent);
        } else {
            // If the UUID is not in the database, prompt the user to contact an admin
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("User not found");
            builder.setMessage("Please contact an admin to add your account to the database.");
            builder.setPositiveButton("OK", null);
            builder.show();
        }

    }

    private boolean getUserInfoByUuid(String uuid) {
        // api call to get user info by uuid
        return true;
    }

    private boolean isUuidInDatabase(String uuid) {
        // api call to check if uuid is in database
        return false;
    }
}