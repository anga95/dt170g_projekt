package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_schedule", schema = "APP")
public class EmployeeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    // foreign key to employee
    @OneToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_monday", nullable = false)
    private Shift vOneMonday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_tuesday", nullable = false)
    private Shift vOneTuesday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_wednesday", nullable = false)
    private Shift vOneWednesday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_thursday", nullable = false)
    private Shift vOneThursday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_friday", nullable = false)
    private Shift vOneFriday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_saturday", nullable = false)
    private Shift vOneSaturday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_one_sunday", nullable = false)
    private Shift vOneSunday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_monday", nullable = false)
    private Shift vTwoMonday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_tuesday", nullable = false)
    private Shift vTwoTuesday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_wednesday", nullable = false)
    private Shift vTwoWednesday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_thursday", nullable = false)
    private Shift vTwoThursday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_friday", nullable = false)
    private Shift vTwoFriday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_saturday", nullable = false)
    private Shift vTwoSaturday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "v_two_sunday", nullable = false)
    private Shift vTwoSunday;

    public EmployeeSchedule() {}

    public EmployeeSchedule(Employee employee, Shift vOneMonday, Shift vOneTuesday, Shift vOneWednesday, Shift vOneThursday, Shift vOneFriday, Shift vOneSaturday, Shift vOneSunday, Shift vTwoMonday, Shift vTwoTuesday, Shift vTwoWednesday, Shift vTwoThursday, Shift vTwoFriday, Shift vTwoSaturday, Shift vTwoSunday) {
        this.employee = employee;
        this.vOneMonday = vOneMonday;
        this.vOneTuesday = vOneTuesday;
        this.vOneWednesday = vOneWednesday;
        this.vOneThursday = vOneThursday;
        this.vOneFriday = vOneFriday;
        this.vOneSaturday = vOneSaturday;
        this.vOneSunday = vOneSunday;
        this.vTwoMonday = vTwoMonday;
        this.vTwoTuesday = vTwoTuesday;
        this.vTwoWednesday = vTwoWednesday;
        this.vTwoThursday = vTwoThursday;
        this.vTwoFriday = vTwoFriday;
        this.vTwoSaturday = vTwoSaturday;
        this.vTwoSunday = vTwoSunday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Shift getvOneMonday() {
        return vOneMonday;
    }

    public void setvOneMonday(Shift vOneMonday) {
        this.vOneMonday = vOneMonday;
    }

    public Shift getvOneTuesday() {
        return vOneTuesday;
    }

    public void setvOneTuesday(Shift vOneTuesday) {
        this.vOneTuesday = vOneTuesday;
    }

    public Shift getvOneWednesday() {
        return vOneWednesday;
    }

    public void setvOneWednesday(Shift vOneWednesday) {
        this.vOneWednesday = vOneWednesday;
    }

    public Shift getvOneThursday() {
        return vOneThursday;
    }

    public void setvOneThursday(Shift vOneThursday) {
        this.vOneThursday = vOneThursday;
    }

    public Shift getvOneFriday() {
        return vOneFriday;
    }

    public void setvOneFriday(Shift vOneFriday) {
        this.vOneFriday = vOneFriday;
    }

    public Shift getvOneSaturday() {
        return vOneSaturday;
    }

    public void setvOneSaturday(Shift vOneSaturday) {
        this.vOneSaturday = vOneSaturday;
    }

    public Shift getvOneSunday() {
        return vOneSunday;
    }

    public void setvOneSunday(Shift vOneSunday) {
        this.vOneSunday = vOneSunday;
    }

    public Shift getvTwoMonday() {
        return vTwoMonday;
    }

    public void setvTwoMonday(Shift vTwoMonday) {
        this.vTwoMonday = vTwoMonday;
    }

    public Shift getvTwoTuesday() {
        return vTwoTuesday;
    }

    public void setvTwoTuesday(Shift vTwoTuesday) {
        this.vTwoTuesday = vTwoTuesday;
    }

    public Shift getvTwoWednesday() {
        return vTwoWednesday;
    }

    public void setvTwoWednesday(Shift vTwoWednesday) {
        this.vTwoWednesday = vTwoWednesday;
    }

    public Shift getvTwoThursday() {
        return vTwoThursday;
    }

    public void setvTwoThursday(Shift vTwoThursday) {
        this.vTwoThursday = vTwoThursday;
    }

    public Shift getvTwoFriday() {
        return vTwoFriday;
    }

    public void setvTwoFriday(Shift vTwoFriday) {
        this.vTwoFriday = vTwoFriday;
    }

    public Shift getvTwoSaturday() {
        return vTwoSaturday;
    }

    public void setvTwoSaturday(Shift vTwoSaturday) {
        this.vTwoSaturday = vTwoSaturday;
    }

    public Shift getvTwoSunday() {
        return vTwoSunday;
    }

    public void setvTwoSunday(Shift vTwoSunday) {
        this.vTwoSunday = vTwoSunday;
    }

}