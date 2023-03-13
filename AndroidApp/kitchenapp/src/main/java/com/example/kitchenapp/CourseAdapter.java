package com.example.kitchenapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<String> CourseList;
    private String courseType;

    private ArrayList<String> QuantityList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView course;
        public TextView quantity;

        public ViewHolder(View itemView) {
            super(itemView);
            course = itemView.findViewById(R.id.item_text_view);
            quantity = itemView.findViewById(R.id.itemQuantity);
        }
    }

    public CourseAdapter(ArrayList<String> courseList, String courseType, ArrayList<String> quantityList) {
        this.CourseList = courseList;
        this.courseType = courseType;
        this.QuantityList = quantityList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(ViewHolder holder, int position) {
        String starter = CourseList.get(position);
        holder.course.setText(starter);

        String quantity = QuantityList.get(position);
        holder.quantity.setText("x" + quantity);
    }

    public int getItemCount() {
        return CourseList.size();
    }
}



