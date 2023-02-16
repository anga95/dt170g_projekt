package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Spinner;

public class addLunch extends AppCompatActivity {
    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);
        placeholder = (TextView)findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        Spinner spinnerCourses=findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCourses.setAdapter(adapter);
    }
}