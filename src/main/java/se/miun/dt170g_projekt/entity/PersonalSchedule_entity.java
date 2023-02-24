package se.miun.dt170g_projekt.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PERSONAL_SCHEDULE", schema = "APP", catalog = "")
public class PersonalSchedule_entity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "DATE")
    private String date;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Basic
    @Column(name = "END_TIME")
    private String endTime;
    @Basic
    @Column(name = "START_TIME")
    private String startTime;

    public PersonalSchedule_entity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalSchedule_entity that = (PersonalSchedule_entity) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(description, that.description) && Objects.equals(employeeId, that.employeeId) && Objects.equals(endTime, that.endTime) && Objects.equals(startTime, that.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, employeeId, endTime, startTime);
    }
}
