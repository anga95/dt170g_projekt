package se.miun.dt170g.scheduleapp.model;

import java.util.List;

public class EmpLeaves {
    private int id;
    private String name;
    private List<Leave> leaves;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Leave> getLeaves() {
        return leaves;
    }
}
