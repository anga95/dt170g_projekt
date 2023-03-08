package se.miun.dt170g_projekt.bean;
import jakarta.ejb.Stateless;
import se.miun.dt170g_projekt.entities.*;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;

import javax.naming.NamingException;

@Stateless
public class EmployeeBean {

    private ServletManager manager = null;
    public EmployeeBean() throws NamingException {
        manager = new ServletManager();
    }
    public void saveEmp(EmployeeEntity data){
        manager.saveData(data);
    }
}


