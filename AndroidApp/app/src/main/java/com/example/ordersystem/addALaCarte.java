package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class addALaCarte extends AppCompatActivity {

    TextView placeholder;
    private OrderItemAdapter orderItemAdapter;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ala_carte);

        Button button = findViewById(R.id.sendToKitchen);

        // Initialize source and order recycler views and adapters
        RecyclerView appertizerRecylerView = findViewById(R.id.appertizerRecyclerView);
        RecyclerView mainCourseRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        RecyclerView dessertRecyclerView = findViewById(R.id.dessertRecyclerView);
        RecyclerView drinksRecyclerView = findViewById(R.id.drinkRecyclerView);
        RecyclerView orderRecyclerView = findViewById(R.id.orderRecyclerView);

        List<SourceItem> appertizerList = new ArrayList<>();
        List<SourceItem> mainCourseList = new ArrayList<>();
        List<SourceItem> dessertList = new ArrayList<>();
        List<SourceItem> drinksItemList = new ArrayList<>();
        List<OrderItem> orderItemList = new ArrayList<>();
        List<OrderItem> sendToKitchenList = new ArrayList<>();

        SourceRecyclerAdapter appertizerAdapter = new SourceRecyclerAdapter(appertizerList, sourceItem -> orderItemAdapter.addItem(sourceItem));
        SourceRecyclerAdapter mainCourseAdapter = new SourceRecyclerAdapter(mainCourseList, sourceItem -> orderItemAdapter.addItem(sourceItem));
        SourceRecyclerAdapter dessertAdapter = new SourceRecyclerAdapter(dessertList, sourceItem -> orderItemAdapter.addItem(sourceItem));
        SourceRecyclerAdapter drinksRecyclerAdapter = new SourceRecyclerAdapter(drinksItemList, sourceItem -> orderItemAdapter.addItem(sourceItem));

        orderItemAdapter = new OrderItemAdapter(orderItemList, this, OrderItem::setQuantity);

        appertizerRecylerView.setAdapter(appertizerAdapter);
        appertizerRecylerView.setLayoutManager(new LinearLayoutManager(this));

        mainCourseRecyclerView.setAdapter(mainCourseAdapter);
        mainCourseRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        dessertRecyclerView.setAdapter(dessertAdapter);
        dessertRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        drinksRecyclerView.setAdapter(drinksRecyclerAdapter);
        drinksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        orderRecyclerView.setAdapter(orderItemAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate source item list with dummy data
        appertizerList.add(new SourceItem("Bruschetta", 1.99, "StarterItem"));
        appertizerList.add(new SourceItem("Salladsblad", 2.99, "StarterItem"));
        appertizerList.add(new SourceItem("Isbit", 3.99, "StarterItem"));
        appertizerList.add(new SourceItem("Löv", 4.99, "StarterItem"));
        appertizerList.add(new SourceItem("Tartar", 5.99, "StarterItem"));
        appertizerAdapter.notifyDataSetChanged();

        mainCourseList.add(new SourceItem("Pizza", 1.99, "LunchItem"));
        mainCourseList.add(new SourceItem("Hamburgare", 2.99, "LunchItem"));
        mainCourseList.add(new SourceItem("Sushi", 3.99, "LunchItem"));
        mainCourseList.add(new SourceItem("Fläskytterfilé", 4.99, "LunchItem"));
        mainCourseList.add(new SourceItem("Lammstek med rostad potatis", 5.99, "LunchItem"));
        mainCourseAdapter.notifyDataSetChanged();

        dessertList.add(new SourceItem("Glass", 1.99, "DessertItem"));
        dessertList.add(new SourceItem("Milkshake", 2.99, "DessertItem"));
        dessertList.add(new SourceItem("Kaffe", 3.99, "DessertItem"));
        dessertList.add(new SourceItem("Melonshake", 4.99, "DessertItem"));
        dessertList.add(new SourceItem("Gelato", 5.99, "DessertItem"));
        dessertAdapter.notifyDataSetChanged();

        drinksItemList.add(new SourceItem("Vatten", 1.99, "DrinkItem"));
        drinksItemList.add(new SourceItem("Fanta", 2.99, "DrinkItem"));
        drinksItemList.add(new SourceItem("Cola", 3.99, "DrinkItem"));
        drinksItemList.add(new SourceItem("Pepsi", 4.99, "DrinkItem"));
        drinksItemList.add(new SourceItem("Hallonsodia", 5.99, "DrinkItem"));
        drinksRecyclerAdapter.notifyDataSetChanged();
        button.setOnClickListener(view -> {
            List<OrderItem> orderItems = orderItemAdapter.getOrderItemList();
            for(OrderItem order: orderItems){
                System.out.println(order);
            }
        });
    }

}