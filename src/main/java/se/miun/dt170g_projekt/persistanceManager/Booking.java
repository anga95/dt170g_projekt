package se.miun.dt170g_projekt.persistanceManager;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entites.BookingEntity;
import se.miun.dt170g_projekt.entites.DailyLunchEntity;
import javax.naming.NamingException;
import java.util.List;

@Stateless
public class Booking {

    private final EntityManager em;

    public Booking() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }
    public void saveBooking(BookingEntity book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }
    public BookingEntity getBookingById(int id) {
        BookingEntity booking = em.find(BookingEntity.class, id);
        em.close();
        return booking;
    }
    public List<BookingEntity> getAllBookings() {
        TypedQuery<BookingEntity> query = em.createQuery("SELECT e FROM BookingEntity  e", BookingEntity.class);
        List<BookingEntity> bookings = query.getResultList();
        return bookings;
    }
}
