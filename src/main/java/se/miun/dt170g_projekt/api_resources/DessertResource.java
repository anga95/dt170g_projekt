package martin_test.deeper.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.*;

import java.util.List;

@Path("/Dessert")
public class DessertResource {

    @Inject
    DessertBean dessertBean;

    @GET//utan path körs när ,man kör http://localhost:8080/dt170g_projekt-1.0-SNAPSHOT/api/Dessert
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dessert> getDesserts(){
        return dessertBean.getDesserts();
    }
    @GET
    @Path("/print")
    @Produces(MediaType.APPLICATION_JSON)
    public String print(){
        List<Dessert> resultList = dessertBean.getDesserts();
        String result = "DESSERTS, \n" ;
        result += resultList.get(0).toString();
        result += resultList.get(1);
        result += resultList.get(2).toString();
        return result;
    }
    @GET
    @Path("/printAll")
    @Produces("text/plain")
    public String printAll(){
        List<Dessert> resultList = dessertBean.getDesserts();
        String result = "DESSERTS, \n" ;
        for (Dessert ds: resultList) {
            result += ds;

        }
        return result;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Dessert create(Dessert dessert){
        return dessertBean.create(dessert);
    }

    @DELETE
    public void delete(int id){
        dessertBean.deleteDessert(id);
    }
}
