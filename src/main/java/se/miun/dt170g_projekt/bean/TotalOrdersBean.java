package se.miun.dt170g_projekt.bean;

import jakarta.persistence.EntityManager;
import se.miun.dt170g_projekt.entities.TotalOrdersEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;

public class TotalOrdersBean {

    EntityManager em;
    private ServletManager manager = null;

    public TotalOrdersBean() throws NamingException {
        manager = new ServletManager();
    }

    public void saveItem(TotalOrdersEntity data){
        manager.saveData(data);
    }
}
