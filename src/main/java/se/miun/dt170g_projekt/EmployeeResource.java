package se.miun.dt170g_projekt;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import se.miun.dt170g_projekt.persistanceManager.Manager;
import se.miun.dt170g_projekt.entites.EmployeeEntity;

import javax.naming.NamingException;

@Path("/employee")
public class EmployeeResource {
    @Inject
    EmployeeBean manage;

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(EmployeeEntity employee) throws NamingException {
        try{
            manage = new EmployeeBean();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        manage.saveEmp(employee);
    }

}

