package se.miun.dt170g.scheduleapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.miun.dt170g.scheduleapp.R;
import se.miun.dt170g.scheduleapp.fragments.EmpsScheduleFragment;
import se.miun.dt170g.scheduleapp.viewmodel.EmpScheduleViewModel;

public class ViewEmpSchedulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_emp_schedules);

// Obtain a reference to the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

// Create a new instance of the EmployeeScheduleFragment
        EmpsScheduleFragment fragment = new EmpsScheduleFragment();

// Start a new FragmentTransaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();

// Add the fragment to the container in the activity layout
        transaction.add(R.id.fragment_container, fragment);

// Commit the transaction
        transaction.commit();


        Button forgetUser = findViewById(R.id.forget_user_button);
        forgetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("appPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("empId", ""); //userInfo.getUsername()
                editor.apply();

                Intent intent = new Intent(ViewEmpSchedulesActivity.this, MainActivity.class);
                // Change view to ViewScheduleActivity
                startActivity(intent);
            }
        });
    }
}