package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class addLunch extends AppCompatActivity {

    private OrderItemAdapter orderItemAdapter;
    private TextView tableNumber;

    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged", "StaticFieldLeak"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        tableNumber = findViewById(R.id.tableNum);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        tableNumber.setText(message);

        // Initialize source and order recycler views and adapters
        RecyclerView foodsRecyclerView = findViewById(R.id.mainCourseRecyclerView);
        RecyclerView drinksRecyclerView = findViewById(R.id.drinkRecyclerView);
        RecyclerView orderRecyclerView = findViewById(R.id.orderRecyclerView);
        List<SourceItem> foodsItemList = new ArrayList<>();
        List<SourceItem> drinksItemList = new ArrayList<>();
        List<OrderItem> orderItemList = new ArrayList<>();

        SourceRecyclerAdapter foodsRecyclerAdapter = new SourceRecyclerAdapter(foodsItemList, sourceItem -> orderItemAdapter.addItem(sourceItem));
        SourceRecyclerAdapter drinksRecyclerAdapter = new SourceRecyclerAdapter(drinksItemList, sourceItem -> orderItemAdapter.addItem(sourceItem));

        orderItemAdapter = new OrderItemAdapter(orderItemList, this, OrderItem::setQuantity);

        foodsRecyclerView.setAdapter(foodsRecyclerAdapter);
        foodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        drinksRecyclerView.setAdapter(drinksRecyclerAdapter);
        drinksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderRecyclerView.setAdapter(orderItemAdapter);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        new HttpUtils("GET") {
            @Override
            protected void onPostExecute(String result) {
                // Parse JSON data and extract the items you need
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String itemName = jsonObject.getString("name");
                        double itemPrice = jsonObject.getDouble("price");
                        String category = jsonObject.getString("category");
                        SourceItem item = new SourceItem(itemName, itemPrice, category);
                        if (category.equals("Lunch")) {
                            foodsItemList.add(item);
                        } else if (category.equals("Drinks")) {
                            drinksItemList.add(item);
                        }
                    }
                    // Notify adapter that data has changed
                    foodsRecyclerAdapter.notifyDataSetChanged();
                    drinksRecyclerAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute("http://10.0.2.2:8080/antons-skafferi/api/MenuItems/Json");

    }

    @SuppressLint("StaticFieldLeak")
    public void sendToKitchen(View view) {
        String tableText = tableNumber.getText().toString();

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tableText);
        if(matcher.find()){
            String numberString = matcher.group();
            int tableNum = Integer.parseInt(numberString);
            List<OrderItem> orderItemList = orderItemAdapter.getOrderItemList();
            Order order = new Order(tableNum, orderItemList);

            // Convert the order to a JSON string
            Gson gson = new Gson();
            String jsonOrder = gson.toJson(order);

            // Send a POST request to add the order to the database table
            new HttpUtils("POST") {
                @Override
                protected void onPostExecute(String result) {
                    // Do something with the result, if needed
                }
            }.execute("http://10.0.2.2:8080/antons-skafferi/api/MenuItems/Insert", jsonOrder);

        }

    }
}