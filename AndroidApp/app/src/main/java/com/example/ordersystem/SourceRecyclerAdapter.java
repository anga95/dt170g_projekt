package com.example.ordersystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.os.Build.VERSION_CODES.R;

public class SourceRecyclerAdapter extends RecyclerView.Adapter<SourceRecyclerAdapter.ViewHolder> {

    private final List<String> foods;
    //private final OnFoodClickListener listener;
    private DestinationRecyclerAdapter destinationRecyclerAdapter;

    public SourceRecyclerAdapter(List<String> foods, DestinationRecyclerAdapter destinationRecyclerAdapter){
        this.foods = foods;
        this.destinationRecyclerAdapter = destinationRecyclerAdapter;

    }

    public interface OnFoodClickListener{
        void onFoodClick(String food);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView foodNameTextView;
        public Button addButton;

        public ViewHolder(View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.item_name);
            addButton = itemView.findViewById(R.id.add_button);
        }
    }

    @NonNull
    @Override
    public SourceRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SourceRecyclerAdapter.ViewHolder holder, int position) {
        String food = foods.get(position);
        holder.foodNameTextView.setText(food);
        holder.addButton.setOnClickListener(view -> destinationRecyclerAdapter.addItem(food));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
}
