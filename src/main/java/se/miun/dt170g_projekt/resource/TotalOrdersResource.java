package se.miun.dt170g_projekt.resource;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
    public Response create(String jsonOrder) {
        Gson gson = new Gson();
        TotalOrdersEntity totalOrdersEntity = gson.fromJson(jsonOrder, TotalOrdersEntity.class);
        TotalOrdersEntity test = new TotalOrdersEntity();
        test.setTableNr(totalOrdersEntity.getTableNr());
        totalOrdersBean.saveItem(totalOrdersEntity);
        return Response.ok().build();
    }
}
