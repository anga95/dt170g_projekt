package se.miun.dt170g_projekt.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "APP", catalog = "")
public class Employee_entity {
/*    public Employee_entity(Integer id, String email, String firstName, String lastName, int restaurantId, String telephone) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.restaurantId = restaurantId;
        this.telephone = telephone;
    }*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic
    @Column(name = "REST_ID_FK")
    private int restaurantId;
    @Basic
    @Column(name = "TELEPHONE")
    private String telephone;

/*    public Employee_entity() {
    }*/

/*    public Employee_entity(String email, String firstName, String lastName, int restaurantId, String telephone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.restaurantId = restaurantId;
        this.telephone = telephone;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_entity that = (Employee_entity) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(restaurantId, that.restaurantId) && Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, restaurantId, telephone);
    }
}
