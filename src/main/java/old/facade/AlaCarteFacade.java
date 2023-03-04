//package old.facade;
//
//
//import jakarta.inject.Inject;
//import old.entities.AlaCarte;
//import jakarta.ejb.Stateless;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//
//@Stateless
//public class AlaCarteFacade extends AbstractFacade<AlaCarte> {
//
//    @PersistenceContext(unitName = "default")
//    private EntityManager em;
//
//    //prova köra med inject här
////    public AlaCarteFacade(Class<AlaCarte> alc) {
////        super(alc);
////    }
//
//    public AlaCarteFacade(AlaCarte alaCarte) {
//        super(alaCarte);
//    }
//
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return null;
//    }
//
//
//    public void deleteAlaCarte(int id){
//        AlaCarte alc = find(id);
//        remove(alc);
//    }
//
//}
