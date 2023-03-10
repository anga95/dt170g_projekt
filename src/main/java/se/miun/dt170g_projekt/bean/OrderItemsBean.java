package se.miun.dt170g_projekt.bean;

import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import se.miun.dt170g_projekt.entities.OrderItemsEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;

@Stateless
public class OrderItemsBean {
    private ServletManager manager = null;

    public OrderItemsBean() throws NamingException {
        manager = new ServletManager();
    }

    public void saveItem(OrderItemsEntity data){
        manager.saveData(data);
    }
}
