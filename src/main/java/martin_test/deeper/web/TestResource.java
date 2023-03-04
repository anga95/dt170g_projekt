package martin_test.deeper.web;

import jakarta.persistence.Entity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class TestResource {

    @GET
    public String test( ){
        return "Hekki world";
    }

}
