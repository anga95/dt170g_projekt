package se.miun.dt170g_projekt;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import se.miun.dt170g_projekt.entites.*;
import se.miun.dt170g_projekt.persistanceManager.Manager;

import javax.naming.NamingException;
import java.util.List;

@Stateless
public class EmployeeBean {

    private Manager manager = null;
    public EmployeeBean() throws NamingException {
        manager = new Manager();
    }
    public void saveEmp(EmployeeEntity data){
        manager.saveData(data);
    }
}


