package app;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee", schema = "APP")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;
    @Column(name = "TELEPHONE")
    private String telephone;

    public Employee() {}

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name;}

    public String getTelephone() {return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone;}


}
