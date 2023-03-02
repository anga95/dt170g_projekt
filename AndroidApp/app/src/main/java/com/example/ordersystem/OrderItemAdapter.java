package com.example.ordersystem;

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

import org.w3c.dom.Text;

import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private List<OrderItem> orderItemList;
    private OrderItemClickListener listener;

    public OrderItemAdapter(List<OrderItem> orderItemList, OrderItemClickListener listener) {
        this.orderItemList = orderItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.totalorder_listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem orderItem = orderItemList.get(position);
        holder.nameTextView.setText(orderItem.getName());
        holder.quantityTextView.setText(String.valueOf(orderItem.getQuantity()));
        holder.priceTextView.setText(String.format("$%.2f", orderItem.getPrice()));
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
        OrderItem orderItem = new OrderItem(sourceItem.getName(), 1, sourceItem.getPrice(), "");
        orderItemList.add(orderItem);
        notifyItemInserted(orderItemList.size() - 1);
    }

    public interface OrderItemClickListener {
        void onItemQuantityChanged(OrderItem orderItem, int newQuantity);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView, quantityTextView, priceTextView;
        private Button removeButton, addNoteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.totalItemView);
            quantityTextView = itemView.findViewById(R.id.totalItemCount);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            removeButton = itemView.findViewById(R.id.removeBtn);
            addNoteBtn = itemView.findViewById(R.id.addNoteBtn);

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OrderItem orderItem = orderItemList.get(getAdapterPosition());
                    int newQuantity = orderItem.getQuantity() - 1;
                    if (newQuantity > 0) {
                        newQuantity = 0;
                    }
                    orderItem.setQuantity(newQuantity);
                    quantityTextView.setText(String.valueOf(newQuantity));
                    listener.onItemQuantityChanged(orderItem, newQuantity);
                }
            });
        }
    }
}
