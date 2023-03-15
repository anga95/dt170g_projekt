package se.miun.dt170g.scheduleapp.utils;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpAsyncTask extends AsyncTask<String, Void, HttpAsyncTask.HttpResponse> {

    private final String TAG = HttpAsyncTask.class.getSimpleName();

    public interface HttpAsyncTaskListener {
        void onSuccess(HttpAsyncTask.HttpResponse response);
        void onError(HttpAsyncTask.HttpResponse response);
    }

    public static class HttpResponse {
        private int statusCode;
        private String statusMessage;
        private JSONObject responseData;

        public HttpResponse(int statusCode, String statusMessage, JSONObject responseData) {
            this.statusCode = statusCode;
            this.statusMessage = statusMessage;
            this.responseData = responseData;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getStatusMessage() {
            return statusMessage;
        }

        public JSONObject getResponseData() {
            return responseData;
        }
    }

    private HttpAsyncTaskListener listener;

    public HttpAsyncTask(HttpAsyncTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected HttpResponse doInBackground(String... params) {
        String urlString = params[0];
        String requestMethod = params[1];
        JSONObject requestData = null;
        if (params.length > 2) {
            try {
                requestData = new JSONObject(params[2]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();

            // Set request method
            urlConnection.setRequestMethod(requestMethod);

            // Set content type
            urlConnection.setRequestProperty("Content-Type", "application/json");

            // Set accept type
            urlConnection.setRequestProperty("Accept", "application/json");

            // Send request data (if applicable)
            if (requestData != null) {
                OutputStream outputStream = urlConnection.getOutputStream();
                outputStream.write(requestData.toString().getBytes("UTF-8"));
                outputStream.close();
            }

            // Get response code
            int statusCode = urlConnection.getResponseCode();
            String statusMessage = urlConnection.getResponseMessage();
            Log.d(TAG, "Status code: " + statusCode);
            Log.d(TAG, "Status message: " + statusMessage);

            // Read response data
            InputStream inputStream;
            if (statusCode >= 400) {
                inputStream = urlConnection.getErrorStream();
            } else {
                inputStream = urlConnection.getInputStream();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            inputStream.close();
            String responseData = responseBuilder.toString();
            Log.d(TAG, "Response data: " + responseData);

            // Parse response data as JSON object
            JSONObject jsonObject;
            if (responseData.trim().length() > 0) {
                jsonObject = new JSONObject(responseData);
            } else {
                jsonObject = null;
            }

            // Return HTTP response object
            return new HttpResponse(statusCode, statusMessage, jsonObject);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            if (urlConnection != null) {
                try {
                    int statusCode = urlConnection.getResponseCode();
                    String statusMessage = urlConnection.getResponseMessage();
                    Log.d(TAG, "Error status code: " + statusCode);
                    Log.d(TAG, "Error status message: " + statusMessage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    @Override
    protected void onPostExecute(HttpResponse response) {
        if (response != null && response.getStatusCode() < 400) {
            if (listener != null) {
                listener.onSuccess(response);
            }
        } else {
            if (listener != null) {
                listener.onError(response);
            }
        }
    }
}
