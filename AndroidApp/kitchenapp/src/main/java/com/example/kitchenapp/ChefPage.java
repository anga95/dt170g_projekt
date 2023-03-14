package com.example.kitchenapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;


public class ChefPage extends AppCompatActivity{

    private RecyclerView orderArrayList;
    private ChefPageAdapter chefpageadapter;

    private CheckBox checkBoxstarter;

    private CheckBox checkBoxmaincourse;

    private CheckBox checkBoxdessert;

    private LinearLayout starterLayout;

    private LinearLayout maincourseLayout;

    private LinearLayout dessertLayout;
    private RecyclerView starter_List;
    private RecyclerView maincourse_List;
    private RecyclerView dessert_List;

    @SuppressLint("StaticFieldLeak")
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chef_page);

            orderArrayList = findViewById(R.id.order_List);


            ArrayList<Order> ordersamples = new ArrayList<>();
            new HttpUtils("GET") {
                @Override
                protected void onPostExecute(String result) {
                    // Parse JSON data and extract the items you need
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        Map<Integer, Order> ordersByTableNr = new HashMap<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String quantity = jsonObject.getString("quantity");
                            int tableNr = jsonObject.getInt("tableNr");
                            String name = jsonObject.getString("name");
                            String category = jsonObject.getString("category");
                            String note = jsonObject.getString("note");
                            String orderId = jsonObject.getString("id");

                            Order order = ordersByTableNr.get(tableNr);
                            if (order == null) {
                                order = new Order(tableNr, new ArrayList<String>(), new ArrayList<String>(),
                                        new ArrayList<String>(), false, false,
                            false, new ArrayList<>() ,new ArrayList<>(),0, new ArrayList<>(),
                                        new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                                        new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                                ordersByTableNr.put(tableNr, order);
                            }

                            switch(category) {
                                case "monday":
                                case "tuesday":
                                case "wednesday":
                                case "thursday":
                                case "friday":
                                case "Lunch":
                                case "MainCourse":
                                    order.getMainCourse().add(name);
                                    order.getMainCourseQuantity().add(quantity);
                                    order.getStarterNotes().add(note);
                                    order.getMainCourseIDs().add(orderId);
                                    break;
                                case "Starters":
                                    order.getStarter().add(name);
                                    order.getStarterQuantity().add(quantity);
                                    order.getMainCourseNotes().add(note);
                                    order.getStarterIDs().add(orderId);
                                    break;
                                case "Dessert":
                                    order.getDessert().add(name);
                                    order.getDessertQuantity().add(quantity);
                                    order.getDessertNotes().add(note);
                                    order.getDessertIDs().add(orderId);
                                    break;
                                default:
                                    break;
                            }
                        }

                        ArrayList<Order> ordersamples = new ArrayList<>(ordersByTableNr.values());
                        chefpageadapter = new ChefPageAdapter(getApplicationContext(), ordersamples);
                        orderArrayList.setAdapter(chefpageadapter);
                        orderArrayList.setLayoutManager(new LinearLayoutManager(ChefPage.this, LinearLayoutManager.HORIZONTAL, false));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }.execute("http://10.0.2.2:8080/antons-skafferi/api/TotalOrders/Json");

        }


}
