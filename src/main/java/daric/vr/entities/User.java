package daric.vr.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "getUserByMail", query = "select user from User user where user.mail like :mail")
@NamedEntityGraph(name = "graph.User.getOrders", attributeNodes = @NamedAttributeNode(value = "orders"))
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "PASSWORD", length = 20, nullable = false)
    private String password;

    @Column(name = "NAME", length = 20, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 20, nullable = false)
    private String surname;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "MAIL", unique = true, nullable = false, length = 50)
    private String mail;

    @Column(name = "NUMBER", nullable = false, length = 20)
    private String telNumber;

    @Column(name = "LICENSE", length = 50)
    private String license;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    @Override
    public String toString() {
        return "Name " + name + "\n" +
                "Surname " + surname + "\n" +
                "Mail " + mail + "\n" +
                "Birth " + dateOfBirth + "\n" +
                "Number " + telNumber + "\n" +
                "Password " + password + "\n" +
                "License " + license + "\n";
    }
}
