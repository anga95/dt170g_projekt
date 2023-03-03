package se.miun.dt170g.scheduleapp.model;

import java.util.List;

public class EmpSchedule {
    private int id;
    private String name;
    private List<Shift> shifts;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Shift> getShifts() {
        return shifts;
    }
}
