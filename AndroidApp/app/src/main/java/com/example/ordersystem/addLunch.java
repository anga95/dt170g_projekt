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
    private RecyclerView sourceRecyclerView, orderRecyclerView;
    private SourceRecyclerAdapter sourceRecyclerAdapter;
    private OrderItemAdapter orderItemAdapter;
    private List<SourceItem> sourceItemList;
    private List<OrderItem> orderItemList;
    private double totalPrice;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        // Initialize source and order recycler views and adapters
        sourceRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        orderRecyclerView = findViewById(R.id.orderRecyclerView);
        sourceItemList = new ArrayList<>();
        orderItemList = new ArrayList<>();
        sourceRecyclerAdapter = new SourceRecyclerAdapter(sourceItemList, new SourceRecyclerAdapter.SourceItemClickListener() {
            @Override
            public void onItemAdded(SourceItem sourceItem) {
                orderItemAdapter.addItem(sourceItem);
                //updateTotalPrice();
            }
        });
        orderItemAdapter = new OrderItemAdapter(orderItemList, new OrderItemAdapter.OrderItemClickListener() {
            @Override
            public void onItemQuantityChanged(OrderItem orderItem, int newQuantity) {
                orderItem.setQuantity(newQuantity);
                //updateTotalPrice();
            }
        });
        sourceRecyclerView.setAdapter(sourceRecyclerAdapter);
        sourceRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderRecyclerView.setAdapter(orderItemAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate source item list with dummy data
        sourceItemList.add(new SourceItem("Item 1", 1.99));
        sourceItemList.add(new SourceItem("Item 2", 2.99));
        sourceItemList.add(new SourceItem("Item 3", 3.99));
        sourceItemList.add(new SourceItem("Item 4", 4.99));
        sourceItemList.add(new SourceItem("Item 5", 5.99));
        sourceRecyclerAdapter.notifyDataSetChanged();

        //RecyclerView foodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        //foodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //SourceRecyclerAdapter sourceRecyclerAdapter = new SourceRecyclerAdapter(foodsList, this);

        /*placeholder = findViewById(R.id.tableNum);
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

        *//*DestinationRecyclerAdapter mSelectedFoodsAdapter = new DestinationRecyclerAdapter(new HashMap<>());
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
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);*//*


        RecyclerView orderRecyclerView = findViewById(R.id.orderRecyclerView);
        Button submitButton = findViewById(R.id.sendToKitchen);

        List<OrderItem> orderItems = new ArrayList<>();

        //orderItems.add(new OrderItem("Item 1", 0, ""));
        //orderItems.add(new OrderItem("Item 2", 0, ""));
        //orderItems.add(new OrderItem("Item 3", 0, ""));

        OrderItemAdapter orderAdapter = new OrderItemAdapter(orderItems);

        orderRecyclerView.setAdapter(orderAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        *//*SourceRecyclerAdapter mFoodsAdapter = new SourceRecyclerAdapter(foods, orderAdapter);
        RecyclerView mFoodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);

        mFoodsAdapter = new SourceRecyclerAdapter(drinks, orderAdapter);
        mFoodsRecyclerView = findViewById(R.id.drinkRecyclerView);
        mFoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodsRecyclerView.setAdapter(mFoodsAdapter);*//*

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<OrderItem> orderItems = orderAdapter.getOrderItems();
                for (OrderItem orderItem : orderItems) {
                    String name = orderItem.getName();
                    int quantity = orderItem.getQuantity();
                    String note = orderItem.getNote();
                    // Add order item to total order
                }
            }
        });
*/

    }

    /*@SuppressLint("DefaultLocale")
    private void updateTotalPrice() {
        totalPrice = 0;
        for (OrderItem orderItem : orderItemList) {
            totalPrice += orderItem.getQuantity() * orderItem.getPrice();
        }
        TextView totalPriceTextView = findViewById(R.id.priceTextView);
        totalPriceTextView.setText(String.format("Total price: %.2f", totalPrice));
    }*/

    /*public void sendTotalOrder(View view) {
        // Create order object and send it
        Order order = new Order(orderItemList, totalPrice);
        // TODO: send order
    }*/

}