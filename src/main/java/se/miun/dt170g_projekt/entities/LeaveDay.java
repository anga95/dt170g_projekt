package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "LEAVE_DAY")
public class LeaveDay {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "LEAVE_DATE", nullable = false)
    private Date leaveDate;

    @Basic
    @Column(name = "EMP_ID", nullable = false)
    private int empId;

    @Basic
    @Column(name = "SHIFT", nullable = false)
    private int shiftId;

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveDay leaveDay = (LeaveDay) o;
        return id == leaveDay.id && empId == leaveDay.empId && Objects.equals(leaveDate, leaveDay.leaveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leaveDate, empId);
    }

}