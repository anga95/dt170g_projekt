package se.miun.dt170g_projekt.api_resources;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public class alacarteResource {

        @POST
        @Produces(MediaType.APPLICATION_JSON)
        public String alacarte() {
            return "Hello World";
        }
}
