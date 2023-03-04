package martin_test.deeper.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import martin_test.deeper.entities.Orders;

import java.util.List;

@Path("/Orders")
public class OrdersResource {

    @Inject
    OrdersBean ordersBean;

    @GET
    @Path("/Json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> getOrders(){
        return ordersBean.getOrders();
    }
    @GET
    @Path("/Print")
    @Produces(MediaType.APPLICATION_JSON)
    public String print(){
        List<Orders> ordersList = ordersBean.getOrders();
        String result ="";
        for (Orders o: ordersList) { result += o; }
        return result;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Orders create(Orders order){
        return ordersBean.create(order);
    }

    @DELETE
    public void delete(int id){
        ordersBean.deleteOrder(id);
    }

}