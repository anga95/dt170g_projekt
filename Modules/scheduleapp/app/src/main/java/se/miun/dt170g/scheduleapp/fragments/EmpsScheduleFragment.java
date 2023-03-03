package se.miun.dt170g.scheduleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import se.miun.dt170g.scheduleapp.R;
import se.miun.dt170g.scheduleapp.model.EmpExtras;
import se.miun.dt170g.scheduleapp.model.EmpLeaves;
import se.miun.dt170g.scheduleapp.model.EmpSchedule;
import se.miun.dt170g.scheduleapp.ui.adapters.CalendarAdapter;
import se.miun.dt170g.scheduleapp.viewmodel.EmpScheduleViewModel;

public class EmpsScheduleFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CalendarAdapter mAdapter;
    private EmpScheduleViewModel mViewModel;
    private List<EmpSchedule> empSchedules;
    private List<EmpLeaves> empLeaves;
    private List<EmpExtras> empExtras;

    public EmpsScheduleFragment() {
        // Required empty public constructor
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.recycler_view_schedule, container, false);
//
//        // Initialize the RecyclerView and its adapter
//        mRecyclerView = view.findViewById(R.id.recycler_view_employee_schedule);
//        mAdapter = new CalendarAdapter(context, empSchedules, empLeaves, empExtras);
//        mRecyclerView.setAdapter(mAdapter);
//
//        // Initialize the ViewModel
//        mViewModel = new ViewModelProvider(this).get(EmpScheduleViewModel.class);
//
//        // Observe the LiveData and update the adapter when the data changes
//        mViewModel.getEmployeeScheduleLiveData().observe(getViewLifecycleOwner(), new Observer<List<EmpSchedule>>() {
//            @Override
//            public void onChanged(List<EmpSchedule> empSchedules) {
//                mAdapter.setEmpSchedules(empSchedules);
//            }
//        });
//        mViewModel.getEmployeeLeavesLiveData().observe(getViewLifecycleOwner(), new Observer<List<EmpLeaves>>() {
//            @Override
//            public void onChanged(List<EmpLeaves> empLeaves) {
//                mAdapter.setEmpLeaves(empLeaves);
//            }
//        });
//        mViewModel.getEmployeeExtrasLiveData().observe(getViewLifecycleOwner(), new Observer<List<EmpExtras>>() {
//            @Override
//            public void onChanged(List<EmpExtras> empExtras) {
//                mAdapter.setEmpExtras(empExtras);
//            }
//        });
//
//        // Load the employee schedule data
//        mViewModel.loadEmployeeSchedule();
//
//        return view;
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_schedule, container, false);

        // Initialize the RecyclerView
        mRecyclerView = view.findViewById(R.id.recycler_view_employee_schedule);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize the adapter with empty lists
        mAdapter = new CalendarAdapter(getActivity(), empSchedules, empLeaves, empExtras);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public void updateSchedules(List<EmpSchedule> empSchedules) {
        mAdapter.setEmpSchedules(empSchedules);
    }

    public void updateExtras(List<EmpExtras> empExtras) {
        mAdapter.setEmpExtras(empExtras);
    }

    public void updateLeaves(List<EmpLeaves> empLeaves) {
        mAdapter.setEmpLeaves(empLeaves);
    }
}
