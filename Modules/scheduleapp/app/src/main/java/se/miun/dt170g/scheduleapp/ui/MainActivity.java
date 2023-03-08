package se.miun.dt170g.scheduleapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.jakewharton.threetenabp.AndroidThreeTen;

import se.miun.dt170g.scheduleapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidThreeTen.init(this);

        // custom image for action bar start
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflator = LayoutInflater.from(this);
        View view = inflator.inflate(R.layout.custom_title, null);
        actionBar.setCustomView(view);



        // Save the user info in shared preferences
        SharedPreferences sharedPref = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
        String myValue = sharedPref.getString("empId", "0");
        if (!myValue.equals("0")){
            // change view to LoginAcitvity
            Intent myIntent = new Intent(this, LoginActivity.class);
            startActivity(myIntent);
        } else {
            // change view to schedule
            Intent myIntent = new Intent(this, ViewSchduleActivity.class);
            startActivity(myIntent);
        }
    }
}