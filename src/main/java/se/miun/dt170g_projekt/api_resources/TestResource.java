package se.miun.dt170g_projekt.api_resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import se.miun.dt170g_projekt.persistanceManager.Employee_pm;

@Path("/test")
public class TestResource {

    @Inject Employee_pm  employeePm ;

    @GET
    public String test() {
        return "Hello World";
    }
}
