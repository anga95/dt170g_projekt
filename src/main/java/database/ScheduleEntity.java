package database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "SCHEDULE", schema = "APP", catalog = "")
public class ScheduleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "DATE")
    private String date;
    @Basic
    @Column(name = "EMPLOYEE")
    private String employee;

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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleEntity that = (ScheduleEntity) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, employee);
    }
}
