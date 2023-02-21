package com.example.ordersystem;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class addLunch extends AppCompatActivity {
    TextView placeholder;
    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView list;

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

        list = (ListView) findViewById(R.id.totalOrder);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        list.setAdapter(adapter);

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
        }
    }


}