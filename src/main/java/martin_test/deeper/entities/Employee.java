package martin_test.deeper.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@NamedQueries({
        @NamedQuery(name = "employee.selectAll", query = "select employee from Employee employee "),
        @NamedQuery(name = "employee.selectById", query = "select employee from Employee employee where employee.id = :id"),
        @NamedQuery(name = "employee.selectByDeviceId", query = "select employee from Employee employee where employee.deviceId = :deviceId"),
        @NamedQuery(name = "employee.selectByEmail", query = "select employee from Employee employee where employee.email = :email"),

        @NamedQuery(name = "employee.updateById", query = "update Employee employee set employee.name = :name, employee.deviceId = :deviceId, employee.email = :email, employee.phone = :phone where employee.id = :id"),

        @NamedQuery(name = "employee.removeById", query = "delete from Employee employee where employee.id = :id"),
})
public class Employee implements java.io.Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Basic
    @Column(name = "NAME", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "DEVICE_ID", nullable = true, length = 50)
    private String deviceId;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "PHONE", nullable = true, length = 50)
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
