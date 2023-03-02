package se.miun.dt170g_projekt.entites;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "BOOKING", schema = "TEST", catalog = "")
public class BookingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "DATE")
    private String date;
    @Basic
    @Column(name = "TIME")
    private String time;
    @Basic
    @Column(name = "FNAME")
    private String fname;
    @Basic
    @Column(name = "LNAME")
    private String lname;
    @Basic
    @Column(name = "TELNUMBER")
    private String telnumber;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "NUMBER_OF_PEOPLE")
    private String numberOfPeople;
    @Basic
    @Column(name = "EXTRA")
    private String extra;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return id == that.id && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(fname, that.fname) && Objects.equals(lname, that.lname) && Objects.equals(telnumber, that.telnumber) && Objects.equals(email, that.email) && Objects.equals(numberOfPeople, that.numberOfPeople) && Objects.equals(extra, that.extra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, fname, lname, telnumber, email, numberOfPeople, extra);
    }
}
