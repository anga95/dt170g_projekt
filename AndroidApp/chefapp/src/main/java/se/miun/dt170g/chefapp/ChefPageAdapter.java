package se.miun.dt170g.chefapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.utils.widget.MotionLabel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class ChefPageAdapter extends RecyclerView.Adapter<ChefPageAdapter.ViewHolder> {

    private ArrayList<Order> orders;

    public ChefPageAdapter(ArrayList<Order> orders) {
        this.orders = orders;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView table;
        public RecyclerView starter_List;
        public CheckBox checkBoxstarter;

        public RecyclerView maincourse_List;
        public CheckBox checkBoxmaincourse;

        public RecyclerView dessert_List;
        public CheckBox checkBoxdessert;

        public TextView starter;

        public TextView maincourse;

        public TextView dessert;

        public ViewHolder(View itemView) {
            super(itemView);
            table = itemView.findViewById(R.id.table);
            starter_List = itemView.findViewById(R.id.starter_List);
            starter = itemView.findViewById(R.id.starter);
            checkBoxstarter = itemView.findViewById(R.id.checkBoxstarter);
            maincourse_List = itemView.findViewById(R.id.maincourse_List);
            maincourse = itemView.findViewById(R.id.maincourse);
            checkBoxmaincourse = itemView.findViewById(R.id.checkBoxmaincourse);
            dessert_List = itemView.findViewById(R.id.dessert_List);
            dessert = itemView.findViewById(R.id.dessert);
            checkBoxdessert = itemView.findViewById(R.id.checkBoxdessert);

        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Order order = orders.get(position);

        holder.table.setText("Table" + " " +order.getTableNr());
        holder.starter.setText("Förrätt");
        if (order.getStarter().size() > 0) {
            holder.starter_List.setVisibility(View.VISIBLE);
            ArrayList<String> starterArrayList = (ArrayList<String>) order.getStarter();
            holder.starter_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.starter_List.setAdapter(new CourseAdapter(starterArrayList, "Starter"));

        } else {
            holder.starter_List.setVisibility(View.GONE);
        }

        if (order.getMainCourse().size() > 0) {
            holder.maincourse_List.setVisibility(View.VISIBLE);
            ArrayList<String> mainCourseArrayList = (ArrayList<String>) order.getMainCourse();
            holder.maincourse_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.maincourse_List.setAdapter(new CourseAdapter(mainCourseArrayList, "MainCourse"));

        } else {
            holder.maincourse_List.setVisibility(View.GONE);
        }

        if (order.getDessert().size() > 0) {
            holder.dessert_List.setVisibility(View.VISIBLE);
            ArrayList<String> dessertArrayList = (ArrayList<String>) order.getDessert();
            holder.dessert_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.dessert_List.setAdapter(new CourseAdapter(dessertArrayList, "Dessert"));


        } else {
            holder.dessert_List.setVisibility(View.GONE);
        }

    }


    @Override
    public int getItemCount() {
        return orders.size();
    }


}

