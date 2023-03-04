//package old.entities;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@PersistenceContext(unitName = "default")
//@Table(name = "alaCarte", schema = "APP")
////@XmlRootElement
//@NamedQueries({
//        @NamedQuery(name="alc.selectAll", query = "select alc from AlaCarte alc")
//})
//public class AlaCarte implements Serializable {
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
//    @Basic
//    @Column(name = "Time", nullable = true)
//    private Integer time;
//
//    public AlaCarte(){}
//    public AlaCarte(int id){
//        this.id = id;
//    }
//    public AlaCarte(int price, String description, int time){
//        this.price = price;
//        this.description = description;
//        this.time = time;
//    }
//    public AlaCarte(int id, Integer price, String description, Integer time) {
//        this.id = id;
//        this.price = price;
//        this.description = description;
//        this.time = time;
//    }
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getTime() {
//        return time;
//    }
//    public void setTime(Integer time) {
//        this.time = time;
//    }
//
//    @Override //overridear default equals functionen
//    public boolean equals(Object obj){
//        if (this == obj) {return true;}
//        if (obj == null || this.getClass() != obj.getClass()) { return false;}
//
//        AlaCarte det = (AlaCarte) obj; //explicitly cast obj to AlaCarte2'
//
//        if (id != det.id){ return false;}
//        if (price != det.price){ return false;}
//        if (description != null) { if (!description.equals(det.description)){return false;}
//        } else if (det.description != null) { return false; }
//        if (time != det.time){ return false;}
//        return true;
//    }
//
//}
