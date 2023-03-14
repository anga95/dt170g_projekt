package com.example.ordersystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TablesLunch extends AppCompatActivity {

    private Button clickedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_lunch);

    }

    public void nextWindow(String value) {
        Intent intent = new Intent(TablesLunch.this, addLunch.class);
        intent.putExtra("message", value);
        startActivityForResult(intent, 1);
    }

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    public void helpB(View view) {
        if (clickedButton != null && clickedButton.getBackground() != null && clickedButton.getBackground().getConstantState() == getResources().getDrawable(R.color.teal_200).getConstantState()) {
            // if the button's background color has been changed, start a new activity
            Intent intent = new Intent(TablesLunch.this, OrdersForTable.class);
            startActivity(intent);
            clickedButton = null;
        } else {
            // if the button's background color hasn't been changed, continue as before
            clickedButton = (Button) view;
            switch (clickedButton.getId()) {
                case R.id.table1Btn:
                    nextWindow("Table 1");
                    break;
                case R.id.table2Btn:
                    nextWindow("Table 2");
                    break;
                case R.id.table3Btn:
                    nextWindow("Table 3");
                    break;
                case R.id.table4Btn:
                    nextWindow("Table 4");
                    break;
                case R.id.table5Btn:
                    nextWindow("Table 5");
                    break;
                case R.id.table6Btn:
                    nextWindow("Table 6");
                    break;
                case R.id.table7Btn:
                    nextWindow("Table 7");
                    break;
                case R.id.table8Btn:
                    nextWindow("Table 8");
                    break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            boolean isSentToKitchen = data.getBooleanExtra("isSentToKitchen", false);
            if (isSentToKitchen) {
                Button button = findViewById(clickedButton.getId()); // replace with the button you want to change the color of
                button.setBackgroundColor(getResources().getColor(R.color.teal_200)); // replace with the color you want to use
            }
        }
    }
}