package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "EXTRA_DAY")
public class ExtraDay {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "EXTRA_DATE", nullable = false)
    private Date extraDate;

    @Basic
    @Column(name = "SHIFT", nullable = false)
    private int shiftId;

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

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

    public Date getExtraDate() {
        return extraDate;
    }

    public void setExtraDate(Date extraDate) {
        this.extraDate = extraDate;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraDay extraDay = (ExtraDay) o;
        return id == extraDay.id && empId == extraDay.empId && Objects.equals(extraDate, extraDay.extraDate);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, extraDate, empId);
    }
}
