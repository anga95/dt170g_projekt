package martin_test.deeper.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;
import martin_test.deeper.entities.Drinks;

import java.util.List;

@RequestScoped
@Named
public class DrinksBean {
    @PersistenceContext(unitName = "default")
    EntityManager em;

    public List<Drinks> getDrinks(){
        TypedQuery<Drinks> drinksList = em.createNamedQuery("drinks.selectAll", Drinks.class);
        return drinksList.getResultList();
    }

    public Drinks create(Drinks drink){
        em.persist(drink);
        return drink;
    }

    public void deleteDrink(int id) {
        TypedQuery<Drinks> drinkList = em.createNamedQuery("drinks.remove", Drinks.class);
        drinkList.setParameter("id",id);
        drinkList.executeUpdate();
    }
}
