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
    private RecyclerView mFoodsRecyclerView;
    private RecyclerView mSelectedFoodsRecyclerView;
    private SourceRecyclerAdapter mFoodsAdapter;
    private DestinationRecyclerAdapter mSelectedFoodsAdapter;

    private List<String> appertizers;
    private List<String> mainCourse;
    private List<String> desserts;
    private List<String> drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ala_carte);

        placeholder = findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        appertizers = new ArrayList<>();
        appertizers.add("Tiramisu");
        appertizers.add("Bruchetta");
        appertizers.add("Scampi");
        appertizers.add("Kaffe");

        mainCourse = new ArrayList<>();
        mainCourse.add("Pizza med extra allt av alla toppingar och paprika");
        mainCourse.add("Burger");
        mainCourse.add("Taco");
        mainCourse.add("Sushi");

        desserts = new ArrayList<>();
        desserts.add("Glass");
        desserts.add("Bulle");
        desserts.add("Kaka");
        desserts.add("Svensson");

        drinks = new ArrayList<>();
        drinks.add("Vatten");
        drinks.add("Fanta");
        drinks.add("Cola");
        drinks.add("Ramlösa");

        mSelectedFoodsAdapter = new DestinationRecyclerAdapter(new HashMap<>());
        mSelectedFoodsRecyclerView = findViewById(R.id.orderRecyclerView);
        mSelectedFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSelectedFoodsRecyclerView.setAdapter(mSelectedFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(appertizers, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.appertizerRecyclerView);
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