package com.example.ordersystem;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.*;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //test
    Button button1;
    TextView textView;

    HttpUtils httpUtilsPost = new HttpUtils("POST");
    String postData = "price=10&name=Spaghetti&description=Delicious+spaghetti&time=30&category=Drinks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendPostRequest();

        //httpUtilsPost.execute("http://10.0.2.2:8080/antons-skafferi/api/MenuItems/Insert", postData);

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

    private void sendPostRequest() {
        // create an OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // build the request body using FormBody
        RequestBody requestBody = new FormBody.Builder()
                .add("price", "10")
                .add("name", "Pizza")
                .add("description", "Delicious pizza")
                .add("time", "30")
                .add("category", "Italian")
                .build();

        // create a new request with the endpoint and request body
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/antons-skafferi/api/MenuItems/Insert")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()){
                    throw new IOException("Unexpected code " + response);
                }

                String responseBody = response.body().string();
                Log.d("RESPONSE", responseBody);
            }
        });
    }
}
