package martin_test.deeper.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import martin_test.deeper.entities.MenuItems;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class MenuItemsBean implements Serializable {
    @PersistenceContext(unitName = "default")
    EntityManager em;

    public List<MenuItems> getMenuItems() {
        TypedQuery<MenuItems> MenuItemsList = em.createNamedQuery("menuItems.selectAll", MenuItems.class);
        return MenuItemsList.getResultList();
    }


    public MenuItems create(MenuItems mi) {
        em.persist(mi);
        return mi;
    }

    public void deleteMenuItems(int id) {
        TypedQuery<MenuItems> MenuItemsList = em.createNamedQuery("menuItems.remove", MenuItems.class);
        MenuItemsList.setParameter("id", id);
        MenuItemsList.executeUpdate();
    }
}
