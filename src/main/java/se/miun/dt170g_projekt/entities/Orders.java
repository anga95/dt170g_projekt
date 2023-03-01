package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDERS", schema = "APP")
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "alaCarte_ID")
    private Integer alaCarteId;
    @Basic
    @Column(name = "Dessert_ID")
    private Integer dessertId;
    @Basic
    @Column(name = "Drinks_ID")
    private Integer drinksId;
    @Basic
    @Column(name = "Starters_ID")
    private Integer startersId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAlaCarteId() {
        return alaCarteId;
    }

    public void setAlaCarteId(Integer alaCarteId) {
        this.alaCarteId = alaCarteId;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public Integer getDrinksId() {
        return drinksId;
    }

    public void setDrinksId(Integer drinksId) {
        this.drinksId = drinksId;
    }

    public Integer getStartersId() {
        return startersId;
    }

    public void setStartersId(Integer startersId) {
        this.startersId = startersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Objects.equals(alaCarteId, orders.alaCarteId) && Objects.equals(dessertId, orders.dessertId) && Objects.equals(drinksId, orders.drinksId) && Objects.equals(startersId, orders.startersId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alaCarteId, dessertId, drinksId, startersId);
    }
}
