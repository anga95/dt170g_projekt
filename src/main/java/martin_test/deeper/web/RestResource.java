//package martin_test.deeper.web;
//
//import jakarta.inject.Inject;
//import jakarta.ws.rs.ApplicationPath;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.Produces;
//import martin_test.deeper.entities.AlaCarte;
//import martin_test.deeper.entities.Dessert;
//
//import java.util.List;
//
//@Path("/Resource")
//public class RestResource {
//
//
//    @Inject AlaCarteBean alaCarteBean;
//    @Inject DessertBean dessertBean;
//
//    @GET
////    @Path("/AlaCarte")//lägger man tll path /AlaCarte här körs
//    @Produces("text/plain")
//    public String helloAlaCarte() {
//        final List<AlaCarte> resultList = alaCarteBean.getAlaCarte();
//        String result = "Hello, ";
//        if (resultList.isEmpty()) { result += "no names."; }
//        else {
//            for (AlaCarte alc : resultList) {
//                result += alc + "] -------- ";
//            }
//        }
//        return result;
//    }
//
//    @GET
////    @Path("/Dessert")//lägger man tll path /AlaCarte här körs
////    @Produces("text/plain")
//    public String helloDessert() {
//        final List<Dessert> resultList = dessertBean.getDesserts();
//        String result = "Hello, ";
//        if (resultList.isEmpty()) { result += "no names."; }
//        else {
//            for (Dessert dessert : resultList) {
//                result += dessert + "] -------- ";
//            }
//        }
//        return result;
//    }
//
//
//}
