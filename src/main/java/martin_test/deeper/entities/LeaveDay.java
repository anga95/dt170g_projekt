package martin_test.deeper.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "LEAVE_DAY", schema = "APP", catalog = "")
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
}
