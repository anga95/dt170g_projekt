package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.PendingIntent;
import android.app.Person;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;


public class PersonalPage1 extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page1);

        button1 = findViewById(R.id.dagensLunchBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(PersonalPage1.this, TablesLunch.class);
            startActivity(intent);


        });

        button1 = findViewById(R.id.aLaCarteBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(PersonalPage1.this, TablesALaCarte.class);
            startActivity(intent);
        });
    }
}