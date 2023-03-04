package martin_test.deeper.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.MenuItems;

import java.util.List;

@Path("/MenuItems")
public class MenuItemsResource {
    @Inject MenuItemsBean menuItemsBean;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public MenuItems create(MenuItems menuItem){
        return menuItemsBean.create(menuItem);
    }

    @DELETE
    public void delete(int id){
        menuItemsBean.deleteMenuItems(id);
    }

}
