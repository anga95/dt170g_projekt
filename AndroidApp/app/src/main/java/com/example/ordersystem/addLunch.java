package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class addLunch extends AppCompatActivity {
    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);
        placeholder = (TextView)findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));
    }
}