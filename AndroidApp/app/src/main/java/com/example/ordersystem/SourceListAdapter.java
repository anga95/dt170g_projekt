package com.example.ordersystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SourceListAdapter extends BaseAdapter {

    private final List<String> items;
    private final Set<String> selectedItems = new HashSet<>();
    private final DestinationListAdapter destinationListAdapter;
    Context context;
    int resource;

    public SourceListAdapter(Context context, int resource, List<String> items, DestinationListAdapter destinationListAdapter){
        this.context = context;
        this.resource = resource;
        this.items = items;
        this.destinationListAdapter = destinationListAdapter;
    }

    public List<String> getItems() {
        return items;
    }

    public DestinationListAdapter getDestinationListAdapter() {
        return destinationListAdapter;
    }

    public Context getContext() {
        return context;
    }

    public int getResource() {
        return resource;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview, parent, false);
        }

        TextView itemName = convertView.findViewById(R.id.item_name);
        Button addButton = convertView.findViewById(R.id.add_button);

        final String item = items.get(position);
        itemName.setText(item);

        if (selectedItems.contains(item)) {
            addButton.setEnabled(false);
            addButton.setText("+");
        } else {
            addButton.setEnabled(true);
            addButton.setText("+");
            addButton.setOnClickListener(v -> {
                selectedItems.add(item);
                destinationListAdapter.addSelectedItem(item);
            });
        }

        return convertView;
    }
}
