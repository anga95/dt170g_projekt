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
                            false, new ArrayList<>() ,new ArrayList<>(),0, new ArrayList<>());
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
                                    order.getQuantity().add(quantity);
                                    order.getNotes().add(note);
                                    order.getItemIDs().add(orderId);
                                    break;
                                case "Starters":
                                    order.getStarter().add(name);
                                    order.getQuantity().add(quantity);
                                    break;
                                case "Dessert":
                                    order.getDessert().add(name);
                                    order.getQuantity().add(quantity);
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


            chefpageadapter = new ChefPageAdapter(getApplicationContext(), ordersamples);
            orderArrayList.setAdapter(chefpageadapter);
            orderArrayList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        }


}
