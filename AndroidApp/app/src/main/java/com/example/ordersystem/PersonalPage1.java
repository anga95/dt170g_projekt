package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PersonalPage1 extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page1);

        button1 = findViewById(R.id.dagensLunchBtn);
        button1.setOnClickListener(view -> {
            //Intent intent = new Intent(PersonalPage1.this, TablesLunch.class);
            //startActivity(intent);
            Intent intent = new Intent(PersonalPage1.this, ChefPage.class);
            intent.putExtra("message", "Det här gick ju bra");
            startActivity(intent);

        });

        button1 = findViewById(R.id.aLaCarteBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(PersonalPage1.this, TablesALaCarte.class);
            startActivity(intent);
        });
    }
}