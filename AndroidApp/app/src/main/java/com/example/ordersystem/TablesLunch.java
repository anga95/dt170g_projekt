package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class TablesLunch extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_lunch);

        button1 = (Button)findViewById(R.id.table1Btn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(TablesLunch.this, addLunch.class);
            startActivity(intent);
        });
    }
}