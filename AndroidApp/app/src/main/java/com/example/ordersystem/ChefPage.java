package com.example.ordersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayArrayList;
import java.util.ArrayList;

public class ChefPage extends AppCompatActivity {

    private RecyclerView orderArrayList;
    private ChefPageAdapter chefpageadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_page);

        orderArrayList = findViewById(R.id.order_ArrayList);

        chefpageadapter = new ChefPageAdapter(getOrderSample());
        orderArrayList.setAdapter(chefpageadapter);
        orderArrayList.setLayoutManager(new LinearLayoutManager(this));
        }

        private ArrayList<Order> getOrderSample() {
            ArrayList<Order> ordersamples = new ArrayArrayList<>();

            Order ordernr1 = new Order(1, new ArrayArrayList<String>(), new ArrayArrayList<String>(), new ArrayArrayList<String>(), false, false, false);
            ordernr1.setTableNr(1);
            ordernr1.getStarter().add("Tomatsoppa");
            ordernr1.getMainCourse().add("Köttbullar");
            ordernr1.getDessert().add("Bakelse");
            ordersamples.add(ordernr1);


            return ordersamples;
        }
}