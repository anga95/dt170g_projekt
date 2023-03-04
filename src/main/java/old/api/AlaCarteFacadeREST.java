//package old.api;
//
//import jakarta.ejb.Stateless;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import old.entities.AlaCarte;
//import java.util.List;
//
//@Stateless
//@Path("entities.AlaCarte")
//public class AlaCarteFacadeREST extends AbstractFacade<AlaCarte> {
//
//    @PersistenceContext(unitName = "default")
//    private EntityManager em;
//
//
//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(AlaCarte alc){
//        super.create(alc);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Integer id, AlaCarte alc) {
//        super.edit(alc);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") int id){
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public AlaCarte find(@PathParam("id") int id){
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<AlaCarte> findAll(){
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<AlaCarte> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
//
//    @Override
//    protected EntityManager getEntityManager() { return null; }
//}
