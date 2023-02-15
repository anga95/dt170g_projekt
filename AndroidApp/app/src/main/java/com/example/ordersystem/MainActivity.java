package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.personalBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PersonalPage1.class);
            startActivity(intent);
        });
    }
}