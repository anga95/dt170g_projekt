//package old.bean.core;
//
//import jakarta.inject.Inject;
//import old.entities.AlaCarte;
//import old.facade.AlaCarteFacade;
//import jakarta.ejb.EJB;
//import jakarta.enterprise.context.SessionScoped;
//import jakarta.inject.Named;
//import java.io.Serializable;
//import java.util.List;
//
//@Named(value = "alaCarteBean")
//@SessionScoped
//public class AlaCarteBean implements Serializable {
//
//    @EJB
//    private AlaCarteFacade alcFacade;
//
//    public List<AlaCarte> alaCarteList(){
//        return alcFacade.findAll();
//    }
//    public void remove(int id){
//        alcFacade.remove(alcFacade.find(id));
//
//    }
//
//}
