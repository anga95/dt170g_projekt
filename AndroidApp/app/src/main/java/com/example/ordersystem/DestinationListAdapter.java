package com.example.ordersystem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DestinationListAdapter extends BaseAdapter {
    private final List<String> items;
    private final Map<String, Integer> itemQuantities = new HashMap<>();
    Context context;
    int resource;


    public DestinationListAdapter(Context context, int resource, List<String> items, Set<String> selectedItems) {
        this.context = context;
        this.resource = resource;
        this.items = items;
    }

    public void setItemQuantity(String item, int quantity) {
        itemQuantities.put(item, quantity);
        notifyDataSetChanged();
    }

    public int getItemQuantity(String item) {
        return itemQuantities.getOrDefault(item, 0);
    }

    public void addSelectedItem(String selectedItem) {
        int quantity = getItemQuantity(selectedItem) + 1;
        itemQuantities.put(selectedItem, quantity);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Context getContext() {
        return context;
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String item = items.get(position);
        String selectedItem = items.get(position);
        int quantity = getItemQuantity(selectedItem);

        if(quantity < 1){
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            TextView textView = convertView.findViewById(android.R.id.text1);
            textView.setText("");
        } else{
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.totalorder_listview, parent, false);

            TextView itemName = convertView.findViewById(R.id.totalItemView);
            itemName.setText(item);

            TextView itemQuantity = convertView.findViewById(R.id.totalItemCount);
            selectedItem = items.get(position);
            quantity = getItemQuantity(selectedItem);
            itemQuantity.setText("x" + quantity);

            Button removeButton = convertView.findViewById(R.id.removeBtn);
            removeButton.setOnClickListener(view -> {
                int currentQuantity = getItemQuantity(item);
                if(currentQuantity > 0){
                    setItemQuantity(item, currentQuantity - 1);
                    notifyDataSetChanged();
                }
            });
            Button addNoteBtn = convertView.findViewById(R.id.addNoteBtn);
            addNoteBtn.setOnClickListener(view -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Enter note");
                final EditText input = new EditText(getContext());
                builder.setView(input);

                builder.setPositiveButton("OK", (dialog, which) -> {
                    String noteText = input.getText().toString();
                    // Save the note to the appropriate item in the data structure
                });

                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
            });

        }

        return convertView;

    }

}
