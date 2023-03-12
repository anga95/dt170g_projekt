package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.miun.dt170g_projekt.bean.MenuItemsBean;
import se.miun.dt170g_projekt.bean.OrderItemsBean;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;
import se.miun.dt170g_projekt.entities.OrderItemsEntity;

import javax.naming.NamingException;
import javax.persistence.criteria.Order;
import java.util.List;


@Path("/OrderItems")
public class OrderItemsResource {

    EntityManager em;
    @Inject
    OrderItemsBean orderItemsBean;
    MenuItemsBean menuItemsBean;

    @GET
    @Path("/Json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MenuItemsEntity> getOrderItems(){
        return menuItemsBean.getMenuItems();
    }

    /*@POST
    @Path("/addOrderItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(OrderItemsEntity jsonOrder) {
        //MenuItemsEntity menuItems = new MenuItemsEntity();
        //Gson gson = new Gson();
        //OrderItemsEntity orderItemsEntity = gson.fromJson(jsonOrder, OrderItemsEntity.class);
        try {
            orderItemsBean = new OrderItemsBean();
            menuItemsBean = new MenuItemsBean();
            //MenuItemsEntity menuItems = menuItemsBean.find(jsonOrder.getMenuItemId());
            //jsonOrder.setId(menuItems.getId());
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        orderItemsBean.saveItem(jsonOrder);
    }*/

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteCarte(@PathParam("id") int id) {
        orderItemsBean.updateStatus(id);
        return "ok";
    }


    @POST
    @Path("/addOrderItems")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String jsonOrder) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonOrder, JsonObject.class);
        int menuItemId = jsonObject.get("menuItemId").getAsInt();
        OrderItemsEntity orderItemsEntity = null;
        MenuItemsEntity menuItem = em.find(MenuItemsEntity.class, menuItemId);
        orderItemsEntity.setMenuItemId(menuItem);
        //System.out.println(jsonOrder);
        //int value = jsonOrder.indexOf(0);
        //MenuItemsEntity menuItem = em.find(MenuItemsEntity.class, value);
        //OrderItemsEntity orderItemsEntity = null;
        //orderItemsEntity.setMenuItemId(menuItem);
        //Gson gson = new Gson();
        //OrderItemsEntity order = gson.fromJson(jsonOrder, OrderItemsEntity.class);
        //jsonOrder.setMenuItemId(jsonOrder.getMenuItemId());
        //jsonOrder.getMenuItemId();
        try {
            orderItemsBean = new OrderItemsBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        orderItemsBean.saveItem(orderItemsEntity);
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
