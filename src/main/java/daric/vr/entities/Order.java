package daric.vr.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Order.getOrderWithCar", query = "select o from Order o where o.orderId = :id"),
        @NamedQuery(name = "Order.getOrders", query = "select orders from Order orders")
})
@NamedEntityGraphs({
        @NamedEntityGraph(name = "graph.Order.car",
                attributeNodes = @NamedAttributeNode(value = "car", subgraph = "carTypeGraph"),
                subgraphs = @NamedSubgraph(name = "carTypeGraph",
                        attributeNodes = @NamedAttributeNode(value = "carType"))),
        @NamedEntityGraph(name = "graph.Order.user&car",
                attributeNodes = {
                        @NamedAttributeNode(value = "car", subgraph = "carTypeGraph"),
                        @NamedAttributeNode(value = "user")
                },
                subgraphs = @NamedSubgraph(name = "carTypeGraph",
                        attributeNodes = @NamedAttributeNode(value = "carType")))
})
@Table(name = "CAR_ORDER")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID", nullable = false)
    private Car car;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Column(name = "ORDER_DATE", nullable = false)
    private Date orderDate;

    @Column(name = "PAYMENT_RECEIVD", nullable = false)
    private boolean paymentReceived;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice;

    @Column(name = "OLD_ORDER_ID")
    private int oldOrderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(boolean paymentReceived) {
        this.paymentReceived = paymentReceived;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOldOrderId() {
        return oldOrderId;
    }

    public void setOldOrderId(int oldOrderId) {
        this.oldOrderId = oldOrderId;
    }
}
