package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS")
@NamedQueries({
        @NamedQuery(name ="orderItems.selectAll", query = "select oi from OrdersEntity oi "),
        @NamedQuery(name ="orderItems.remove", query = "delete from OrdersEntity oi where oi.id = :id"),
        //@NamedQuery(name="orderItems.changeStatus", query= "update status from OrderItems")
        @NamedQuery(name ="OrderItems.updateStatus",query="update OrderItemsEntity SET status = TRUE WHERE id = :id")
})
public class OrderItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    /*@ManyToOne
    @JoinColumn(name = "MENU_ITEM_ID")
    private MenuItemsEntity menuItemId;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ITEM_ID")
    private MenuItemsEntity menuItemId;

    @Basic
    @Column(name = "STATUS", nullable = true)
    private Boolean status;
    @Basic
    @Column(name = "QUANTITY", nullable = true)
    private int quantity;
    @Basic
    @Column(name = "TABLE_NR", nullable = true)
    private int tableNr;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;}

    public MenuItemsEntity getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(MenuItemsEntity menuItemId) {
        this.menuItemId = menuItemId;
    }

    //public int getMenuItemId() {
    //    return menuItemId;
    //}
    //public void setMenuItemId(int menuItemId) { this.menuItemId = menuItemId; }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTableNr() {
        return tableNr;
    }

    public void setTableNr(int tableNr) {
        this.tableNr = tableNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuItemId, status, quantity, tableNr);
    }
}
