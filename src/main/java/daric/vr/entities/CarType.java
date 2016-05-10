package daric.vr.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "selectAllCarType", query = "select c from CarType c"),
        @NamedQuery(name = "getImgById", query = "select c.img from CarType c where c.typeId= :id")
})
@Entity
@Table(name = "CAR_TYPE")
public class CarType {
    @Id
    @GeneratedValue
    @Column(name = "TYPE_ID")
    private int typeId;

    @Column(name = "BRAND", length = 20, nullable = false)
    private String brand;

    @Column(name = "MODEL", length = 20, nullable = false)
    private String model;

    @Column(name = "SEATS", nullable = false)
    private int seats;

    @Column(name = "TRUNK_VOLUME", nullable = false)
    private int trunkVolume;

    @Column(name = "TRANSMISSION_TYPE", length = 20, nullable = false)
    private String transmissionType;

    @Column(name = "PRICE", length = 10, nullable = false)
    private double price;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "IMAGE")
    private byte[] img;

    @OneToMany(mappedBy = "carType", fetch = FetchType.LAZY)
    private List<Car> cars = new ArrayList<>();

    @XmlTransient
    public List<Car> getCars() {
        return cars;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getTrunkVolume() {
        return trunkVolume;
    }

    public void setTrunkVolume(int trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
