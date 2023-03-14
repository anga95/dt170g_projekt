package com.example.ordersystem;

import android.graphics.Color;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
                    JSONObject jsonObject = new JSONObject(result);
                    String lunch1 = jsonObject.getString("lunch1");
                    String lunch2 = jsonObject.getString("lunch2");
                    String lunch3 = jsonObject.getString("lunch3");
                    double itemPrice = jsonObject.getDouble("price");
                    String category = jsonObject.getString("weekday");
                    int idNum = jsonObject.getInt("id");
                    int time = jsonObject.getInt("time");
                    SourceItem lunchOne = new SourceItem(lunch1, itemPrice, category, idNum, time);
                    SourceItem lunchTwo = new SourceItem(lunch2, itemPrice, category, idNum, time);
                    SourceItem lunchThree = new SourceItem(lunch3, itemPrice, category, idNum, time);
                    foodsItemList.add(lunchOne);
                    foodsItemList.add(lunchTwo);
                    foodsItemList.add(lunchThree);

                    // Notify adapter that data has changed
                    foodsRecyclerAdapter.notifyDataSetChanged();
                    //drinksRecyclerAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute("http://10.0.2.2:8080/antons-skafferi/api/dailylunch/getTodaysLunch");

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
            JsonArray orderItemArray = new JsonArray();
            for (OrderItem item : order.getOrderItemList()) {
                JsonObject orderItemObject = new JsonObject();
                orderItemObject.addProperty("name", item.getName());
                orderItemObject.addProperty("quantity", item.getQuantity());
                orderItemObject.addProperty("category", item.getCategory());
                orderItemObject.addProperty("time", item.getTime());
                orderItemObject.addProperty("note", item.getNote());
                orderItemObject.addProperty("tableNumber", order.getTableNumber());
                orderItemArray.add(orderItemObject);
            }
            String jsonOrder = gson.toJson(orderItemArray);
            HttpUtils httpUtils = new HttpUtils("POST");
            httpUtils.execute("http://10.0.2.2:8080/antons-skafferi/api/TotalOrders/addOrders", jsonOrder);
        }
        Intent intent = new Intent();
        intent.putExtra("isSentToKitchen", true);
        setResult(RESULT_OK, intent);
        finish();
    }
}