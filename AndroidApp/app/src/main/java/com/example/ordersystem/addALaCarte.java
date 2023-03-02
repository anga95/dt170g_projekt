package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class addALaCarte extends AppCompatActivity {

    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ala_carte);

        placeholder = findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        List<String> appertizers = new ArrayList<>();
        appertizers.add("Tiramisu");
        appertizers.add("Bruchetta");
        appertizers.add("Scampi");
        appertizers.add("Kaffe");

        List<String> mainCourse = new ArrayList<>();
        mainCourse.add("Pizza med extra allt av alla toppingar och paprika");
        mainCourse.add("Burger");
        mainCourse.add("Taco");
        mainCourse.add("Sushi");

        List<String> desserts = new ArrayList<>();
        desserts.add("Glass");
        desserts.add("Bulle");
        desserts.add("Kaka");
        desserts.add("Svensson");

        List<String> drinks = new ArrayList<>();
        drinks.add("Vatten");
        drinks.add("Fanta");
        drinks.add("Cola");
        drinks.add("Ramlösa");

        DestinationRecyclerAdapter mSelectedFoodsAdapter = new DestinationRecyclerAdapter(new HashMap<>());
        RecyclerView mSelectedFoodsRecyclerView = findViewById(R.id.orderRecyclerView);
        mSelectedFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSelectedFoodsRecyclerView.setAdapter(mSelectedFoodsAdapter);

        SourceRecyclerAdapter mFoodsAdapter = new SourceRecyclerAdapter(appertizers, mSelectedFoodsAdapter);
        RecyclerView mFoodsRecyclerView = findViewById(R.id.appertizerRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(mainCourse, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(desserts, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.dessertRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(drinks, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.drinkRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

    }

}