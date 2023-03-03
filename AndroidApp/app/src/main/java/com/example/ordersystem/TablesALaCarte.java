package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TablesALaCarte extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_ala_carte);

    }

    public void nextWindow(String value){
        Intent intent = new Intent(TablesALaCarte.this, addALaCarte.class);
        intent.putExtra("message", value);
        startActivity(intent);
    }

    @SuppressLint("NonConstantResourceId")
    public void helpB(View view) {
        Button clickedButton = (Button) view;
        switch(clickedButton.getId()){
            case R.id.table1Btn:
                nextWindow("Table 1");
                break;
            case R.id.table2Btn:
                nextWindow("Table 2");
                break;
            case R.id.table3Btn:
                nextWindow("Table 3");
                break;
            case R.id.table4Btn:
                nextWindow("Table 4");
                break;
            case R.id.table5Btn:
                nextWindow("Table 5");
                break;
            case R.id.table6Btn:
                nextWindow("Table 6");
                break;
            case R.id.table7Btn:
                nextWindow("Table 7");
                break;
            case R.id.table8Btn:
                nextWindow("Table 8");
                break;
        }
    }
}