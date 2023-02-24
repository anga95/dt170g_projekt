package com.example.ordersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ChefPage extends AppCompatActivity {

    private RecyclerView orderlist;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customchefpageadapter);

        LinearLayout oneOrder = findViewById(R.id.mainRecylcler);
        OrderAdapter orderAdapter1 = new OrderAdapter(this, getOrderSample());
        //orderlist = findViewById(R.id.order_list);

        orderAdapter = new OrderAdapter(this, getOrderSample());
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