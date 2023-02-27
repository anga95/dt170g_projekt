package com.example.ordersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChefPage extends AppCompatActivity {

    private RecyclerView orderlist;
    private OrderAdapter orderAdapter;
    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customchefpageadapter);

        placeholder = findViewById(R.id.textView5);
        //placeholder.setText(getIntent().getStringExtra("message"));

        LinearLayout oneOrder = findViewById(R.id.mainRecylcler);
        OrderAdapter orderAdapter1 = new OrderAdapter(this, getOrderSample());
        //orderlist = findViewById(R.id.order_list);

        orderAdapter = new OrderAdapter(this, getOrderSample());

        // Start a new thread to listen for data from the sender AVD
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Create a server socket to listen for connections from the sender AVD
                    ServerSocket serverSocket = new ServerSocket(5000); // Replace "1234" with the port number you want to use

                    // Accept a connection from the sender AVD
                    Socket socket = serverSocket.accept();

                    // Get the InputStream of the socket
                    InputStream inputStream = socket.getInputStream();

                    // Read the data from the InputStream
                    byte[] buffer = new byte[1024];
                    int length = inputStream.read(buffer);
                    final String data = new String(buffer, 0, length);

                    // Update the UI with the received data
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            placeholder.setText(data);
                        }
                    });

                    // Close the InputStream, the socket, and the server socket
                    inputStream.close();
                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        }

        private List<Order> getOrderSample() {
            List<Order> ordersamples = new ArrayList<>();

            Order ordernr1 = new Order(1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), false, false, false);
            ordernr1.setTableNr(1);
            ordernr1.getStarter().add("Tomatsoppa");
            ordernr1.getMainCourse().add("Köttbullar");
            ordernr1.getDessert().add("Bakelse");
            ordersamples.add(ordernr1);



            return ordersamples;
        }





    private class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

        private final Context context;
        private final List<Order> orders;

        public OrderAdapter(Context context, List<Order> orders) {
            this.context = context;
            this.orders = orders;
        }

        public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
            View view1 = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
            return new OrderViewHolder(view1);
        }

        @Override
        public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return orders.size();
        }

        public class OrderViewHolder extends RecyclerView.ViewHolder{


            public OrderViewHolder(View viewItem){
                super(viewItem);
            }
        }
    }
}