//package martin_test.deeper.web;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import martin_test.deeper.entities.*;
//
//import java.util.List;
//
//@Path("/AlaCarte")
//public class AlaCarteResource {
//
//    @Inject AlaCarteBean alaCarteBean;
//
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<AlaCarte> getAlaCarte(){
//        return alaCarteBean.getAlaCarte();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public AlaCarte create(AlaCarte alc){
//        return alaCarteBean.create(alc);
//    }
//
//    @DELETE
//    public void delete(int id){
//        alaCarteBean.deleteCarte(id);
//    }
//
//}
