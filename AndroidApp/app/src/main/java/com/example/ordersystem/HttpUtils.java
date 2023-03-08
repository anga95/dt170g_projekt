
package com.example.ordersystem;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtils extends AsyncTask<String,String,String> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final String method;

    public HttpUtils(String method){
        this.method = method;
    }

    @Override
    protected String doInBackground(String... urls) {
        String urlString = urls[0];
        String jsonString = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);

            if(method.equals("POST")){
                Log.d(TAG, "HELLO");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                OutputStream os = connection.getOutputStream();
                os.write(urls[1].getBytes(StandardCharsets.UTF_8));
                os.close();
            }

            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString += line;
            }
            reader.close();
            inputStream.close();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
