package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "SHIFT")
public class Shift implements java.io.Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "SHIFT_NAME", nullable = false)
    private String shiftName;

    @Basic
    @Column(name = "START_TIME", nullable = false)
    private LocalTime startTime;
    @Basic
    @Column(name = "END_TIME", nullable = false)
    private LocalTime endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return id == shift.id &&
                Objects.equals(shiftName, shift.shiftName) &&
                Objects.equals(startTime, shift.startTime) &&
                Objects.equals(endTime, shift.endTime);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, shiftName, startTime, endTime);
    }
}
