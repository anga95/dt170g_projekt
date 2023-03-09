/*
package se.miun.dt170g_projekt.persistanceManager;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.NamingException;

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
}
*/
