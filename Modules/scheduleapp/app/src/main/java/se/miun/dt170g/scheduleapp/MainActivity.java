package se.miun.dt170g.scheduleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.jakewharton.threetenabp.AndroidThreeTen;

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



        SharedPreferences sharedPref = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
        String myValue = sharedPref.getString("userIdentified", "");
        if (myValue.equals("")){
            // change view to LoginAcitvity
            Intent myIntent = new Intent(this, LoginActivity.class);
            startActivity(myIntent);
        } else {
            // change view to LoginAcitvity
            Intent myIntent = new Intent(this, ViewSchduleActivity.class);
            startActivity(myIntent);
        }


//        // change view to LoginAcitvity
//        Intent myIntent = new Intent(this, ViewSchduleActivity.class);
//        startActivity(myIntent);
    }
}