package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g_projekt.bean.OrdersBean;
import se.miun.dt170g_projekt.entities.OrdersEntity;

import javax.naming.NamingException;

@Path("/Orders")
public class OrdersResource {
    @Inject
    OrdersBean ordersBean;

    @POST
    @Path("/addOrders")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String jsonOrder) {
        Gson gson = new Gson();
        int value = gson.fromJson(jsonOrder, int.class);
        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setTableNr(value);
        try {
            ordersBean = new OrdersBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        ordersBean.saveItem(ordersEntity);
    }
}
