//package se.miun.dt170g_projekt;
//
//import database.beans.AlaCarteBean;
//import database.old.entities.AlaCarte;
//import jakarta.inject.Inject;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//
//import java.util.List;
//
////@Path("/")
//public class AlaCarteResource {
//
//    @Inject
//    AlaCarteBean alcBean;
//
//    @GET
//    public List<AlaCarte> findAll(){
//        return alcBean.findAll();
//    }
//    @POST
//    public AlaCarte addAlaCarte(AlaCarte alc){
//        alcBean.addAlaCarte(alc);
//        return alc;
//    }
//}
