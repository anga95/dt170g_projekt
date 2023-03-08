/*
package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "DAILY_LUNCH", schema = "TEST", catalog = "")
public class DailyLunchEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "WEEKDAY")
    private String weekday;
    @Basic
    @Column(name = "LUNCH_1")
    private String lunch1;
    @Basic
    @Column(name = "LUNCH_2")
    private String lunch2;
    @Basic
    @Column(name = "LUNCH_3")
    private String lunch3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getLunch1() {
        return lunch1;
    }

    public void setLunch1(String lunch1) {
        this.lunch1 = lunch1;
    }

    public String getLunch2() {
        return lunch2;
    }

    public void setLunch2(String lunch2) {
        this.lunch2 = lunch2;
    }

    public String getLunch3() {
        return lunch3;
    }

    public void setLunch3(String lunch3) {
        this.lunch3 = lunch3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyLunchEntity that = (DailyLunchEntity) o;
        return id == that.id && Objects.equals(weekday, that.weekday) && Objects.equals(lunch1, that.lunch1) && Objects.equals(lunch2, that.lunch2) && Objects.equals(lunch3, that.lunch3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weekday, lunch1, lunch2, lunch3);
    }
}
*/
