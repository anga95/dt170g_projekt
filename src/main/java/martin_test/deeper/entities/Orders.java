package martin_test.deeper.entities;

import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ORDERS")
@NamedQueries({
        @NamedQuery(name ="orders.selectAll", query = "select orders from Orders orders "),
        @NamedQuery(name ="orders.remove", query = "delete from Orders orders where orders.id = :id")
})
public class Orders {
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
        Orders that = (Orders) o;
        if (id != that.id) return false;
        return Objects.equals(tableNr, that.tableNr);
    }

}
