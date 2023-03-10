package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MENU_ITEMS")
@NamedQueries({
        @NamedQuery(name ="menuItems.selectAll", query = "select menuItems from MenuItemsEntity menuItems "),
        @NamedQuery(name ="menuItems.remove", query = "delete from MenuItemsEntity menuItems where menuItems.id = :id"),
        @NamedQuery(name ="menuItems.findById", query = "SELECT menuItems FROM MenuItemsEntity menuItems WHERE menuItems.id = :id")
})
public class MenuItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "PRICE")
    private int price;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "TIME")
    private Integer time;
    @Basic
    @Column(name = "CATEGORY")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItemsEntity that = (MenuItemsEntity) o;
        return id == that.id && price == that.price && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(time, that.time) && Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name, description, time, category);
    }
}
