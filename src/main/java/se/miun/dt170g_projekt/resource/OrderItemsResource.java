package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g_projekt.bean.OrderItemsBean;
import se.miun.dt170g_projekt.entities.OrderItemsEntity;

import javax.naming.NamingException;

@Path("/OrderItems")
public class OrderItemsResource {
    @Inject
    OrderItemsBean orderItemsBean;

    /*@POST
    @Path("/addOrderItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String jsonOrder) {
        //MenuItemsEntity menuItems = new MenuItemsEntity();
        Gson gson = new Gson();
        OrderItemsEntity orderItemsEntity = gson.fromJson(jsonOrder, OrderItemsEntity.class);
        try {
            orderItemsBean = new OrderItemsBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        orderItemsBean.saveItem(orderItemsEntity);
    }*/

    @POST
    @Path("/addOrderItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrderItemsEntity jsonOrder) {
        //Gson gson = new Gson();
        //OrderItemsEntity orderItemsEntity = gson.fromJson(jsonOrder, OrderItemsEntity.class);
        try {
            orderItemsBean = new OrderItemsBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        orderItemsBean.saveItem(jsonOrder);
    }

    /*@POST
    @Path("/addOrderItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String jsonOrder) {
        Gson gson = new Gson();
        OrderItemsEntity test = gson.fromJson(jsonOrder, OrderItemsEntity.class);
        int menuItemId = test.getMenuItemId();
        //int quantity = gson.fromJson(jsonOrder, OrderItemsEntity.class).getQuantity();
        //int tableNr = gson.fromJson(jsonOrder, OrderItemsEntity.class).getTableNr();
        OrderItemsEntity orderItemsEntity = new OrderItemsEntity();
        orderItemsEntity.setMenuItemId(menuItemId);
        //orderItemsEntity.setQuantity(quantity);
        //orderItemsEntity.setTableNr(tableNr);
        //OrderItemsEntity[] orderItemsEntities = gson.fromJson(jsonOrder, OrderItemsEntity[].class);
        try {
            orderItemsBean = new OrderItemsBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        orderItemsBean.saveItem(orderItemsEntity);
    }*/

    /*@POST
    @Path("/addOrderItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrderItemsEntity jsonOrder) {
        Gson gson = new Gson();
        OrderItemsEntity orderItemsEntities = gson.fromJson(jsonOrder, OrderItemsEntity.class);
        try {
            orderItemsBean = new OrderItemsBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        for (OrderItemsEntity orderItemsEntity : orderItemsEntities) {
            orderItemsEntity.setMenuItemId(orderItemsEntity.getMenuItemId());
            orderItemsEntity.setQuantity(orderItemsEntity.getQuantity());
            orderItemsEntity.setTableNr(orderItemsEntity.getTableNr());
            orderItemsBean.saveItem(orderItemsEntity);
        }
    }*/

}
