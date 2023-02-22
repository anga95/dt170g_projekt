package com.example.ordersystem;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class addLunch extends AppCompatActivity {
    TextView placeholder;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lunch);

        placeholder = (TextView)findViewById(R.id.tableNum);
        placeholder.setText(getIntent().getStringExtra("message"));

        placeholder = (TextView)findViewById(R.id.lunchOne);
        placeholder.setText("Hamburgare");
        placeholder = (TextView)findViewById(R.id.lunchTwo);
        placeholder.setText("Fisk med pinnar");
        placeholder = (TextView)findViewById(R.id.lunchThree);
        placeholder.setText("Lasagne med ädelostsås och ruccola");

        placeholder = (TextView)findViewById(R.id.drinkOne);
        placeholder.setText("Vatten");
        placeholder = (TextView)findViewById(R.id.drinkTwo);
        placeholder.setText("Coca-Cola");
        placeholder = (TextView)findViewById(R.id.drinkThree);
        placeholder.setText("Fanta");

        ListView listView = findViewById(R.id.totalOrder);
        //ArrayList<String> items = new ArrayList<>();
        //items.add("Item 1");
        //CustomListAdapter adapter = new CustomListAdapter(this,items);
        //listView.setAdapter(adapter);

        ArrayList<String> list = new ArrayList<String>(Arrays.asList("111,222,333,444".split(",")));
        listView.setAdapter(new CustomListAdapter(list,context));

        //list = (ListView) findViewById(R.id.totalOrder);
        //list.setAdapter(new CustomListAdapter(list, context));
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        //list.setAdapter(adapter);


    }

    public void updateTotal(int resource){
        placeholder = findViewById(resource);
        String value = (String) placeholder.getText();
        listItems.add(value + "      x" + 0);
        adapter.notifyDataSetChanged();
    }

    public void pressedButton(View view){
        Button clickedButton = (Button) view;
        TextView item;
        switch (clickedButton.getId()){
            case R.id.addLunchOneBtn:
                updateTotal(R.id.lunchOne);
                break;
            case R.id.addLunchTwoBtn:
                updateTotal(R.id.lunchTwo);
                break;
            case R.id.addOrderBtn:
                addToCart();
        }
    }

    private void addToCart(){

    }

}