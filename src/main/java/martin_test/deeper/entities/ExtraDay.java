package martin_test.deeper.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "EXTRA_DAY", schema = "APP", catalog = "")
public class ExtraDay {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "EXTRA_DATE", nullable = false)
    private Date extraDate;
    @Basic
    @Column(name = "START_TIME", nullable = false)
    private Time startTime;
    @Basic
    @Column(name = "END_TIME", nullable = false)
    private Time endTime;

    @OneToOne
    @JoinColumn(name = "EMP_ID", referencedColumnName = "ID")
    private int empId;

    public Object getEmpId() {
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
}
