package martin_test.deeper.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "MENU_ITEMS")
@NamedQueries({
        @NamedQuery(name ="menuItems.selectAll", query = "select menuItems from MenuItems menuItems "),
        @NamedQuery(name ="menuItems.remove", query = "delete from MenuItems menuItems where menuItems.id = :id")
})
public class MenuItems{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "PRICE", nullable = false)
    private int price;
    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 100)
    private String description;
    @Basic
    @Column(name = "TIME", nullable = true)
    private Integer time;
    @Basic
    @Column(name = "CATEGORY", nullable = true, length = 50)
    private String category;

    public MenuItems(int price, String name, String description, Integer time, String category) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.time = time;
        this.category = category;
    }

    public MenuItems() {

    }

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

        MenuItems that = (MenuItems) o;

        if (id != that.id) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public String toString() {
        return name + price + "\n";

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);

        return result;
    }
}
