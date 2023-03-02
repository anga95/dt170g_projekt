package se.miun.dt170g_projekt.services;

import se.miun.dt170g_projekt.entities.Dessert;
import se.miun.dt170g_projekt.entities.DessertDAO;
import se.miun.dt170g_projekt.persistanceManager.DessertDAOImpl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class DessertService {

    @Inject
    private DessertDAO dessertDAO;

    public List<Dessert> getAllDesserts() {
        return dessertDAO.getAllDesserts();
    }

    public Dessert getDessertById(int id) {
        return dessertDAO.getDessertById(id);
    }

    public void createDessert(Dessert dessert) {
        dessertDAO.createDessert(dessert);
    }

    public void updateDessert(int id, Dessert dessert) {
        dessertDAO.updateDessert(id, dessert);
    }

    public void deleteDessert(int id) {
        dessertDAO.deleteDessert(id);
    }
}
