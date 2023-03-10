package com.example.ordersystem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
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

import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private final List<OrderItem> orderItemList;
    private final OrderItemClickListener listener;
    private final Context context;

    public OrderItemAdapter(List<OrderItem> orderItemList, Context context, OrderItemClickListener listener) {
        this.orderItemList = orderItemList;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.totalorder_listview, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem orderItem = orderItemList.get(position);
        holder.nameTextView.setText(orderItem.getName());
        holder.quantityTextView.setText(String.valueOf(orderItem.getQuantity()));
        holder.priceTextView.setText(String.format("$%.2f", orderItem.getPrice()));

        holder.removeButton.setOnClickListener(view -> {
            //OrderItem orderItem1 = orderItemList.get(getAdapterPosition());
            int newQuantity = orderItem.getQuantity() - 1;
            if (newQuantity > 0) {
                newQuantity = orderItem.getQuantity() - 1;
            }
            if (newQuantity < 1){
                orderItemList.remove(orderItem);
                notifyItemRemoved(position);
            }
            orderItem.setQuantity(newQuantity);
            holder.quantityTextView.setText(String.valueOf(newQuantity));
            listener.onItemQuantityChanged(orderItem, newQuantity);
        });

        holder.addNoteBtn.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Add Note");

            // Set up the input
            final EditText input = new EditText(context);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", (dialog, which) -> {
                String note = input.getText().toString();
                orderItem.setNote(note);
            });
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();
        });
    }

    @Override
    public int getItemCount() {
        return orderItemList.size();
    }

    public void addItem(SourceItem sourceItem) {
        // Check if the item already exists in the order
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getName().equals(sourceItem.getName())) {
                // Item already exists, increase quantity
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                notifyItemChanged(orderItemList.indexOf(orderItem));
                return;
            }
        }
        // Item does not exist, add to order
        OrderItem orderItem = new OrderItem(sourceItem.getName(), 1, sourceItem.getPrice(), "", sourceItem.getCategory(), sourceItem.getIdNum(), sourceItem.getTime());
        orderItemList.add(orderItem);
        notifyItemInserted(orderItemList.size() - 1);
    }

    public interface OrderItemClickListener {
        void onItemQuantityChanged(OrderItem orderItem, int newQuantity);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView quantityTextView;
        private final TextView priceTextView;
        private final Button removeButton, addNoteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.totalItemView);
            TextView addedNoteView = itemView.findViewById(R.id.addedNote);
            quantityTextView = itemView.findViewById(R.id.totalItemCount);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            removeButton = itemView.findViewById(R.id.removeBtn);
            addNoteBtn = itemView.findViewById(R.id.addNoteBtn);

        }
    }

    public List<OrderItem> getOrderItemList(){
        return orderItemList;
    }
}
