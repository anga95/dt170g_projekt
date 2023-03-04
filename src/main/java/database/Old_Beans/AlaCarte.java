//package database.Old_Beans;
//
//import jakarta.inject.Named;
//import jakarta.persistence.*;
//import jakarta.servlet.annotation.WebServlet;
//
//import java.io.Serializable;
//
//
////kontroller ska ha @named och @requestscoped
//@Named
//@PersistenceContext(unitName = "DB")
//@Table(name = "alaCarte", schema = "APP", catalog = "")
//public class AlaCarte implements Serializable {
//
//    @Id
//    private int ID;
//    private int Price;
//    private String Description;
//    private int Time;
//
//    public AlaCarte() {}
//    public AlaCarte(int Price, String Description, int Time) {
//        this.Price = Price;
//        this.Description = Description;
//        this.Time = Time;
//    }
//
//    public int getID() { return ID;}
//
//    public void setID(int ID) { this.ID = ID; }
//
//    public int getPrice() { return Price; }
//
//    public void setPrice(int price) { Price = price; }
//
//    public String getDescription() { return Description; }
//
//    public void setDescription(String description) { Description = description; }
//
//    public int getTime() { return Time; }
//
//    public void setTime(int time) { Time = time; }
//
//}
//
//
