package com.example.ordersystem;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SourceRecyclerAdapter extends RecyclerView.Adapter<SourceRecyclerAdapter.ViewHolder> {

    //private final List<String> foods;
    //private final OnFoodClickListener listener;
    //private DestinationRecyclerAdapter destinationRecyclerAdapter;
    private final List<SourceItem> foodsList;
    //private final OrderItemAdapter orderItemAdapter;
    private SourceItemClickListener listener;
    public interface SourceItemClickListener{
        void onItemAdded(SourceItem sourceItem);
    }

    public SourceRecyclerAdapter(List<SourceItem> foodsList, SourceItemClickListener listener){
        this.foodsList = foodsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SourceItem sourceItem = foodsList.get(position);
        holder.foodNameTextView.setText(sourceItem.getName());
        holder.priceTextView.setText(String.format("%.2f", sourceItem.getPrice()));
    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }

    /*public void addItemToOrder(String name, int quantity, String note){
        OrderItem orderItem = new OrderItem(name, quantity, note);
        orderItemAdapter.addItem(orderItem);
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView foodNameTextView;
        TextView priceTextView;
        Button addButton;

        public ViewHolder(View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.item_name);
            priceTextView = itemView.findViewById(R.id.item_price);
            addButton = itemView.findViewById(R.id.add_button);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    SourceItem sourceItem = foodsList.get(position);
                    listener.onItemAdded(sourceItem);
                }
            });
        }
    }

    //@Override
    /*public void onBindViewHolder(SourceRecyclerAdapter.ViewHolder holder, int position) {

        String food = foods.get(position);
        holder.foodNameTextView.setText(food);
        holder.addButton.setOnClickListener(view ->
                addItemToOrder(food,1,"")

        );
    }*/

    /*@Override
    public int getItemCount() {
        return foods.size();
    }*/

}
