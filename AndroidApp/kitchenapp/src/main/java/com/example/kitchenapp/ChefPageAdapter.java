package com.example.kitchenapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.utils.widget.MotionLabel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class ChefPageAdapter extends RecyclerView.Adapter<ChefPageAdapter.ViewHolder> {

    private ArrayList<Order> orders;
    private Context mContext;

    private ArrayList<Order> ordersamples;

    public ChefPageAdapter(Context context, ArrayList<Order> orders) {
        this.orders = orders;
        this.mContext = context;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView table;
        private final RecyclerView starter_List;
        private final CheckBox checkBoxstarter;

        private final RecyclerView maincourse_List;
        private final CheckBox checkBoxmaincourse;

        private final RecyclerView dessert_List;
        private final CheckBox checkBoxdessert;

        private final TextView starter;

        private final ImageView bell;


        public ViewHolder(View itemView) {
            super(itemView);
            table = itemView.findViewById(R.id.table);
            starter_List = itemView.findViewById(R.id.starter_List);
            starter = itemView.findViewById(R.id.starter);
            checkBoxstarter = itemView.findViewById(R.id.checkBoxstarter);
            maincourse_List = itemView.findViewById(R.id.maincourse_List);
            TextView maincourse = itemView.findViewById(R.id.maincourse);
            checkBoxmaincourse = itemView.findViewById(R.id.checkBoxmaincourse);
            dessert_List = itemView.findViewById(R.id.dessert_List);
            TextView dessert = itemView.findViewById(R.id.dessert);
            checkBoxdessert = itemView.findViewById(R.id.checkBoxdessert);
            LinearLayout dessertLayout = itemView.findViewById(R.id.dessertLayout);
            LinearLayout maincourseLayout = itemView.findViewById(R.id.maincourseLayout);
            LinearLayout starterLayout = itemView.findViewById(R.id.starterLayout);
            bell = itemView.findViewById(R.id.bell);
            TextView quantity = itemView.findViewById(R.id.itemQuantity);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);


        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        LinearLayout myLinearLayout = holder.itemView.findViewById(R.id.starterLayout);
        LayerDrawable layerDrawable = (LayerDrawable) myLinearLayout.getBackground();
        GradientDrawable backgroundDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.bgcategory);

        LinearLayout myLinearLayout2 = holder.itemView.findViewById(R.id.maincourseLayout);
        LayerDrawable layerDrawable2 = (LayerDrawable) myLinearLayout2.getBackground();
        GradientDrawable backgroundDrawable2 = (GradientDrawable) layerDrawable2.findDrawableByLayerId(R.id.bgcategory);

        LinearLayout myLinearLayout3 = holder.itemView.findViewById(R.id.dessertLayout);
        LayerDrawable layerDrawable3 = (LayerDrawable) myLinearLayout3.getBackground();
        GradientDrawable backgroundDrawable3 = (GradientDrawable) layerDrawable3.findDrawableByLayerId(R.id.bgcategory);

        RecyclerView myRecyclerView = holder.itemView.findViewById(R.id.starter_List);
        LayerDrawable layerDrawable4 = (LayerDrawable) myRecyclerView.getBackground();
        GradientDrawable backgroundDrawable4 = (GradientDrawable) layerDrawable4.findDrawableByLayerId(R.id.bgrecycler);

        RecyclerView myRecyclerView2 = holder.itemView.findViewById(R.id.maincourse_List);
        LayerDrawable layerDrawable5 = (LayerDrawable) myRecyclerView2.getBackground();
        GradientDrawable backgroundDrawable5 = (GradientDrawable) layerDrawable5.findDrawableByLayerId(R.id.bgrecycler);

        RecyclerView myRecyclerView3 = holder.itemView.findViewById(R.id.dessert_List);
        LayerDrawable layerDrawable6 = (LayerDrawable) myRecyclerView3.getBackground();
        GradientDrawable backgroundDrawable6 = (GradientDrawable) layerDrawable6.findDrawableByLayerId(R.id.bgrecycler);

        Order order = orders.get(position);


        holder.table.setText("Table" + " " +order.getTableNr());
        holder.starter.setText("Förrätt");


        if (order.getStarter().size() > 0) {
            holder.starter_List.setVisibility(View.VISIBLE);
            ArrayList<String> starterArrayList = order.getStarter();
            ArrayList<String> quantityArrayList = order.getQuantity();
            holder.starter_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.starter_List.setAdapter(new CourseAdapter(starterArrayList, "Starter", quantityArrayList));

        } else {
            holder.starter_List.setVisibility(View.GONE);
        }


        if (order.getMainCourse().size() > 0) {
            holder.maincourse_List.setVisibility(View.VISIBLE);
            ArrayList<String> mainCourseArrayList = order.getMainCourse();
            ArrayList<String> quantityArrayList = order.getQuantity();
            holder.maincourse_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.maincourse_List.setAdapter(new CourseAdapter(mainCourseArrayList, "MainCourse", quantityArrayList));

        } else {
            holder.maincourse_List.setVisibility(View.GONE);
        }

        if (order.getDessert().size() > 0) {
            holder.dessert_List.setVisibility(View.VISIBLE);
            ArrayList<String> dessertArrayList = order.getDessert();
            ArrayList<String> quantityArrayList = order.getQuantity();
            holder.dessert_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.dessert_List.setAdapter(new CourseAdapter(dessertArrayList, "Dessert", quantityArrayList));


        } else {
            holder.dessert_List.setVisibility(View.GONE);
        }

        holder.bell.setOnClickListener(v -> {
            if(holder.checkBoxstarter.isChecked()){
                backgroundDrawable.setColor(Color.GREEN);
                backgroundDrawable4.setColor(Color.GREEN);

            }
            if(holder.checkBoxmaincourse.isChecked()){
                backgroundDrawable2.setColor(Color.GREEN);
                backgroundDrawable5.setColor(Color.GREEN);

            }
            if(holder.checkBoxdessert.isChecked()){
                backgroundDrawable3.setColor(Color.GREEN);
                backgroundDrawable6.setColor(Color.GREEN);

            }

            if(holder.checkBoxstarter.isChecked() && holder.checkBoxmaincourse.isChecked() && holder.checkBoxdessert.isChecked()){
                int position1 = orders.indexOf(order);
                orders.remove(position1);
                notifyItemRemoved(position1);

            }

        });

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }


}

