package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS")
@NamedQueries({
        @NamedQuery(name ="orderItems.selectAll", query = "select oi from OrdersEntity oi "),
        @NamedQuery(name ="orderItems.remove", query = "delete from OrdersEntity oi where oi.id = :id")
        //@NamedQuery(name="orderItems.changeStatus", query= "update status from OrderItems")
})
public class OrderItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "MENU_ITEM_ID", nullable = true)
    private Integer menuItemId;
    @Basic
    @Column(name = "STATUS", nullable = true)
    private Boolean status;
    @Basic
    @Column(name = "QUANTITY", nullable = true)
    private int quantity;
    @Basic
    @Column(name = "TABLE_NR", nullable = true)
    private Integer tableNr;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getTableNr() {
        return tableNr;
    }

    public void setTableNr(Integer tableNr) {
        this.tableNr = tableNr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemsEntity that = (OrderItemsEntity) o;
        return id == that.id && quantity == that.quantity && menuItemId.equals(that.menuItemId) && status.equals(that.status) && tableNr.equals(that.tableNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuItemId, status, quantity, tableNr);
    }
}
