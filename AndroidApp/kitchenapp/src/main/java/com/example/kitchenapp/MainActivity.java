package com.example.kitchenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button2 = findViewById(R.id.kockBtn);
        button2.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, ChefPage.class);
            startActivity(intent2);
        });
    }
}