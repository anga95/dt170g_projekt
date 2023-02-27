package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class addLunch extends AppCompatActivity {
    TextView placeholder;

    private RecyclerView mFoodsRecyclerView;
    private RecyclerView mSelectedFoodsRecyclerView;
    private SourceRecyclerAdapter mFoodsAdapter;
    private DestinationRecyclerAdapter mSelectedFoodsAdapter;
    private List<String> foods;
    private List<String> drinks;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        placeholder = findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        foods = new ArrayList<>();
        foods.add("Pizza");
        foods.add("Burger");
        foods.add("Taco");
        foods.add("Sushi");

        drinks = new ArrayList<>();
        drinks.add("Vatten");
        drinks.add("Fanta");
        drinks.add("Cola");
        drinks.add("Ramlösa");

        mSelectedFoodsAdapter = new DestinationRecyclerAdapter(new HashMap<>());
        mSelectedFoodsRecyclerView = findViewById(R.id.orderRecyclerView);
        mSelectedFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSelectedFoodsRecyclerView.setAdapter(mSelectedFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(foods, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(drinks, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.drinkRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);


    }

}