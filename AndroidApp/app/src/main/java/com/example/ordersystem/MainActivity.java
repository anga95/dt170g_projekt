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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    //test
    Button button1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.personalBtn);
        String url = "http://10.0.2.2:8080/antons-skafferi/api/test";
        HttpUtils httpUtils = new HttpUtils();
        final String[] result = {""};

        button1.setOnClickListener(view -> {
           /* try {
                result[0] = httpUtils.execute(url).get();
                textView.setText(result[0]);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            Intent intent = new Intent(MainActivity.this, PersonalPage1.class);
            startActivity(intent);
        });
    }
}
