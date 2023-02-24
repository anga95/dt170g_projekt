package se.miun.dt170g_projekt.api_resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test")
public class TestResource {

    @GET
    public String test() {
        return "Hello World";
    }
}
