package martin_test.deeper.pm;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.NamingException;

import jakarta.persistence.PersistenceContext;
import martin_test.deeper.entities.MenuItems;

@Stateless
public class Manager {

    private static EntityManager em = null;

    public Manager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
        em = emf.createEntityManager();
    }

    public void saveData(MenuItems Data) {
        em.getTransaction().begin();
        em.persist(Data);
        em.getTransaction().commit();
    }
}
