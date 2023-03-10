package se.miun.dt170g_projekt.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TOTALORDERS")
public class TotalOrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;
    @Basic
    @Column(name = "CATEGORY", nullable = true, length = 50)
    private String category;
    @Basic
    @Column(name = "NOTE", nullable = true, length = 100)
    private String note;
    @Basic
    @Column(name = "TIME", nullable = true)
    private Integer time;
    @Basic
    @Column(name = "QUANTITY", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "STATUS", nullable = true)
    private Boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
