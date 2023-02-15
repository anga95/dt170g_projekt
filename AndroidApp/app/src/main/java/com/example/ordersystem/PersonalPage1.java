package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PersonalPage1 extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page1);

        button1 = (Button)findViewById(R.id.dagensLunchBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(PersonalPage1.this, Tables.class);
            startActivity(intent);
        });

        button1 = (Button)findViewById(R.id.aLaCarteBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(PersonalPage1.this, Tables.class);
            startActivity(intent);
        });
    }
}