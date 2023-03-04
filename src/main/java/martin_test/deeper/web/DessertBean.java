//package martin_test.deeper.web;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Named;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.TypedQuery;
//import martin_test.deeper.entities.Dessert;
//
//import java.util.List;
//
//@RequestScoped
//@Named
//public class DessertBean {
//
//    @PersistenceContext(unitName = "default")
//    EntityManager em;
//
//    public List<Dessert> getDesserts() {
//        TypedQuery<Dessert> dessertList = em.createNamedQuery("dessert.selectAll", Dessert.class);
//        return dessertList.getResultList();
//    }
//
//
//    public Dessert create(Dessert dessert) {
//        em.persist(dessert);
//        return dessert;
//    }
//
//    public void deleteDessert(int id) {
//        TypedQuery<Dessert> dessertList = em.createNamedQuery("dessert.remove", Dessert.class);
//        dessertList.setParameter("id", id);
//        dessertList.executeUpdate();
//    }
//}
//
//
//
//
//
