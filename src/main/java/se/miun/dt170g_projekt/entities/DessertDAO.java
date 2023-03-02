package se.miun.dt170g_projekt.entities;

import java.util.List;

public interface DessertDAO {
    List<Dessert> getAllDesserts();
    Dessert getDessertById(int id);
    void createDessert(Dessert dessert);
    void updateDessert(int id, Dessert dessert);
    void deleteDessert(int id);
}

