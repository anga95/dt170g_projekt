package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class PersonalPage1 extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_page1);

        button1 = findViewById(R.id.dagensLunchBtn);
        button1.setOnClickListener(view -> {

            //ComponentName componentName = new ComponentName("com.example.ordersystem", "com.example.ordersystem.ChefPage");
            // Create an intent with the component name
            //Intent intent = new Intent();
            //intent.setComponent(componentName);

            // Start the activity on the other AVD
            //startActivity(intent);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Create a socket to connect to the receiver AVD
                        Socket socket = new Socket("10.0.2.2", 5000); // Replace "1234" with the port number you want to use

                        // Get the OutputStream of the socket
                        OutputStream outputStream = socket.getOutputStream();

                        // Write the data you want to send to the OutputStream
                        String data = "Hello, receiver!";
                        outputStream.write(data.getBytes());

                        // Close the OutputStream and the socket
                        outputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            //startActivity(intent);
            /*Intent intent = new Intent(PersonalPage1.this, ChefPage.class);
            intent.putExtra("message", "Det här gick ju bra");
            startActivity(intent);*/

        });

        button1 = findViewById(R.id.aLaCarteBtn);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(PersonalPage1.this, TablesALaCarte.class);
            startActivity(intent);
        });
    }
}