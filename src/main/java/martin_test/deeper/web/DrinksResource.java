//package martin_test.deeper.web;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import martin_test.deeper.entities.*;
//
//import java.util.List;
//
//@Path("/Drinks")
//public class DrinksResource {
//
//    @Inject
//    DrinksBean drinksBean;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Drinks> getDrinks(){
//        return drinksBean.getDrinks();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Drinks create(Drinks drink){
//        return drinksBean.create(drink);
//    }
//
//    @DELETE
//    public void delete(int id){
//        drinksBean.deleteDrink(id);
//    }
//}
