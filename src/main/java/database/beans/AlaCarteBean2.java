//package database.beans;
//
//import database.entities.AlaCarte2;
//import database.old.facade.AlaCarteFacade;
//import jakarta.ejb.EJB;
//import jakarta.enterprise.context.SessionScoped;
//import jakarta.inject.Named;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Named(value = "alacartebean2")
//@SessionScoped
//public class AlaCarteBean2 implements Serializable {
//
//    @EJB
//    private AlaCarteFacade alcFacade;
//
//    public List<AlaCarte2> alaCarte2List(){
//        AlaCarteFacade alcf = new AlaCarteFacade();
//        List<AlaCarte2> alc2List = alcf.findAll();
//        return alc2List;
//    }
//}
