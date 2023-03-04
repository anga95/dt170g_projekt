//package database.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Order {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "ID", nullable = false)
//    private int id;
//    @Basic
//    @Column(name = "alaCarte_ID", nullable = true)
//    private Integer alaCarteId;
//    @Basic
//    @Column(name = "Dessert_ID", nullable = true)
//    private Integer dessertId;
//    @Basic
//    @Column(name = "Drinks_ID", nullable = true)
//    private Integer drinksId;
//    @Basic
//    @Column(name = "Starters_ID", nullable = true)
//    private Integer startersId;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Integer getAlaCarteId() {
//        return alaCarteId;
//    }
//
//    public void setAlaCarteId(Integer alaCarteId) {
//        this.alaCarteId = alaCarteId;
//    }
//
//    public Integer getDessertId() {
//        return dessertId;
//    }
//
//    public void setDessertId(Integer dessertId) {
//        this.dessertId = dessertId;
//    }
//
//    public Integer getDrinksId() {
//        return drinksId;
//    }
//
//    public void setDrinksId(Integer drinksId) {
//        this.drinksId = drinksId;
//    }
//
//    public Integer getStartersId() {
//        return startersId;
//    }
//
//    public void setStartersId(Integer startersId) {
//        this.startersId = startersId;
//    }
//}
