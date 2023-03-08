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
    @PersistenceContext(name = "default")
    EntityManager emTest;

    public Manager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public void saveData(MenuItems Data) {
        //em.getTransaction().begin();
        /*try {
            em.persist(Data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        //em.getTransaction().commit();
        emTest.persist(Data);
    }
}
