package se.miun.dt170g_projekt.persistanceManager;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.NamingException;
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
        return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e", type).getResultList();
    }

    public <T> T getById(Class<T> type, int id) {
        return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e WHERE e.id = :id", type)
                .setParameter("id", id)
                .getSingleResult();
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

    public <T> T getByColumnName(Class<T> type, String columnName, String value) {
        return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e WHERE e." + columnName + " = :value", type)
                .setParameter("value", value)
                .getSingleResult();
    }

    public <T, U, X> List<X> getJoinedTables(Class<T> table1, Class<U> table2, String column1, String column2, Class<X> returnType) {
        return em.createNativeQuery("SELECT * FROM " + table1.getSimpleName() + " JOIN " + table2.getSimpleName() + " ON " + table1.getSimpleName() + "." + column1 + " = " + table2.getSimpleName() + "." + column2, returnType)
                .getResultList();
    }
}
