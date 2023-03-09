package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "SCHEDULE")
//@NamedQueries({
//        @NamedQuery(name = "schedule.selectAll", query = "select schedule from Schedule schedule "),
//        @NamedQuery(name = "schedule.selectById", query = "select schedule from Schedule schedule where schedule.id = :id"),
//        @NamedQuery(name = "schedule.selectByEmployeeId", query = "select schedule from Schedule schedule where schedule.empId = :employeeId"),
//
//        @NamedQuery(name = "schedule.updateById", query = "update Schedule schedule set schedule.mon = :mon, schedule.tue = :tue, schedule.wed = :wed, schedule.thu = :thu, schedule.fri = :fri, schedule.sat = :sat, schedule.sun = :sun where schedule.id = :id"),
//        @NamedQuery(name = "schedule.updateByEmployeeId", query = "update Schedule schedule set schedule.mon = :mon, schedule.tue = :tue, schedule.wed = :wed, schedule.thu = :thu, schedule.fri = :fri, schedule.sat = :sat, schedule.sun = :sun where schedule.empId = :employeeId"),
//
//        @NamedQuery(name = "schedule.removeById", query = "delete from Schedule schedule where schedule.id = :id"),
//})
public class Schedule{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "EMP_ID", nullable = false)
    private Long empId;

    @Basic
    @Column(name = "MON", nullable = true)
    private int mon;
    @Basic
    @Column(name = "TUE", nullable = true)
    private int tue;
    @Basic
    @Column(name = "WED", nullable = true)
    private int wed;
    @Basic
    @Column(name = "THU", nullable = true)
    private int thu;
    @Basic
    @Column(name = "FRI", nullable = true)
    private int fri;
    @Basic
    @Column(name = "SAT", nullable = true)
    private int sat;
    @Basic
    @Column(name = "SUN", nullable = true)
    private int sun;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @OneToOne
//    @JoinColumn(name = "EMP_ID", nullable = false)
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getTue() {
        return tue;
    }

    public void setTue(int tue) {
        this.tue = tue;
    }

    public int getWed() {
        return wed;
    }

    public void setWed(int wed) {
        this.wed = wed;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getFri() {
        return fri;
    }

    public void setFri(int fri) {
        this.fri = fri;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule that = (Schedule) o;

        return Objects.equals(id, that.id) &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(mon, that.mon) &&
                Objects.equals(tue, that.tue) &&
                Objects.equals(wed, that.wed) &&
                Objects.equals(thu, that.thu) &&
                Objects.equals(fri, that.fri) &&
                Objects.equals(sat, that.sat) &&
                Objects.equals(sun, that.sun);

    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id, empId, mon, tue, wed, thu, fri, sat, sun);
    }
}
