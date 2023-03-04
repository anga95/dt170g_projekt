//package martin_test.deeper.web;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Named;
//import jakarta.persistence.*;
//import martin_test.deeper.entities.AlaCarte;
//
//import java.util.List;
//
//@RequestScoped
//@Named
//public class AlaCarteBean {
//    @PersistenceContext(unitName = "default")
//    EntityManager em;
//
//    public List<AlaCarte> getAlaCarte(){
//        TypedQuery<AlaCarte> alcList = em.createNamedQuery("alc.selectAll", AlaCarte.class);
//        return alcList.getResultList();
//    }
//
//    public AlaCarte create(AlaCarte alc){
//        em.persist(alc);
//        return alc;
//    }
//
//    public void deleteCarte(int id) {
//        TypedQuery<AlaCarte> alcList = em.createNamedQuery("alc.remove", AlaCarte.class);
//        alcList.setParameter("id",id);
//        alcList.executeUpdate();
//    }
//}