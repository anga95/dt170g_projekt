package com.example.kitchenapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    private ArrayList<Order> ordersamples;

        @SuppressLint("StaticFieldLeak")
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chef_page);

            orderArrayList = findViewById(R.id.order_List);


            ordersamples = new ArrayList<>();
            new HttpUtils("GET") {
                @Override
                protected void onPostExecute(String result) {
                    // Parse JSON data and extract the items you need
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        Map<Integer, Order> ordersByTableNr = new HashMap<>();

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            int quantity = jsonObject.getInt("quantity");
                            int tableNr = jsonObject.getInt("tableNr");
                            String name = jsonObject.getString("name");
                            String category = jsonObject.getString("category");

                            Order order = ordersByTableNr.get(tableNr);
                            if (order == null) {
                                order = new Order(i+1, tableNr, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
                                ordersByTableNr.put(tableNr, order);
                            }

                            switch(category) {
                                case "Lunch":
                                case "MainCourse":
                                    order.getMainCourse().add(name);
                                    break;
                                case "Starters":
                                    order.getStarter().add(name);
                                    break;
                                case "Dessert":
                                    order.getDessert().add(name);
                                    break;
                                default:
                                    break;
                            }
                        }

                        List<Order> ordersamples = new ArrayList<>(ordersByTableNr.values());
                        chefpageadapter = new ChefPageAdapter(getApplicationContext(), (ArrayList<Order>) ordersamples);
                        orderArrayList.setAdapter(chefpageadapter);
                        orderArrayList.setLayoutManager(new LinearLayoutManager(ChefPage.this, LinearLayoutManager.HORIZONTAL, false));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }.execute("http://10.0.2.2:8080/antons-skafferi/api/TotalOrders/Json");

           /* Order ordernr1 = new Order(1, 1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr1.setPriority(1);
            ordernr1.setTableNr(1);
            ordernr1.setStarter(new ArrayList<String>(Arrays.asList("soppa", "bröd")));
            ordernr1.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar")));
            ordernr1.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr1);

            Order ordernr2 = new Order(2, 2, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr2.setPriority(2);
            ordernr2.setTableNr(2);
            ordernr2.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar")));
            ordernr2.setStarter(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordernr2.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr2);

            Order ordernr3 = new Order(3, 3, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr3.setPriority(3);
            ordernr3.setTableNr(3);
            ordernr3.setStarter(new ArrayList<String>(Arrays.asList("soppa", "bröd")));
            ordernr3.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar", "köttfärssås")));
            ordernr3.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr3);*/


            chefpageadapter = new ChefPageAdapter(getApplicationContext(),ordersamples);
            orderArrayList.setAdapter(chefpageadapter);
            orderArrayList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        }


}
