package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g_projekt.bean.OrdersBean;
import se.miun.dt170g_projekt.bean.TotalOrdersBean;
import se.miun.dt170g_projekt.entities.TotalOrdersEntity;

import javax.naming.NamingException;

@Path("/TotalOrders")
public class TotalOrdersResource {
    @Inject
    TotalOrdersBean totalOrdersBean;

    @POST
    @Path("/addOrders")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String jsonOrder) {
        Gson gson = new Gson();
        int value = gson.fromJson(jsonOrder, int.class);
        TotalOrdersEntity totalOrdersEntity = new TotalOrdersEntity();
        try {
            totalOrdersBean = new TotalOrdersBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        totalOrdersBean.saveItem(totalOrdersEntity);
    }
}
