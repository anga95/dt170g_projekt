package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class addLunch extends AppCompatActivity {
    TextView placeholder;

    private final Set<String> selectedItems = new HashSet<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        placeholder = findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        List<String> wholeMenu = Arrays.asList("Hamburgare", "Fisk med pinnar", "Lasagne med ädelostsås och ruccola", "Vatten", "Coca-Cola", "Fanta");
        List<String> drinks = Arrays.asList("Vatten", "Coca-Cola", "Fanta");
        List<String> foods = Arrays.asList("Hamburgare", "Fisk med pinnar", "Lasagne med ädelostsås och ruccola");

        ListView destinationList = findViewById(R.id.totalOrderList);
        DestinationListAdapter destinationListAdapter = new DestinationListAdapter(this, R.layout.totalorder_listview, wholeMenu, selectedItems);
        destinationList.setAdapter(destinationListAdapter);

        ListView sourceList = findViewById(R.id.foodsList);
        SourceListAdapter sourceListAdapter = new SourceListAdapter(this, R.layout.custom_listview, foods, destinationListAdapter);
        sourceList.setAdapter(sourceListAdapter);

        sourceList = findViewById(R.id.drinksList);
        sourceListAdapter = new SourceListAdapter(this, R.layout.custom_listview, drinks, destinationListAdapter);
        sourceList.setAdapter(sourceListAdapter);


    }

}