
package se.miun.dt170g_projekt.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class MenuItemsBean {
    EntityManager em;
    private ServletManager manager = null;

    public MenuItemsBean() throws NamingException {
        manager = new ServletManager();
    }

    public List<MenuItemsEntity> getMenuItems() {
        return ServletManager.getAllMenu();
    }

    public MenuItemsEntity create(MenuItemsEntity mi) {
        em.persist(mi);
        return mi;
    }

    public MenuItemsEntity findById(int id) {
        MenuItemsEntity menuItems = manager.findById(id);
        return menuItems;
    }

    public void saveItem(MenuItemsEntity data){
        manager.saveData(data);
    }

}
