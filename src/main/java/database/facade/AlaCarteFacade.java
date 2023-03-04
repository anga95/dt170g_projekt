//package database.facade;
//
//import database.entities.AlaCarte2;
//import jakarta.ejb.Stateless;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//
//@Stateless
//public class AlaCarteFacade extends AbstractFacade<AlaCarte2> {
//    @PersistenceContext(unitName = "default")
//    public EntityManager em;
//
//    public AlaCarteFacade(){
//        super(AlaCarte2.class);
//    }
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
//
//
//    public void createAlaCarte(){
//        create(new AlaCarte2(100, "desc", 10));
//    }
//
//    public void createAlaCarte(AlaCarte2 alc2) {
//        create(alc2);
//    }
//
//    public void getList(){
//        //em.find()
//        //em.find(alc.findAll())
//
//
//
//    }
//
//    public void deleteAlaCarte(int alcID){
//        AlaCarte2 alc = find(alcID);
//        remove(alc);
//    }
//
//
//}
