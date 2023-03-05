package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    //test
    Button button1;
    static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "jdbc:derby://10.0.2.2:1527/DB";
        String username = "APP";
        String password = "APP";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MENU_ITEMS");
            while (rs.next()) {
                String column1 = rs.getString("column1");
                int column2 = rs.getInt("column2");
                // do something with the results
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }

        button1 = findViewById(R.id.personalBtn);
        textView = findViewById(R.id.textView);
        //String url = "http://10.0.2.2:8080/antons-skafferi/api/Orders/json";
        //HttpUtils jsonTask = new HttpUtils();
        //jsonTask.execute(url);
        //HttpUtils httpUtils = new HttpUtils();
        //final String[] result = {""};

        button1.setOnClickListener(view -> {
            /*try {
                result[0] = httpUtils.execute(url).get();
                textView.setText(result[0]);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            Intent intent = new Intent(MainActivity.this, PersonalPage1.class);
            startActivity(intent);
        });
    }

    /*public static void setStatus(String status){
        textView.setText(status);
    }*/
}
