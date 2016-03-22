package daric.vr.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "USER_NAME", length = 20, unique = true, nullable = false)
    private String userName;

    @Column(name = "PASSWORD", length = 20, nullable = false)
    private String password;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 20, nullable = false)
    private String surname;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Date dateOfBirth;

    @Column(name = "MAIL", unique = true, nullable = false, length = 50)
    private String mail;

    @Column(name = "NUMBER", unique = true, nullable = false, length = 20)
    private String telNumber;

    @Column(name = "LICENSE", unique = true, nullable = false, length = 50)
    private String license;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
