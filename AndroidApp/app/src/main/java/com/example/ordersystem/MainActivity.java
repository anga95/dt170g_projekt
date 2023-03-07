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

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
    //test
    Button button1;
    TextView textView;

    HttpUtils httpUtilsPost = new HttpUtils("POST");
    String postData = "id=200&category=Drinks&price=3222";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpUtilsPost.execute("http://10.0.2.2:8080/antons-skafferi/api/MenuItems/Insert", postData);

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
}
