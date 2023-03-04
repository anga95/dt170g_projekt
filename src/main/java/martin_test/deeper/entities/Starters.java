//package martin_test.deeper.entities;
//
//import jakarta.persistence.*;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "STARTERS", )
//@NamedQueries({
//        @NamedQuery(name="starters.selectAll", query = "select starters from Starters starters"),
//        @NamedQuery(name="starters.remove", query = "delete from Starters starters where starters.id = :id" )
//})
//public class Starters {
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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Starters that = (Starters) o;
//
//        if (id != that.id) return false;
//        return Objects.equals(description, that.description);
//    }
//
//    @Override //to string körs automatiskt ifall man kör typ en for auto loop
//    public String toString() {
//        return "StartersID=" + id + " description: " + description +"\n";
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }
//}
