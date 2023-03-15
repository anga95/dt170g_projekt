package se.miun.dt170g_projekt.persistanceManager;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entities.ExtraDay;
import se.miun.dt170g_projekt.entities.LeaveDay;

import javax.naming.NamingException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class Manager {
    private static EntityManager em = null;

    public Manager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }

    public <T> void create(T Data) {
        em.getTransaction().begin();
        em.persist(Data);
        em.getTransaction().commit();
    }

    public <T> List<T> getAll(Class<T> type) {
        em.getTransaction().begin();
        // serialize the query to a string
        String query = "SELECT e FROM " + type.getSimpleName() + " e";
        // create the query
        TypedQuery<T> q = em.createQuery(query, type);
        // execute the query
        List<T> result = q.getResultList();
        em.getTransaction().commit();
        return result;
    }

    public <T> T getById(Class<T> type, int id) {
//        return em.createQuery("SELECT e FROM " +
//                        type.getSimpleName() +
//                        " e WHERE e.id = :id", type)
//                .setParameter("ID", id)
//                .getSingleResult();
        return em.find(type, id);
    }

    public <T> void update(T Data) {
        em.getTransaction().begin();
        em.merge(Data);
        em.getTransaction().commit();
    }

    public <T> void delete(T Data) {
        em.getTransaction().begin();
        em.remove(Data);
        em.getTransaction().commit();
    }


//    public <T> T getById(Class<T> type, String value) {
//        try {
//            return em.createQuery("SELECT e FROM " +
//                            type.getSimpleName() + " e WHERE e.id = '" + value + "'", type)
//                    .getSingleResult();
//        } catch (NoResultException | NonUniqueResultException e) {
//            return null; // or throw a custom exception
//        }
//    }

    public <T> T getByEmail(Class<T> type, String value) {
        try {
            return em.createQuery("SELECT e FROM " +
                            type.getSimpleName() + " e WHERE e.email = '" + value + "'", type)
                    .getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null; // or throw a custom exception
        }

    }

    public <T, U, X> List<X> getJoinedTables(Class<T> table1,
                                             Class<U> table2,
                                             String column1,
                                             String column2,
                                             Class<X> returnType) {
        return em.createNativeQuery("SELECT * FROM " +
                        table1.getSimpleName() +
                        " JOIN " +
                        table2.getSimpleName() +
                        " ON " +
                        table1.getSimpleName() +
                        "." +
                        column1 +
                        " = " +
                        table2.getSimpleName() +
                        "." +
                        column2, returnType)
                .getResultList();
    }

    public <T> List<LeaveDay> getLeaves(Class<T> type, String datum) {
        LocalDate localDate = LocalDate.parse(datum);
        java.sql.Date start = java.sql.Date.valueOf(localDate.withDayOfMonth(1));
        java.sql.Date end = java.sql.Date.valueOf(localDate.withDayOfMonth(localDate.lengthOfMonth()));
        em.getTransaction().begin();
        List<LeaveDay> result = em.createQuery("SELECT l FROM " + type.getSimpleName() + " l WHERE l.leaveDate BETWEEN :start AND :end", LeaveDay.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
        em.getTransaction().commit();
        return result;
    }

    public <T> List<ExtraDay> getExtras(Class<T> type, String datum) {
        LocalDate localDate = LocalDate.parse(datum);
        java.sql.Date start = java.sql.Date.valueOf(localDate.withDayOfMonth(1));
        java.sql.Date end = java.sql.Date.valueOf(localDate.withDayOfMonth(localDate.lengthOfMonth()));
        em.getTransaction().begin();
        List<ExtraDay> result = em.createQuery("SELECT l FROM " + type.getSimpleName() + " l WHERE l.extraDate BETWEEN :start AND :end", ExtraDay.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
        em.getTransaction().commit();
        return result;
    }

    public LeaveDay getLeaveByDateAndEmp(Class<LeaveDay> leaveDayClass, Date leaveDate, int empId) {
        try {
            return em.createQuery("SELECT l FROM " + leaveDayClass.getSimpleName() + " l WHERE l.leaveDate = :leaveDate AND l.empId = :empId", LeaveDay.class)
                    .setParameter("leaveDate", leaveDate)
                    .setParameter("empId", empId)
                    .getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null; // or throw a custom exception
        }
    }

    public ExtraDay getExtraByDateAndEmp(Class<ExtraDay> extraDayClass, Date extraDate, int empId) {
        try {
            return em.createQuery("SELECT l FROM " + extraDayClass.getSimpleName() + " l WHERE l.extraDate = :extraDate AND l.empId = :empId", ExtraDay.class)
                    .setParameter("extraDate", extraDate)
                    .setParameter("empId", empId)
                    .getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null; // or throw a custom exception
        }
    }
}
