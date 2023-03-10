package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
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
    @Column(name = "START_TIME", nullable = false)
    private Time startTime;
    @Basic
    @Column(name = "END_TIME", nullable = false)
    private Time endTime;

    @Basic
    @Column(name = "EMP_ID", nullable = false)
    private int empId;

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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveDay leaveDay = (LeaveDay) o;
        return id == leaveDay.id &&
                empId == leaveDay.empId &&
                leaveDate.equals(leaveDay.leaveDate) &&
                startTime.equals(leaveDay.startTime) &&
                endTime.equals(leaveDay.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leaveDate, startTime, endTime, empId);
    }

}