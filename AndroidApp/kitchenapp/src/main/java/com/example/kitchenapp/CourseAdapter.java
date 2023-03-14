package com.example.kitchenapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private final ArrayList<String> CourseList;
    private final ArrayList<String> QuantityList;
    private final ArrayList<String> noteList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView course;
        public TextView quantity;
        public TextView note;

        public ViewHolder(View itemView) {
            super(itemView);
            course = itemView.findViewById(R.id.item_text_view);
            quantity = itemView.findViewById(R.id.itemQuantity);
            note = itemView.findViewById(R.id.itemNoteView);
        }
    }

    public CourseAdapter(ArrayList<String> courseList, ArrayList<String> quantityList,
                         ArrayList<String> noteList) {
        this.CourseList = courseList;
        this.QuantityList = quantityList;
        this.noteList = noteList;
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

        //String note = noteList.get(position);
        String note = noteList.toString();
        if (note != null && !note.isEmpty()) {
            note = note.replaceAll("\\[|\\]", "");
            // Check if note is empty after removing brackets
            if (!note.isEmpty()) {
                holder.note.setVisibility(View.VISIBLE);
                holder.note.setText(note);
            } else {
                holder.note.setVisibility(View.GONE);
            }
        } else {
            holder.note.setVisibility(View.GONE);
        }
    }

    public int getItemCount() {
        return CourseList.size();
    }
}



