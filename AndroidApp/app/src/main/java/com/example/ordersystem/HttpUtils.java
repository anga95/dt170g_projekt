package com.example.ordersystem;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils extends AsyncTask<String,String,String> {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected String doInBackground(String... urls) {
        String urlString = urls[0];
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            return response.toString();
        } catch (IOException e) {
            Log.e(TAG, "Error getting response from URL: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String response) {
        if (response != null) {
            Log.d(TAG, "Response: " + response);
        }
    }
}
