package se.miun.dt170g.chefapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChefPage extends AppCompatActivity {

    private RecyclerView orderlist;
    /*private ChefPageAdapter chefpageadapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_page);

        orderlist = findViewById(R.id.order_list);


        List<Order> ordersamples = new ArrayList<>();

        Order ordernr1 = new Order(1, 1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
        ordernr1.setPriority(1);
        ordernr1.setTableNr(1);
        ordernr1.setStarter(Collections.singletonList("soppa"));
        ordernr1.setMainCourse(Collections.singletonList("köttbullar"));
        ordernr1.setDessert(Collections.singletonList("kladdkaka"));
        ordersamples.add(ordernr1);

        /*Order ordernr2 = new Order(2, 2, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
        ordernr2.setPriority(2);
        ordernr2.setTableNr(2);
        ordernr2.setStarter(Collections.singletonList("starter"));
        ordernr2.setMainCourse(Collections.singletonList("maincourse"));
        ordernr2.setDessert(Collections.singletonList("dessert"));
        ordersamples.add(ordernr2);*/


        /*chefpageadapter = new ChefPageAdapter(ordersamples);
        orderlist.setAdapter(chefpageadapter);
        orderlist.setLayoutManager(new LinearLayoutManager(this));*/
    }
}