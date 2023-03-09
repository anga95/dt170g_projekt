package se.miun.dt170g_projekt.persistanceManager;

import jakarta.ejb.Stateless;
//import jakarta.json.JsonArray;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
//import jakarta.persistence.metamodel.Attribute;
//import org.json.JSONObject;

import javax.naming.NamingException;
//import java.util.ArrayList;
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

    public <T> T getByColumnName(Class<T> type, String columnName, String value) {
        return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e WHERE e." + columnName + " = :value", type)
                .setParameter("value", value)
                .getSingleResult();
    }

    // join two tables by given columns and return the result as a json string
//    public <T, U> Object getJoinedTables(Class<T> table1, Class<U> table2, String column1, String column2) {
//        return em.createNativeQuery("SELECT * FROM " + table1.getSimpleName() + " JOIN " + table2.getSimpleName() + " ON " + table1.getSimpleName() + "." + column1 + " = " + table2.getSimpleName() + "." + column2)
//                .getResultList();
        // save result in a list
//        List resultList = em.createNativeQuery("SELECT * FROM " + table1.getSimpleName() + " JOIN " + table2.getSimpleName() + " ON " + table1.getSimpleName() + "." + column1 + " = " + table2.getSimpleName() + "." + column2)
//                .getResultList();
//
//        List<String> tablesAttributes = new ArrayList<>();
//        // for each attribute in table1, add it to the list
//        List<Attribute<?, ?>> attributes = new ArrayList<>(em.getMetamodel().entity(table1).getAttributes());
//        List<Attribute<?, ?>> attributes2 = new ArrayList<>(em.getMetamodel().entity(table2).getAttributes());
//        for (int i = 0; i < attributes.size(); i++) {
//            tablesAttributes.add(attributes.get(i).getName());
//        }
//        for (int i = 0; i < attributes2.size(); i++) {
//            tablesAttributes.add(attributes2.get(i).getName());
//        }
//
//        // loop through the list and create json object with column names as keys and values as values
//        ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
//        for (Object o : resultList) {
//            Object[] row = (Object[]) o;
//            JSONObject jsonObject = new JSONObject();
//            for (int i = 0; i < tablesAttributes.size(); i++) {
//                jsonObject.put(tablesAttributes.get(i), row[i]);
//            }
//            jsonList.add(jsonObject);
//        }
//
//        return jsonList;
//    }
}
