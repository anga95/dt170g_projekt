package se.miun.dt170g.scheduleapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import se.miun.dt170g.scheduleapp.R;
import se.miun.dt170g.scheduleapp.model.EmpExtras;
import se.miun.dt170g.scheduleapp.model.EmpLeaves;
import se.miun.dt170g.scheduleapp.model.EmpSchedule;
import se.miun.dt170g.scheduleapp.model.Shift;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private static final int DAYS_IN_MONTH = 31; //change this from constant to variable and set it to the number of days in the month
    private Context mContext;
    private List<EmpSchedule> mEmpSchedules;
    private List<EmpLeaves> mEmpLeaves;
    private List<EmpExtras> mEmpExtras;

    public CalendarAdapter(Context context, List<EmpSchedule> empSchedules, List<EmpLeaves> empLeaves, List<EmpExtras> empExtras) {
        mContext = context;
        mEmpSchedules = empSchedules;
        mEmpLeaves = empLeaves;
        mEmpExtras = empExtras;
    }

    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.employee_schedule_item, parent, false);
        return new CalendarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the EmpSchedule object at the specified position
        EmpSchedule schedule = mEmpSchedules.get(position);

        // Set the employee name in the first column of the row
        holder.mEmployeeNameTextView.setText(schedule.getName());

        // Loop through each day of the month, and set the corresponding shift
        for (int i = 0; i < DAYS_IN_MONTH; i++) {
            // Get the TextView for the corresponding day of the month
            TextView dayTextView = holder.mDayTextViews.get(i);

            // Get the Shift object for the corresponding day, if it exists
            Shift shift = schedule.getShifts().get(i);
            if (shift != null) {
                // Set the shift name in the TextView
                dayTextView.setText(String.format("%s %s-%s", shift.getDay(), shift.getStartTime(), shift.getEndTime()));
            } else {
                // If no shift exists for the day, set the TextView to empty
                dayTextView.setText("");
            }
        }

        // Set the employee's leaves in the last column of the row
        holder.mLeavesTextView.setText("no leaves");

        // Set the employee's extras in the second to last column of the row
        holder.mExtrasTextView.setText("no extras");
    }

    @Override
    public int getItemCount() {
        if (mEmpSchedules == null) {
            return 0;
        }
        return mEmpSchedules.size();
    }

    public void setEmpSchedules(List<EmpSchedule> empSchedules) {
        mEmpSchedules = empSchedules;
        notifyDataSetChanged();
    }

    public void setEmpExtras(List<EmpExtras> empExtras) {
        mEmpExtras = empExtras;
        notifyDataSetChanged();
    }

    public void setEmpLeaves(List<EmpLeaves> empLeaves) {
        mEmpLeaves = empLeaves;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Views for each row in the RecyclerView
        TextView mEmployeeNameTextView;
        List<TextView> mDayTextViews;
        TextView mExtrasTextView;
        TextView mLeavesTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views in the row
//            mEmployeeNameTextView = itemView.findViewById(R.id.textview_employee_name);
//            mExtrasTextView = itemView.findViewById(R.id.textview_employee_extras);
//            mLeavesTextView = itemView.findViewById(R.id.textview_employee_leaves);

            // Initialize list of TextViews for days in the month
            mDayTextViews = new ArrayList<>();
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_1));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_2));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_3));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_4));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_5));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_6));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_7));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_8));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_9));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_10));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_11));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_12));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_13));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_14));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_15));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_16));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_17));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_18));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_19));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_20));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_21));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_22));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_23));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_24));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_25));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_26));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_27));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_28));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_29));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_30));
            mDayTextViews.add(itemView.findViewById(R.id.textview_day_31));
        }
    }
}
