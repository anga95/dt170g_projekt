package se.miun.dt170g.chefapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //test
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.personalBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PersonalPage1.class);
            startActivity(intent);
        });

        button2 = (Button)findViewById(R.id.kockBtn);
        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, ChefPage.class);
            startActivity(intent2);
        });
    }
}