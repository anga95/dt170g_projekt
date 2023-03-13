package se.miun.dt170g_projekt.bean;

import jakarta.persistence.EntityManager;
import se.miun.dt170g_projekt.entities.DailyLunchEntity;
import se.miun.dt170g_projekt.entities.TotalOrdersEntity;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;
import java.util.List;

public class DailyLunchBean {

    EntityManager em;
    private ServletManager manager = null;

    public DailyLunchBean() throws NamingException{
        manager = new ServletManager();
    }

    public void saveItem(TotalOrdersEntity data) {manager.saveData(data);}

    public List<DailyLunchEntity> getLunchItems() {
        return ServletManager.getAllDaily();
    }
}
