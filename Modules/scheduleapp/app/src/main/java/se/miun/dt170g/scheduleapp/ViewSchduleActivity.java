package se.miun.dt170g.scheduleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ViewSchduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schdule);

        // custom image for action bar start
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflator = LayoutInflater.from(this);
        View view = inflator.inflate(R.layout.custom_title, null);
        actionBar.setCustomView(view);


        // no API yet strings
        String empRollingWeeks = "" +
                "{ \"employees\": [ " +
                "{ \"id\": 1, \"name\": \"Nordin Suleimani\", \"schedule\": [ " +
                "{ \"day\": \"Monday\", \"startTime\": \"08:01\", \"endTime\": \"16:00\" }, { \"day\": \"Tuesday\", \"startTime\": \"08:02\", \"endTime\": \"16:00\" }, { \"day\": \"Wednesday\", \"startTime\": \"OFF\", \"endTime\": \"OFF\" }, { \"day\": \"Thursday\", \"startTime\": \"08:04\", \"endTime\": \"16:00\" }, { \"day\": \"Friday\", \"startTime\": \"08:05\", \"endTime\": \"16:00\" }, { \"day\": \"Saturday\", \"startTime\": \"08:06\", \"endTime\": \"16:00\" } , { \"day\": \"Sunday\", \"startTime\": \"OFF\", \"endTime\": \"OFF\" } ] }, " +
                "{ \"id\": 2, \"name\": \"Jane Smith\", \"schedule\": " +
                "[ { \"day\": \"Monday\", \"startTime\": \"10:01\", \"endTime\": \"18:00\" }, { \"day\": \"Tuesday\", \"startTime\": \"10:02\", \"endTime\": \"18:00\" }, { \"day\": \"Wednesday\", \"startTime\": \"08:33\", \"endTime\": \"18:00\" }, { \"day\": \"Thursday\", \"startTime\": \"OFF\", \"endTime\": \"OFF\" }, { \"day\": \"Friday\", \"startTime\": \"10:05\", \"endTime\": \"18:00\" }, { \"day\": \"Saturday\", \"startTime\": \"OFF\", \"endTime\": \"OFF\" }  , { \"day\": \"Sunday\", \"startTime\": \"OFF\", \"endTime\": \"OFF\" } ]  }" +
                "] }";
        String empLeaves = "{ \"employees\": [ { \"id\": 1, \"name\": \"Nordin Suleimani\", \"leaves\": [ { \"date\": \"2023-03-07\", \"startTime\": \"08:00\", \"endTime\": \"16:00\" }, { \"date\": \"2023-03-14\", \"startTime\": \"12:00\", \"endTime\": \"20:00\" }, { \"date\": \"2023-03-21\", \"startTime\": \"08:00\", \"endTime\": \"20:00\" } ] }, { \"id\": 2, \"name\": \"Jane Smith\", \"leaves\": [ { \"date\": \"2023-03-14\", \"startTime\": \"08:00\", \"endTime\": \"16:00\" }, { \"date\": \"2023-03-19\", \"startTime\": \"08:00\", \"endTime\": \"18:00\" } ] } ] }";
        String empExtraDays = "{ \"employees\": [ { \"id\": 1, \"name\": \"Nordin Suleimani\", \"extra\": [ { \"date\": \"2023-03-08\", \"startTime\": \"10:00\", \"endTime\": \"18:00\" }, { \"date\": \"2023-03-16\", \"startTime\": \"10:00\", \"endTime\": \"18:00\" }, { \"date\": \"2023-03-25\", \"startTime\": \"08:00\", \"endTime\": \"16:00\" } ] }, { \"id\": 2, \"name\": \"Jane Smith\", \"extra\": [ { \"date\": \"2023-03-07\", \"startTime\": \"12:00\", \"endTime\": \"20:00\" }, { \"date\": \"2023-03-15\", \"startTime\": \"08:00\", \"endTime\": \"16:00\" } ] } ] }";

        JSONObject empRollingWeeksObj = null;
        JSONObject empLeavesObj = null;
        JSONObject empExtraDaysObj = null;
        try {
            empRollingWeeksObj = new JSONObject(empRollingWeeks);
            empLeavesObj = new JSONObject(empLeaves);
            empExtraDaysObj = new JSONObject(empExtraDays);
        } catch (JSONException err) {
            Log.d("Error", err.toString());
        }

        // Set the column width to a fixed size
        final int COLUMN_WIDTH_DP = 100; // replace with your desired width in dp
        final float SCALE = getResources().getDisplayMetrics().density;
        final int COLUMN_WIDTH_PX = (int) (COLUMN_WIDTH_DP * SCALE + 0.5f);

        TableLayout tableLayout = findViewById(R.id.schedule_table);

        // Get the number of days in the current month and the name of the current month
        Calendar calendar = Calendar.getInstance();
        int numDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Set the calendar to the first day of the current month
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // format the month and year to display in the TextView
        String monthYearTitle = (String) android.text.format.DateFormat.format("MMM yyyy", new Date());
        // Obtain a reference to the TextView using its ID
        TextView textView = findViewById(R.id.month_year_title);
        // Set the text of the TextView
        textView.setText(monthYearTitle);

        // array of days size is numDaysInMonth
        String[] daysOfMonth = new String[numDaysInMonth];


        // Loop through each day of the month and add its day of the week to the array
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        for (int i = 1; i <= numDaysInMonth; i++) {
            // Set the calendar to the current day of the month
            calendar.set(Calendar.DAY_OF_MONTH, i);

            // Get the day of the week (e.g. "Sunday", "Monday", etc.)
            String dayOfWeek = dateFormat.format(calendar.getTime());
            // Add the day of the week to the array
            daysOfMonth[i - 1] = dayOfWeek;
        }


        // Create the header row
        TableRow headerRow = new TableRow(ViewSchduleActivity.this);
        headerRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        // Add a TextView for employee name
        TextView empHeaderTitle = new TextView(ViewSchduleActivity.this);
        empHeaderTitle.setText("Employees");
        empHeaderTitle.setGravity(Gravity.CENTER_VERTICAL);
        empHeaderTitle.setTextAppearance(this, android.R.style.TextAppearance_Medium);
        empHeaderTitle.setBackgroundColor(ContextCompat.getColor(this, R.color.brown));
        empHeaderTitle.setTextColor(ContextCompat.getColor(this, R.color.light_white));
        empHeaderTitle.setPadding(10, 10, 10, 10);
        headerRow.addView(empHeaderTitle, new TableRow.LayoutParams(COLUMN_WIDTH_PX, TableRow.LayoutParams.WRAP_CONTENT, 1));
        headerRow.setDividerDrawable(ContextCompat.getDrawable(this, android.R.drawable.status_bar_item_app_background));
        headerRow.setShowDividers(TableRow.SHOW_DIVIDER_MIDDLE);

        // Add TextViews for each day of the month to the header row
        for (int i = 1; i <= numDaysInMonth; i++) {
            TextView dayOfMonthTitle = new TextView(ViewSchduleActivity.this);
            dayOfMonthTitle.setText(String.format("%s %s", Integer.toString(i), daysOfMonth[i - 1]));
            dayOfMonthTitle.setGravity(Gravity.CENTER_VERTICAL);
            dayOfMonthTitle.setTextAppearance(this, android.R.style.TextAppearance_Medium);
            dayOfMonthTitle.setBackgroundColor(ContextCompat.getColor(this, R.color.brown));
            dayOfMonthTitle.setTextColor(ContextCompat.getColor(this, R.color.light_white));

            dayOfMonthTitle.setPadding(10, 10, 10, 10);

            headerRow.addView(dayOfMonthTitle, new TableRow.LayoutParams(COLUMN_WIDTH_PX, TableRow.LayoutParams.WRAP_CONTENT, 1));
        }

        // Add the header row to the TableLayout
        tableLayout.addView(headerRow);


        // loop through empRollingWeeksObj and add a row for each employee
        // get list of employees from empRollingWeeksObj
        JSONArray employees = null;
        try {
            employees = empRollingWeeksObj.getJSONArray("employees");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

// iterate over employees and add schedule to table
        for (int i = 0; i < employees.length(); i++) {
            // get employee object
            JSONObject employee = null;
            try {
                employee = employees.getJSONObject(i);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            // create new row
            TableRow row = new TableRow(this);
            // set minimum height of row
//            row.setMinimumHeight(200);
            row.setPadding(2, 2, 2, 2);
            row.setDividerDrawable(ContextCompat.getDrawable(this, android.R.drawable.status_bar_item_app_background));
            row.setShowDividers(TableRow.SHOW_DIVIDER_MIDDLE);

            // create text view for employee name
            TextView nameView = new TextView(this);
            try {
                nameView.setText(employee.getString("name"));
                nameView.setGravity(Gravity.CENTER_VERTICAL);
                nameView.setPadding(8, 10, 8, 10);
                nameView.setTextAppearance(this, android.R.style.TextAppearance_Medium);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            row.addView(nameView);

            // get schedule for first day of the month
            JSONArray schedule = null;
            try {
                schedule = employee.getJSONArray("schedule");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            // do we need this here?
            Calendar calendarForWeekDay = Calendar.getInstance();
            calendarForWeekDay.set(Calendar.DAY_OF_MONTH, 1);
            int firstDayOfMonth = calendarForWeekDay.get(Calendar.DAY_OF_WEEK) - 2; // starts with monday = 1, sunday = 7

            for (int j = 0; j < numDaysInMonth; j++) {

                JSONObject shift = null;
                try {
                    shift = schedule.getJSONObject((firstDayOfMonth + j) % 7);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                // create text view for shift start and end time
                TextView shiftView = new TextView(this);

                try {
                    if (shift.getString("startTime").equals("OFF")) {
                        shiftView.setText("OFF");
                    } else {
                        shiftView.setText(shift.getString("startTime") + "-" + shift.getString("endTime"));
                    }

                    shiftView.setGravity(Gravity.CENTER);
                    shiftView.setMinimumHeight(200);
                    shiftView.setBackgroundColor(ContextCompat.getColor(this, R.color.light_yellow));
                    shiftView.setTextColor(ContextCompat.getColor(this, R.color.brown));
                    shiftView.setPadding(8, 2, 8, 2);


                    // loop empLeaveDaysObj find matching employee in empLeaveDaysObj
                    JSONArray empLeavesArr = empLeavesObj.getJSONArray("employees");
                    for (int k = 0; k < empLeavesArr.length(); k++) {

                        JSONObject empLeaveDay = null;
                        try {
                            empLeaveDay = empLeavesArr.getJSONObject(k);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                        // if employee name matches
                        if (empLeaveDay.getString("id").equals(employee.getString("id"))) {
                            // get leave days for employee
                            JSONArray leaveDays = null;
                            try {
                                leaveDays = empLeaveDay.getJSONArray("leaves");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                            // loop through leave days
                            for (int l = 0; l < leaveDays.length(); l++) {
                                JSONObject leaveDay = null;
                                try {
                                    leaveDay = leaveDays.getJSONObject(l);
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                                // calendar date from leaveDay string "2019-01-01"
                                String[] date = leaveDay.getString("date").split("-");
                                int monthDay = Integer.parseInt(date[2]);

                                // if leave day matches current day of month set background color to red
                                if (monthDay == j) {
                                    shiftView.setText(String.format("%s-%s", leaveDay.getString("startTime"), leaveDay.getString("endTime")));
                                    shiftView.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                                    shiftView.setTextColor(ContextCompat.getColor(this, R.color.light_white));
                                }
                            }
                        }
                    }


                    // loop empLeaveDaysObj find matching employee in empLeaveDaysObj
                    JSONArray empExtraArr = empExtraDaysObj.getJSONArray("employees");
                    for (int k = 0; k < empExtraArr.length(); k++) {

                        JSONObject empExtraDay = null;
                        try {
                            empExtraDay = empExtraArr.getJSONObject(k);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                        // if employee name matches
                        if (empExtraDay.getString("id").equals(employee.getString("id"))) {
                            // get leave days for employee
                            JSONArray extraDays = null;
                            try {
                                extraDays = empExtraDay.getJSONArray("extra");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                            // loop through leave days
                            for (int l = 0; l < extraDays.length(); l++) {
                                JSONObject extraDay = null;
                                try {
                                    extraDay = extraDays.getJSONObject(l);
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                                // calendar date from extraDay string "2019-01-01"
                                String[] date = extraDay.getString("date").split("-");
                                int monthDay = Integer.parseInt(date[2]);

                                // if leave day matches current day of month set background color to red
                                if (monthDay == j) {
                                    shiftView.setText(String.format("%s-%s", extraDay.getString("startTime"), extraDay.getString("endTime")));
                                    shiftView.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                                    shiftView.setTextColor(ContextCompat.getColor(this, R.color.light_white));
                                }
                            }
                        }
                    }


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                row.addView(shiftView);

            }

            // add row to table
            tableLayout.addView(row);
        }

    }
}