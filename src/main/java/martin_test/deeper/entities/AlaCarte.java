//package martin_test.deeper.entities;
//
//import jakarta.persistence.*;
//import martin_test.db.KanonbasEntity;
//import martin_test.deeper.web.AlaCarteBean;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "ALACARTE")
//@NamedQueries({
//        @NamedQuery(name="alc.selectAll", query = "select alc from AlaCarte alc"),
//        @NamedQuery(name="alc.remove", query = "delete from AlaCarte alc where alc.id = :id" )
//})
//public class AlaCarte {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "ID", nullable = false)
//    private int id;
//    @Basic
//    @Column(name = "PRICE", nullable = true)
//    private Integer price;
//    @Basic
//    @Column(name = "DESCRIPTION", nullable = true, length = 50)
//    private String description;
//    @Basic
//    @Column(name = "TIME", nullable = true)
//    private Integer time;
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
//
//    public Integer getTime() {
//        return time;
//    }
//
//    public void setTime(Integer time) {
//        this.time = time;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        AlaCarte that = (AlaCarte) o;
//
//        if (id != that.id) return false;
//        return Objects.equals(description, that.description);
//    }
//
//    @Override
//    public String toString() {
//        return "AlaCarteID=" + id + " description: " + description+"\n";
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }
//}
