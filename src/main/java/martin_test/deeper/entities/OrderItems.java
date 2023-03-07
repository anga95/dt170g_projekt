package martin_test.deeper.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS")
@NamedQueries({
        @NamedQuery(name ="orderItems.selectAll", query = "select oi from Orders oi "),
        @NamedQuery(name ="orderItems.remove", query = "delete from Orders oi where oi.id = :id")
})
public class OrderItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "ORDER_ID", nullable = true)
    private Integer orderId;
    @Basic
    @Column(name = "MENU_ITEM_ID", nullable = true)
    private Integer menuItemId;
    @Basic
    @Column(name = "STATUS")
    private Boolean status;

    @Basic
    @Column(name = "QUANTITY")
    private Integer quantity;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuItemId() {
        return menuItemId;
    }
    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItems that = (OrderItems) o;

        if (id != that.id) return false;
        return Objects.equals(orderId, that.orderId);
    }

}
