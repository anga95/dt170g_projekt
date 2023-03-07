package martin_test.deeper.web;

//import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.json.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.MenuItems;
import martin_test.deeper.entities.OrderItems;
import org.eclipse.persistence.exceptions.JSONException;


import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public MenuItems create(MenuItems menuItem){
        return menuItemsBean.create(menuItem);
    }*/

    /*@POST
   @Consumes(MediaType.APPLICATION_JSON)
   public String toPrint(String menuItem){
       //return menuItemsBean.create(menuItem);
        return menuItem + "post funkar";
   }*/
    @DELETE
    public void delete(int id){
        menuItemsBean.deleteMenuItems(id);
    }

    /*@POST
    @Path("/Insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDataToTable(JsonObject jsonObject) {
        // set the values of the OrderItems object based on the JSON object
        OrderItems orderItems = new OrderItems();
        orderItems.setStatus(true);
        orderItems.setQuantity(jsonObject.getInt("price"));
        orderItems.setStatus(true);

        // persist the OrderItems object to the database
        EntityManager em = Persistence.createEntityManagerFactory("DB").createEntityManager();
        em.getTransaction().begin();
        em.persist(orderItems);
        em.getTransaction().commit();
    }*/

    @POST
    @Path("/Insert")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void postData(@FormParam("id") int id,
                         @FormParam("category") String category,
                         @FormParam("price") int price) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/DB", "APP", "APP")) {
            // Prepare the SQL statement
            String sql = "INSERT INTO MENU_ITEMS (id, category, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, category);
            statement.setInt(3, price);

            // Execute the statement
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
