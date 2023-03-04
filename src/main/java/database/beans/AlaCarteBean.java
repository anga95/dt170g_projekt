//package database.beans;
//
//import database.entities.*;
//import jakarta.ejb.EJB;
//import jakarta.ejb.Stateless;
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Named;
//import jakarta.persistence.*;
//
//import java.beans.JavaBean;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.io.Serializable;
//import java.util.List;
//
//import static java.lang.System.*;
//import static java.lang.System.out;
//
//@Named(value="alacartebean")
//@RequestScoped
//public class AlaCarteBean implements Serializable {
////    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
////    @PersistenceContext
////    static EntityManager em = emf.createEntityManager();
//    @PersistenceContext(unitName = "default")
//    EntityManager em;
//
//    public void save(AlaCarte alc) {
//        em.persist(alc);
//    }
//
//    public List<AlaCarte> findAll() {
//        return em.createNamedQuery("alc.selectAll", AlaCarte.class).getResultList();
//    }
//
//
//
//    public int getFirstAlaCarte(){
//        PrintStream out = System.out;
//        return 0;
//    }
//
//    public int getAlaCarteCount(){
//        TypedQuery<AlaCarte> alcQuery = em.createNamedQuery("alc.selectAll", AlaCarte.class);
//        List<AlaCarte> resultList = alcQuery.getResultList();
//        return resultList.size();
//    }
//
//    public AlaCarte addAlaCarte(AlaCarte alc){
//        em.getTransaction().begin();
//        em.persist(alc);
//        em.getTransaction().commit();
//        return alc;
//    }
//
//    public AlaCarte findById(int id) {
//        return em.find(AlaCarte.class, id);
//    }
//
//}
