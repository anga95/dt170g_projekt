package database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "PERSONAL_SCHEDULE", schema = "APP", catalog = "")
public class PersonalScheduleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "DATE")
    private String date;
    @Basic
    @Column(name = "START_TIME")
    private String startTime;
    @Basic
    @Column(name = "END_TIME")
    private String endTime;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalScheduleEntity that = (PersonalScheduleEntity) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(description, that.description) && Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, startTime, endTime, description, employeeId);
    }
}
