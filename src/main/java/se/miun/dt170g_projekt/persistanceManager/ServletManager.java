package se.miun.dt170g_projekt.persistanceManager;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entities.*;

import javax.naming.NamingException;
import java.util.List;


@Stateless
public class ServletManager {

    private static EntityManager em = null;

    public ServletManager() throws NamingException {
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

    public void updateStatus(int id ) {
        int deleteCount = em.createNamedQuery("OrderItems.updateStatus", OrderItemsEntity.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    public MenuItemsEntity findById(int id) {
        MenuItemsEntity menuItems = em.find(MenuItemsEntity.class ,id);
        em.close();
        return menuItems;
    }

    public static void removeEmployee(int id) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM EmployeeEntity WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
    public static void removeMenuItem(int id){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM MenuItemsEntity WHERE id = :id")
                .setParameter("id", id)
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

    public static List<MenuItemsEntity> getAllMenu() {
        TypedQuery<MenuItemsEntity> query = em.createQuery("SELECT e FROM MenuItemsEntity  e", MenuItemsEntity.class);
        List<MenuItemsEntity> menu = query.getResultList();
        return menu;
    }

    public static int findByName(String name) {
        MenuItemsEntity menuItems = em.find(MenuItemsEntity.class, name);
        int id = menuItems.getId();
        em.close();
        return id;
    }
}
