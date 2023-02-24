package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class addALaCarte extends AppCompatActivity {

    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ala_carte);

        placeholder = findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));
    }
}