package se.miun.dt170g_projekt.bean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import se.miun.dt170g_projekt.entities.MenuItemsEntity;
import se.miun.dt170g_projekt.entities.OrderItemsEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class OrderItemsBean {
    private ServletManager manager = null;
    private EntityManager em;

    public OrderItemsBean() throws NamingException {
        manager = new ServletManager();
    }



    public void saveItem(OrderItemsEntity data){
        manager.saveData(data);
    }

    public String updateStatus(int id){
        manager.updateStatus(id);
        return "ok";
    }
}
