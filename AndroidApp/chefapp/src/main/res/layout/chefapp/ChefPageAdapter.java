package se.miun.dt170g.chefapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChefPageAdapter extends RecyclerView.Adapter<ChefPageAdapter.ViewHolder> {

    private List<Order> orders;

    public ChefPageAdapter(List<Order> orders) {
        this.orders = orders;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public TextView textView8;
        public CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView8 = itemView.findViewById(R.id.textView8);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.textView.setText("Table" + order.getTableNr());
        holder.textView2.setText(order.getPriority());
        holder.textView8.setText(order.getCourse());
        holder.checkBox.setChecked(order.OrderReady());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
