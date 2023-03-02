package se.miun.dt170g_projekt.persistanceManager;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entites.DailyLunchEntity;
import javax.naming.NamingException;
import java.util.List;

@Stateless
public class dailyLunchManager {

    private final EntityManager em;

    public dailyLunchManager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }
    public void saveDaily(DailyLunchEntity Daily) {
        em.getTransaction().begin();
        em.persist(Daily);
        em.getTransaction().commit();
    }
    public void changeLunch(DailyLunchEntity Daily) {
        em.getTransaction().begin();
        em.createQuery("UPDATE DailyLunchEntity SET lunch1 = :lunch1, lunch2 = :lunch2, lunch3 = :lunch3 WHERE weekday = :weekday")
                .setParameter("lunch1", Daily.getLunch1())
                .setParameter("lunch2", Daily.getLunch2())
                .setParameter("lunch3", Daily.getLunch3())
                .setParameter("weekday", Daily.getWeekday())
                .executeUpdate();
        em.getTransaction().commit();
    }
    public DailyLunchEntity getDailyById(int id) {
        DailyLunchEntity Daily = em.find(DailyLunchEntity.class, id);
        em.close();
        return Daily;
    }
    public List<DailyLunchEntity> getAllDaily() {
        TypedQuery<DailyLunchEntity> query = em.createQuery("SELECT e FROM DailyLunchEntity  e", DailyLunchEntity.class);
        List<DailyLunchEntity> Daily = query.getResultList();
        return Daily;
    }

}
