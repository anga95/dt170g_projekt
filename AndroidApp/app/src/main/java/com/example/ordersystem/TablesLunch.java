package com.example.ordersystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TablesLunch extends AppCompatActivity {

    private Map<Integer, String> buttonMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_lunch);

        // Initialize the map with button IDs and table names
        buttonMap.put(R.id.table1Btn, "Table 1");
        buttonMap.put(R.id.table2Btn, "Table 2");
        buttonMap.put(R.id.table3Btn, "Table 3");
        buttonMap.put(R.id.table4Btn, "Table 4");
        buttonMap.put(R.id.table5Btn, "Table 5");
        buttonMap.put(R.id.table6Btn, "Table 6");
        buttonMap.put(R.id.table7Btn, "Table 7");
        buttonMap.put(R.id.table8Btn, "Table 8");
    }

    public void nextWindow(String value){
        Intent intent = new Intent(TablesLunch.this, addLunch.class);
        intent.putExtra("message", value);
        startActivityForResult(intent, 1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            boolean isSentToKitchen = data.getBooleanExtra("isSentToKitchen", false);
            if (isSentToKitchen) {
                String table = data.getStringExtra("table"); // Get the table name from the Intent
                int buttonId = getKeyByValue(buttonMap, table); // Get the button ID for the table
                Button button = findViewById(buttonId); // Find the button by ID
                button.setBackgroundColor(getResources().getColor(R.color.teal_200)); // Set the background color
            }
        }
    }

    // Utility method to get the key from a map based on the value
    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}