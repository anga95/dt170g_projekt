package se.miun.dt170g_projekt.persistanceManager;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entites.BookingEntity;
import se.miun.dt170g_projekt.entites.DailyLunchEntity;
import se.miun.dt170g_projekt.entites.EmployeeEntity;
import se.miun.dt170g_projekt.entites.PrefoodEntity;

import javax.naming.NamingException;
import java.util.List;


@Stateless
public class Manager {

    private static EntityManager em = null;

    public Manager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }
    public <T> void saveData(T Data) {
        em.getTransaction().begin();
        em.persist(Data);
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
    public BookingEntity getBookingById(int id) {
        BookingEntity booking = em.find(BookingEntity.class, id);
        em.close();
        return booking;
    }
    public DailyLunchEntity getDailyById(int id) {
        DailyLunchEntity Daily = em.find(DailyLunchEntity.class, id);
        em.close();
        return Daily;
    }
    public List<BookingEntity> getAllBookings() {
        TypedQuery<BookingEntity> query = em.createQuery("SELECT e FROM BookingEntity  e", BookingEntity.class);
        List<BookingEntity> bookings = query.getResultList();
        return bookings;
    }
    public static List<EmployeeEntity> getAllEmployee() {
        TypedQuery<EmployeeEntity> query = em.createQuery("SELECT e FROM EmployeeEntity  e", EmployeeEntity.class);
        List<EmployeeEntity> employee = query.getResultList();
        return employee;
    }

    public static List<DailyLunchEntity> getAllDaily() {
        TypedQuery<DailyLunchEntity> query = em.createQuery("SELECT e FROM DailyLunchEntity  e", DailyLunchEntity.class);
        List<DailyLunchEntity> Daily = query.getResultList();
        return Daily;
    }

    public List<PrefoodEntity> getAllPrefood() {
        TypedQuery<PrefoodEntity> query = em.createQuery("SELECT e FROM PrefoodEntity  e", PrefoodEntity.class);
        List<PrefoodEntity> prefood = query.getResultList();
        return prefood;
    }
}
