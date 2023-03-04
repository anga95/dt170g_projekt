//package martin_test.deeper.web;
//
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Named;
//import jakarta.persistence.*;
//import martin_test.deeper.entities.Starters;
//
//import java.util.List;
//
//@RequestScoped
//@Named//kanske behöver ta bort för andreas employee_pm har inte named
//public class StartersBean {
//    @PersistenceContext(unitName = "default")
//    EntityManager em;
//
//    public List<Starters> getStarters(){
//        TypedQuery<Starters> startersList = em.createNamedQuery("starters.selectAll", Starters.class);
//        return startersList.getResultList();
//    }
//
//    public Starters create(Starters starter){
//        em.persist(starter);
//        return starter;
//    }
//
//    public void deleteStarter(int id) {
//        TypedQuery<Starters> starterList = em.createNamedQuery("starters.remove", Starters.class);
//        starterList.setParameter("id",id);
//        starterList.executeUpdate();
//    }
//}
