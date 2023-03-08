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


public class ChefPage extends AppCompatActivity {

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



    public void myClickHandler(View view) {
        LinearLayout myLinearLayout = findViewById(R.id.starterLayout);
        LayerDrawable layerDrawable = (LayerDrawable) myLinearLayout.getBackground();
        GradientDrawable backgroundDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.bgcategory);

        LinearLayout myLinearLayout2 = findViewById(R.id.maincourseLayout);
        LayerDrawable layerDrawable2 = (LayerDrawable) myLinearLayout2.getBackground();
        GradientDrawable backgroundDrawable2 = (GradientDrawable) layerDrawable2.findDrawableByLayerId(R.id.bgcategory);

        LinearLayout myLinearLayout3 = findViewById(R.id.dessertLayout);
        LayerDrawable layerDrawable3 = (LayerDrawable) myLinearLayout3.getBackground();
        GradientDrawable backgroundDrawable3 = (GradientDrawable) layerDrawable3.findDrawableByLayerId(R.id.bgcategory);

        RecyclerView myRecyclerView = findViewById(R.id.starter_List);
        LayerDrawable layerDrawable4 = (LayerDrawable) myRecyclerView.getBackground();
        GradientDrawable backgroundDrawable4 = (GradientDrawable) layerDrawable4.findDrawableByLayerId(R.id.bgrecycler);

        RecyclerView myRecyclerView2 = findViewById(R.id.maincourse_List);
        LayerDrawable layerDrawable5 = (LayerDrawable) myRecyclerView2.getBackground();
        GradientDrawable backgroundDrawable5 = (GradientDrawable) layerDrawable5.findDrawableByLayerId(R.id.bgrecycler);

        RecyclerView myRecyclerView3 = findViewById(R.id.dessert_List);
        LayerDrawable layerDrawable6 = (LayerDrawable) myRecyclerView3.getBackground();
        GradientDrawable backgroundDrawable6 = (GradientDrawable) layerDrawable6.findDrawableByLayerId(R.id.bgrecycler);


        checkBoxstarter = findViewById(R.id.checkBoxstarter);
        checkBoxmaincourse = findViewById(R.id.checkBoxmaincourse);
        checkBoxdessert = findViewById(R.id.checkBoxdessert);
        dessertLayout = findViewById(R.id.dessertLayout);
        maincourseLayout = findViewById(R.id.maincourseLayout);
        starterLayout = findViewById(R.id.starterLayout);
        starter_List = findViewById(R.id.starter_List);
        maincourse_List = findViewById(R.id.maincourse_List);
        dessert_List = findViewById(R.id.dessert_List);

        if (checkBoxstarter.isChecked()) {
            backgroundDrawable.setColor(Color.GREEN);
            backgroundDrawable4.setColor(Color.GREEN);

        }

        if (checkBoxmaincourse.isChecked()) {
            backgroundDrawable2.setColor(Color.GREEN);
            backgroundDrawable5.setColor(Color.GREEN);

        }

        if (checkBoxdessert.isChecked()) {
            backgroundDrawable3.setColor(Color.GREEN);
            backgroundDrawable6.setColor(Color.GREEN);

        }

        if(checkBoxstarter.isChecked() && checkBoxmaincourse.isChecked() && checkBoxdessert.isChecked()){
        ordersamples.remove(0);
        chefpageadapter.notifyDataSetChanged();
        }
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chef_page);

            orderArrayList = findViewById(R.id.order_List);


            ordersamples = new ArrayList<>();

            Order ordernr1 = new Order(1, 1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr1.setPriority(1);
            ordernr1.setTableNr(1);
            ordernr1.setStarter(new ArrayList<String>(Arrays.asList("soppa", "bröd")));
            ordernr1.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar")));
            ordernr1.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr1);

            Order ordernr2 = new Order(2, 2, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr2.setPriority(2);
            ordernr2.setTableNr(2);
            ordernr2.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar", "pasta", "köttfärssås")));
            ordernr2.setStarter(new ArrayList<String>(Arrays.asList("kladdkaka", "glass", "cheesecake")));
            ordernr2.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka", "glass", "cheesecake")));
            ordersamples.add(ordernr2);

            Order ordernr3 = new Order(3, 3, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr3.setPriority(3);
            ordernr3.setTableNr(3);
            ordernr3.setStarter(new ArrayList<String>(Arrays.asList("soppa", "bröd")));
            ordernr3.setMainCourse(new ArrayList<String>(Arrays.asList("köttbullar", "köttfärssås")));
            ordernr3.setDessert(new ArrayList<String>(Arrays.asList("kladdkaka")));
            ordersamples.add(ordernr3);


            chefpageadapter = new ChefPageAdapter(ordersamples);
            orderArrayList.setAdapter(chefpageadapter);
            orderArrayList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        }
    }
