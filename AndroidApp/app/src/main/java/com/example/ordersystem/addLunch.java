package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class addLunch extends AppCompatActivity {

    private OrderItemAdapter orderItemAdapter;

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);
        Button button = findViewById(R.id.sendToKitchen);

        // Initialize source and order recycler views and adapters
        RecyclerView foodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        RecyclerView drinksRecyclerView = findViewById(R.id.drinkRecyclerView);
        RecyclerView orderRecyclerView = findViewById(R.id.orderRecyclerView);
        List<SourceItem> foodsItemList = new ArrayList<>();
        List<SourceItem> drinksItemList = new ArrayList<>();
        List<OrderItem> orderItemList = new ArrayList<>();
        List<OrderItem> sendToKitchenList = new ArrayList<>();

        SourceRecyclerAdapter foodsRecyclerAdapter = new SourceRecyclerAdapter(foodsItemList, sourceItem -> orderItemAdapter.addItem(sourceItem));

        SourceRecyclerAdapter drinksRecyclerAdapter = new SourceRecyclerAdapter(drinksItemList, sourceItem -> orderItemAdapter.addItem(sourceItem));

        orderItemAdapter = new OrderItemAdapter(orderItemList, this, OrderItem::setQuantity);
        foodsRecyclerView.setAdapter(foodsRecyclerAdapter);
        foodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        drinksRecyclerView.setAdapter(drinksRecyclerAdapter);
        drinksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderRecyclerView.setAdapter(orderItemAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate source item list with dummy data
        foodsItemList.add(new SourceItem("Pizza", 1.99, "lunchItem"));
        foodsItemList.add(new SourceItem("Hamburgare", 2.99, "lunchItem"));
        foodsItemList.add(new SourceItem("Sushi", 3.99, "lunchItem"));
        foodsItemList.add(new SourceItem("Fläskytterfilé", 4.99, "lunchItem"));
        foodsItemList.add(new SourceItem("Lammstek med rostad potatis", 5.99, "lunchItem"));
        foodsRecyclerAdapter.notifyDataSetChanged();

        drinksItemList.add(new SourceItem("Vatten", 1.99, "drinkItem"));
        drinksItemList.add(new SourceItem("Fanta", 2.99, "drinkItem"));
        drinksItemList.add(new SourceItem("Cola", 3.99, "drinkItem"));
        drinksItemList.add(new SourceItem("Pepsi", 4.99, "drinkItem"));
        drinksItemList.add(new SourceItem("Hallonsodia", 5.99, "drinkItem"));
        drinksRecyclerAdapter.notifyDataSetChanged();
        button.setOnClickListener(view -> {
            List<OrderItem> orderItems = orderItemAdapter.getOrderItemList();
            for(OrderItem order: orderItems){
                System.out.println(order);
            }
        });

    }

}