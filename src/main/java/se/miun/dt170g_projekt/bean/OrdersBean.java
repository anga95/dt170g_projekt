package se.miun.dt170g_projekt.bean;

import jakarta.persistence.EntityManager;
import se.miun.dt170g_projekt.entities.OrdersEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;

public class OrdersBean {

    EntityManager em;
    private ServletManager manager = null;

    public OrdersBean() throws NamingException {
        manager = new ServletManager();
    }

    public void saveItem(OrdersEntity data){
        manager.saveData(data);
    }
}