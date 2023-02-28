package com.example.kitchenapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChefPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_page);

        RecyclerView orderlist = findViewById(R.id.order_list);

        ChefPageAdapter chefpageadapter = new ChefPageAdapter(getOrderSample());
        orderlist.setAdapter(chefpageadapter);
        orderlist.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<OrderItem> getOrderSample() {
        List<OrderItem> ordersamples = new ArrayList<>();

        OrderItem ordernr1 = new OrderItem(1,1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false, false, false);
        ordernr1.setTableNr(1);
        ordernr1.getStarter().add("Tomatsoppa");
        ordernr1.getMainCourse().add("Köttbullar");
        ordernr1.getDessert().add("Bakelse");
        ordersamples.add(ordernr1);


        return ordersamples;
    }
}