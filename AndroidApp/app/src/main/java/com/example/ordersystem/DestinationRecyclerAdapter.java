package com.example.ordersystem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public class DestinationRecyclerAdapter extends RecyclerView.Adapter<DestinationRecyclerAdapter.ViewHolder> {
    //private final List<String> selectedFoods;
    private final HashMap<String, Integer> mSelectedFoods;

    public DestinationRecyclerAdapter(HashMap<String, Integer> mSelectedFoods) {
        this.mSelectedFoods = mSelectedFoods;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView foodNameTextView;
        public Button removeBtn;
        public TextView quantity;
        public Button addNote;

        public ViewHolder(View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.totalItemView);
            removeBtn = itemView.findViewById(R.id.removeBtn);
            quantity = itemView.findViewById(R.id.totalItemCount);
            addNote = itemView.findViewById(R.id.addNoteBtn);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.totalorder_listview, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String item = (String) mSelectedFoods.keySet().toArray()[position];
        final int[] quantity = {mSelectedFoods.get(item)};
        holder.foodNameTextView.setText(item + " x" + quantity[0]);
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity[0] > 1){
                    quantity[0] = (quantity[0] - 1);
                    holder.foodNameTextView.setText(item + " x" + quantity[0]);

                } else {
                    mSelectedFoods.remove(item);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, mSelectedFoods.size());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSelectedFoods.size();
    }

    public void addItem(String item) {
        if (mSelectedFoods.containsKey(item)) {
            int quantity = mSelectedFoods.get(item);
            mSelectedFoods.put(item, quantity + 1);
        } else {
            mSelectedFoods.put(item, 1);
        }
        notifyDataSetChanged();
    }
}
