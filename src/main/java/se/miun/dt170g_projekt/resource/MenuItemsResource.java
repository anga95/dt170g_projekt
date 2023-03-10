package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;
import java.util.List;

import se.miun.dt170g_projekt.bean.EmployeeBean;
import se.miun.dt170g_projekt.bean.MenuItemsBean;
import se.miun.dt170g_projekt.entities.EmployeeEntity;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;

import javax.naming.NamingException;


@Path("/MenuItems")
public class MenuItemsResource {
    @Inject
    MenuItemsBean menuItemsBean;

    @GET
    @Path("/Json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MenuItemsEntity> getMenuItems(){
        return menuItemsBean.getMenuItems();
    }

    @GET
    @Path("/Print")
    @Produces(MediaType.APPLICATION_JSON)
    public String print(){
        List<MenuItemsEntity> menuItemsList = menuItemsBean.getMenuItems();
        String result ="";
        for (MenuItemsEntity m: menuItemsList) {
            result += m;
        }
        return result;
    }

    /*@POST
    @Path("/addOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String jsonOrder){
        //MenuItemsEntity menuItems = new MenuItemsEntity();
        Gson gson = new Gson();
        MenuItemsEntity menuItems = gson.fromJson(jsonOrder, MenuItemsEntity.class);
        try {
            menuItemsBean = new MenuItemsBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        menuItemsBean.saveItem(menuItems);

    }*/

    /*@POST
    @Path("/Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertMenuItem(MenuItemsEntity menuItem) throws NamingException {
        menuItemsBean = new MenuItemsBean();
        menuItemsBean.saveItem(menuItem);*/
        /* //System.out.println("/INSERT REACHED");
        MenuItemsEntity menuItems = new MenuItemsEntity();
        //System.out.println("/SUCCESSFULLY CREATED IM");
        menuItems.setDescription("TEST LYCKADES");
        menuItems.setPrice(300);
        ServletManager manager = null;
        try{
            manager = new ServletManager();
            //System.out.println("MANAGER REACHED");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("OUTSIDE REACHED");
        manager.saveData(menuItems);*/
    //}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String toPrint(String menuItem){
        return menuItem + "post funkar";
    }

    @GET
    @Path("/findbyid")
    public MenuItemsEntity findById(int id){
        return menuItemsBean.findById(id);
    }

    /*@DELETE
    public void delete(int id){
        menuItemsBean.deleteMenuItems(id);
    }*/
}

