package se.miun.dt170g_projekt.persistanceManager;

import se.miun.dt170g_projekt.entities.Dessert;
import se.miun.dt170g_projekt.entities.DessertDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DessertDAOImpl implements DessertDAO {
    private final Connection connection;

    public DessertDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Dessert> getAllDesserts() {
        List<Dessert> desserts = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM APP.DESSERT");
            while (resultSet.next()) {
                Dessert dessert = new Dessert();
                dessert.setId(resultSet.getInt("ID"));
                dessert.setPrice(resultSet.getInt("Price"));
                dessert.setDescription(resultSet.getString("Description"));
                desserts.add(dessert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return desserts;
    }

    @Override
    public Dessert getDessertById(int id) {
        Dessert dessert = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM APP.DESSERT WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dessert = new Dessert();
                dessert.setId(resultSet.getInt("ID"));
                dessert.setPrice(resultSet.getInt("Price"));
                dessert.setDescription(resultSet.getString("Description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dessert;
    }

    @Override
    public void createDessert(Dessert dessert) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO APP.DESSERT (Price, Description) VALUES (?, ?)")) {
            statement.setInt(1, dessert.getPrice());
            statement.setString(2, dessert.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDessert(int id, Dessert dessert) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE APP.DESSERT SET Price = ?, Description = ? WHERE ID = ?")) {
            statement.setInt(1, dessert.getPrice());
            statement.setString(2, dessert.getDescription());
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDessert(int id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM APP.DESSERT WHERE ID = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

