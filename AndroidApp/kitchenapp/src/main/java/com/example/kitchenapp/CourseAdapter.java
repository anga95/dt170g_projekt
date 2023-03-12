package com.example.kitchenapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<String> CourseList;
    private String courseType;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView course;

        public ViewHolder(View itemView) {
            super(itemView);
            course = itemView.findViewById(R.id.item_text_view);
        }
    }

    public CourseAdapter(ArrayList<String> CourseList, String courseType) {
        this.CourseList = CourseList;
        this.courseType = courseType;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        String starter = CourseList.get(position);
        holder.course.setText(starter);
    }

    public int getItemCount() {
        return CourseList.size();
    }
}

