package se.miun.dt170g.chefapp;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


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

    private ArrayList<Order> orders;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chef_page);

            orderArrayList = findViewById(R.id.order_List);


            ordersamples = new ArrayList<>();

            Order ordernr1 = new Order( 1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false, "",0,0);
            ordernr1.setTableNr(1);
            ordernr1.setStarter(new ArrayList<String>(Arrays.asList("soppa", "bröd")));
            ordernr1.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar")));
            ordernr1.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr1);

            Order ordernr2 = new Order( 2, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false, "",0,0);
            ordernr2.setTableNr(2);
            ordernr2.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar")));
            ordernr2.setStarter(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordernr2.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr2);

            Order ordernr3 = new Order(3, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false, "",0,0);
            ordernr3.setTableNr(3);
            ordernr3.setStarter(new ArrayList<String>(Arrays.asList("soppa", "bröd")));
            ordernr3.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar", "köttfärssås")));
            ordernr3.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr3);


            chefpageadapter = new ChefPageAdapter(getApplicationContext(), ordersamples);
            orderArrayList.setAdapter(chefpageadapter);
            orderArrayList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        }


}
