
package se.miun.dt170g_projekt.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import java.util.List;

@Stateless
public class MenuItemsBean {
    EntityManager em;
    private final ServletManager manager = null;

    public List<MenuItemsEntity> getMenuItems() {
        return ServletManager.getAllMenu();
    }

    public MenuItemsEntity create(MenuItemsEntity mi) {
        em.persist(mi);
        return mi;
    }

    public void deleteMenuItems(int id) {
        TypedQuery<MenuItemsEntity> MenuItemsList = em.createNamedQuery("menuItems.remove", MenuItemsEntity.class);
        MenuItemsList.setParameter("id", id);
        MenuItemsList.executeUpdate();
    }

    public void saveItem(MenuItemsEntity data){
        manager.saveData(data);
    }

}
