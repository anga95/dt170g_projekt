package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g_projekt.bean.OrdersBean;
import se.miun.dt170g_projekt.bean.TotalOrdersBean;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;
import se.miun.dt170g_projekt.entities.TotalOrdersEntity;

import javax.naming.NamingException;
import java.util.List;

@Path("/TotalOrders")
public class TotalOrdersResource {
    @Inject
    TotalOrdersBean totalOrdersBean;

    @GET
    @Path("/Json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TotalOrdersEntity> getMenuItems(){return totalOrdersBean.getOrderItems();}

    @POST
    @Path("/addOrders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String jsonOrder) {
        Gson gson = new Gson();
        TotalOrdersEntity[] orders = gson.fromJson(jsonOrder, TotalOrdersEntity[].class);

        for (TotalOrdersEntity order : orders) {
            TotalOrdersEntity totalOrdersEntity = new TotalOrdersEntity();
            totalOrdersEntity.setTableNr(order.getTableNr());
            totalOrdersEntity.setName(order.getName());
            totalOrdersEntity.setCategory(order.getCategory());
            totalOrdersEntity.setQuantity(order.getQuantity());
            totalOrdersEntity.setNote(order.getNote());
            totalOrdersEntity.setTime(order.getTime());
            totalOrdersEntity.setStatus(order.getStatus());
            // set other properties
            totalOrdersBean.saveItem(totalOrdersEntity);
        }

        return Response.ok().build();
    }

    /*@POST
    @Path("/addOrders")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String jsonOrder) {
        Gson gson = new Gson();
        TotalOrdersEntity totalOrdersEntity = gson.fromJson(jsonOrder, TotalOrdersEntity.class);
        TotalOrdersEntity test = new TotalOrdersEntity();
        test.setTableNr(totalOrdersEntity.getTableNr());
        totalOrdersBean.saveItem(totalOrdersEntity);
        return Response.ok().build();
    }*/
}
