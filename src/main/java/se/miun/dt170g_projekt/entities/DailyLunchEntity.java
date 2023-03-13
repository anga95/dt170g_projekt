package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DAILY_LUNCH", schema = "APP", catalog = "")
public class DailyLunchEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "WEEKDAY", nullable = true, length = 25)
    private String weekday;
    @Basic
    @Column(name = "LUNCH_1", nullable = true, length = 250)
    private String lunch1;
    @Basic
    @Column(name = "LUNCH_2", nullable = true, length = 250)
    private String lunch2;
    @Basic
    @Column(name = "LUNCH_3", nullable = true, length = 250)
    private String lunch3;
    @Basic
    @Column(name = "PRICE", nullable = true)
    private Integer price;
    @Basic
    @Column(name = "TIME", nullable = true)
    private Integer time;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
