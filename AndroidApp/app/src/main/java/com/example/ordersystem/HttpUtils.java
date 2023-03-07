
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

public class HttpUtils extends AsyncTask<String,String,String> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String method;

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
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(urls[1]);
                writer.flush();
                writer.close();
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

    @Override
    protected void onPostExecute(String result) {
        // Parse JSON data and extract the items you need
        try {
            JSONArray jsonArray = new JSONArray(result); // assuming 'response' is the string containing the JSON array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String status = jsonObject.getString("category");
                int tableNr = jsonObject.getInt("price");
                // do something with the extracted values
                //MainActivity.setStatus(status);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
