package se.miun.dt170g.chefapp;

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

        private LinearLayout starterLayout;

        private LinearLayout maincourseLayout;

        private LinearLayout dessertLayout;

        private ImageView bell;


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
            dessertLayout = itemView.findViewById(R.id.dessertLayout);
            maincourseLayout = itemView.findViewById(R.id.maincourseLayout);
            starterLayout = itemView.findViewById(R.id.starterLayout);
            bell = itemView.findViewById(R.id.bell);


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


        holder.checkBoxstarter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(holder.checkBoxstarter.isChecked()){
                    backgroundDrawable.setColor(Color.GREEN);
                    backgroundDrawable4.setColor(Color.GREEN);

                }
                else{
                    backgroundDrawable.setColor(Color.parseColor("#80DADADA"));
                    backgroundDrawable4.setColor(Color.WHITE);

                }
            }
        });
        if (order.getStarter().size() > 0) {
            holder.starter_List.setVisibility(View.VISIBLE);
            ArrayList<String> starterArrayList = (ArrayList<String>) order.getStarter();
            holder.starter_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.starter_List.setAdapter(new CourseAdapter(starterArrayList, "Starter"));

        } else {
            holder.starter_List.setVisibility(View.GONE);
        }

    holder.checkBoxmaincourse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(holder.checkBoxmaincourse.isChecked()){
                    backgroundDrawable2.setColor(Color.GREEN);
                    backgroundDrawable5.setColor(Color.GREEN);

                }
                else{
                    backgroundDrawable2.setColor(Color.parseColor("#80DADADA"));
                    backgroundDrawable5.setColor(Color.WHITE);

                }
            }
        });

        if (order.getMainCourse().size() > 0) {
            holder.maincourse_List.setVisibility(View.VISIBLE);
            ArrayList<String> mainCourseArrayList = (ArrayList<String>) order.getMainCourse();
            holder.maincourse_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.maincourse_List.setAdapter(new CourseAdapter(mainCourseArrayList, "MainCourse"));

        } else {
            holder.maincourse_List.setVisibility(View.GONE);
        }

    holder.checkBoxdessert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(holder.checkBoxdessert.isChecked()){
                    backgroundDrawable3.setColor(Color.GREEN);
                    backgroundDrawable6.setColor(Color.GREEN);

                }
                else{
                    backgroundDrawable3.setColor(Color.parseColor("#80DADADA"));
                    backgroundDrawable6.setColor(Color.WHITE);

                }
            }
        });
        if (order.getDessert().size() > 0) {
            holder.dessert_List.setVisibility(View.VISIBLE);
            ArrayList<String> dessertArrayList = (ArrayList<String>) order.getDessert();
            holder.dessert_List.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
            holder.dessert_List.setAdapter(new CourseAdapter(dessertArrayList, "Dessert"));


        } else {
            holder.dessert_List.setVisibility(View.GONE);
        }

        holder.bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.checkBoxstarter.isChecked() && holder.checkBoxmaincourse.isChecked() && holder.checkBoxdessert.isChecked()){



                }

            }
        });

    }



    @Override
    public int getItemCount() {
        return orders.size();
    }


}

