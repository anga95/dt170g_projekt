package martin_test.deeper.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import martin_test.deeper.entities.MenuItems;

import java.util.List;

@Named
@RequestScoped
public class MenuItemsBean {
    @PersistenceContext(unitName = "DB")
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
