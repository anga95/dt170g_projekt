//package database.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Drinks {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "ID", nullable = false)
//    private int id;
//    @Basic
//    @Column(name = "Price", nullable = true)
//    private Integer price;
//    @Basic
//    @Column(name = "Description", nullable = true, length = 50)
//    private String description;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
