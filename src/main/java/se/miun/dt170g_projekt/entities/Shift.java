package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "SHIFT")
public class Shift {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "SHIFT_NAME", nullable = false)
    private String shiftName;

    @Basic
    @Column(name = "START_TIME", nullable = false)
    private Time startTime;
    @Basic
    @Column(name = "END_TIME", nullable = true)
    private Time endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return id == shift.id && Objects.equals(shiftName, shift.shiftName) && Objects.equals(startTime, shift.startTime) && Objects.equals(endTime, shift.endTime);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, shiftName, startTime, endTime);
    }
}
