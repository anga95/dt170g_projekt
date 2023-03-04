//package martin_test.deeper.web;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import martin_test.deeper.entities.*;
//
//import java.util.List;
//
//@Path("/Starters")
//public class StartersResource {
//
//    @Inject StartersBean startersBean;
//
//    @GET
//
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Starters> getStarters(){
//        return startersBean.getStarters();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Starters create(Starters starter){
//        return startersBean.create(starter);
//    }
//
//    @DELETE
//    public void delete(int id){
//        startersBean.deleteStarter(id);
//    }
//}
