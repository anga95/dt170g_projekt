package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ALACARTE", schema = "APP")
public class Alacarte {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "Price")
    private Integer price;
    @Basic
    @Column(name = "Description")
    private String description;
    @Basic
    @Column(name = "Time")
    private Integer time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alacarte alacarte = (Alacarte) o;
        return id == alacarte.id && Objects.equals(price, alacarte.price) && Objects.equals(description, alacarte.description) && Objects.equals(time, alacarte.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, description, time);
    }
}
