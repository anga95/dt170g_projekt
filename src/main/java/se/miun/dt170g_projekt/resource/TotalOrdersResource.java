package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g_projekt.bean.OrdersBean;
import se.miun.dt170g_projekt.bean.TotalOrdersBean;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;
import se.miun.dt170g_projekt.entities.TotalOrdersEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            totalOrdersEntity.setStatus(false);
            // set other properties
            totalOrdersBean.saveItem(totalOrdersEntity);
        }

        return Response.ok().build();
    }

    @POST
    @Path("/updateStarters")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStarters(String jsonString) throws NamingException {
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(jsonString, JsonArray.class);
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonArray orderIdArray = jsonObject.getAsJsonArray("order_id");
            for (JsonElement orderIdElement : orderIdArray) {
                int id = Integer.parseInt(orderIdElement.getAsString());
                new ServletManager().updateStatus(id);
            }
        }
        return Response.ok().build();
    }
}
