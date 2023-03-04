//package martin_test.deeper.entities;
//
//import jakarta.persistence.*;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "KANONBAS")
//@NamedQueries({
//        @NamedQuery(name="KB.selectAll", query = "select kb from Kanonbas kb")
//})
//public class Kanonbas {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "ID", nullable = false)
//    private int id;
//    @Basic
//    @Column(name = "RADIUS", nullable = true)
//    private Integer radius;
//    @Basic
//    @Column(name = "NAME", nullable = true, length = 50)
//    private String name;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Integer getRadius() {
//        return radius;
//    }
//
//    public void setRadius(Integer radius) {
//        this.radius = radius;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//
//}
