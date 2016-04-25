package daric.vr.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Car.getByAddress", query = "select c from Car c where c.address like :address"),
        @NamedQuery(name = "Car.getAllCars", query = "select c from Car c")
})
@NamedEntityGraph(name = "graph.Car.carTypes", attributeNodes = @NamedAttributeNode("carType"))

@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "CAR_ID")
    private int carId;

    @Column(name = "NUMBER", nullable = false)
    private String licenseNumber;

    @Column(name = "COLOR", nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_TYPE")
    private CarType carType;

    @Column(name = "ACTIVE", nullable = false)
    private boolean active;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @OneToMany(mappedBy = "carId", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @XmlTransient
    public List<Order> getOrders() {
        return orders;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean state) {
        this.active = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
