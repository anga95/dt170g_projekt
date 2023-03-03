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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class addLunch extends AppCompatActivity {

    TextView placeholder;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        placeholder = findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        List<String> foods = new ArrayList<>();
        foods.add("Pizza");
        foods.add("Burger");
        foods.add("Taco");
        foods.add("Sushi");

        List<String> drinks = new ArrayList<>();
        drinks.add("Vatten");
        drinks.add("Fanta");
        drinks.add("Cola");
        drinks.add("Ramlösa");

        DestinationRecyclerAdapter mSelectedFoodsAdapter = new DestinationRecyclerAdapter(new HashMap<>());
        RecyclerView mSelectedFoodsRecyclerView = findViewById(R.id.orderRecyclerView);
        mSelectedFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSelectedFoodsRecyclerView.setAdapter(mSelectedFoodsAdapter);

        SourceRecyclerAdapter mFoodsAdapter = new SourceRecyclerAdapter(foods, mSelectedFoodsAdapter);
        RecyclerView mFoodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(drinks, mSelectedFoodsAdapter);
        mFoodsRecyclerView = findViewById(R.id.drinkRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);


    }

}