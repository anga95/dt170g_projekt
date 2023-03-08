package martin_test.deeper.pm;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.naming.NamingException;

@Stateless
public class Manager {

    private static EntityManager em = null;

    public Manager() throws NamingException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public <T> void saveData(T Data) {
        //em.getTransaction().begin();
        try {
            em.persist(Data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //em.getTransaction().commit();
    }
}
