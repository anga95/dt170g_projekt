package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "STARTERS", schema = "APP")
public class Starters {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Starters starters = (Starters) o;
        return id == starters.id && Objects.equals(price, starters.price) && Objects.equals(description, starters.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, description);
    }
}
