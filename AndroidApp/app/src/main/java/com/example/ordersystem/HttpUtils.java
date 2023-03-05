package com.example.ordersystem;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils extends AsyncTask<String,String,String> {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected String doInBackground(String... urls) {

        String jsonString = "";
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
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

    @Override
    protected void onPostExecute(String result) {
        // Parse JSON data and extract the items you need
        try {
            JSONArray jsonArray = new JSONArray(result); // assuming 'response' is the string containing the JSON array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String status = jsonObject.getString("status");
                int tableNr = jsonObject.getInt("tableNr");
                // do something with the extracted values
                //MainActivity.setStatus(status);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
