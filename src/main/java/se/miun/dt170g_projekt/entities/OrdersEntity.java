package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name ="orders.selectAll", query = "select orders from OrdersEntity orders "),
        @NamedQuery(name ="orders.remove", query = "delete from OrdersEntity orders where orders.id = :id")
})
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "TABLE_NR", nullable = true)
    private Integer tableNr;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        OrdersEntity that = (OrdersEntity) o;
        if (id != that.id) return false;
        return Objects.equals(tableNr, that.tableNr);
    }

}
