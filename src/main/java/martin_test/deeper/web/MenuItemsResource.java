package martin_test.deeper.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.MenuItems;

import java.util.List;

@Path("/MenuItems")
public class MenuItemsResource {
    @Inject MenuItemsBean menuItemsBean;

    @POST
    @Path("/Create")
    @Consumes(MediaType.APPLICATION_JSON)
    public MenuItems create(MenuItems menuItem){
        return menuItemsBean.create(menuItem);
    }

    @POST
    @Path("/Skapa")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public MenuItems skapa(@FormParam("price") int price,
                           @FormParam("name") String name,
                           @FormParam("description") String description,
                           @FormParam("time") int time,
                           @FormParam("category") String category){
        MenuItems menuItems = new MenuItems(price, name, description, time, category);
        menuItemsBean.create(menuItems);
        return menuItems;
//        return menuItemsBean.create(menuItems);
    }
    @GET
    @Path("/Json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MenuItems> getMenuItems(){
        return menuItemsBean.getMenuItems();
    }

    @GET
    @Path("/Print")
    @Produces(MediaType.APPLICATION_JSON)
    public String print(){
        List<MenuItems> menuItemsList = menuItemsBean.getMenuItems();
        String result ="";
        for (MenuItems m: menuItemsList) {
            result += m;
        }
        return result;
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public MenuItems create(MenuItems menuItem){
//        return menuItemsBean.create(menuItem);
//    }

    @DELETE
    public void delete(int id){
        menuItemsBean.deleteMenuItems(id);
    }

}
