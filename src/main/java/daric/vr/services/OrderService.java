package daric.vr.services;

import daric.vr.entities.Car;
import daric.vr.entities.Order;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Stateless
@Path("orderService")
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {
    @EJB
    CarService carService;
    @EJB
    UserService userService;
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Path("add")
    public Order addOrder(@FormParam("carId") int carId,
                          @FormParam("userMail") String mail,
                          @FormParam("pick_up") Date startDate,
                          @FormParam("drop_off") Date endDate) {
        Car car = carService.checkDate(carId, null, startDate, endDate);
        if (car != null) {
            Order order = new Order();
            order.setStartDate(startDate);
            order.setEndDate(endDate);
            order.setOrderDate(new Date());
            order.setCar(car);
            order.setUser(userService.getUserByMail(mail));
            order.setPaymentReceived(false);
            long duration = endDate.getTime() - startDate.getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            double price = car.getCarType().getPrice();
            order.setTotalPrice(price / 60 * diffInMinutes);
            return em.merge(order);
        } else return null;
    }


    @GET
    @Path("{id}")
    public Order getOrder(@PathParam("id") int id) {
        return em.find(Order.class, id);
    }

    @PUT
    @Path("update")
    public Order updateOrder(@FormParam("orderId") int orderId,
                             @FormParam("pick_up") Date startDate,
                             @FormParam("drop_off") Date endDate) {
        Order oldOrder = getOrderWithCar(orderId);
        Car car = carService.checkDate(oldOrder.getCar().getCarId(), orderId, startDate, endDate);
        if (car != null) {
            Order newOrder = new Order();
            newOrder.setStartDate(startDate);
            newOrder.setEndDate(endDate);
            newOrder.setOrderDate(new Date());
            newOrder.setCar(car);
            newOrder.setUser(oldOrder.getUser());

            long duration = endDate.getTime() - startDate.getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            double price = car.getCarType().getPrice() / 60 * diffInMinutes;
            if (price < oldOrder.getTotalPrice()) {
                //TODO: returnMoney();
                newOrder.setPaymentReceived(true);
                em.remove(oldOrder);
            } else {
                //TODO: pay();
                newOrder.setPaymentReceived(false);
                newOrder.setOldOrderId(orderId);
            }
            newOrder.setTotalPrice(price);
            return em.merge(newOrder);
        } else return null;
    }

    @DELETE
    @Path("{id}")
    public void deleteOrder(@PathParam("id") int id) throws OrderAlreadyFinishedException {
        Order order = getOrder(id);
        Date now = new Date();
        if (order.getStartDate().after(now)) {
            //TODO: returnMoney(order.getTotalPrice());
        } else {
            if (order.getStartDate().before(now) && order.getEndDate().after(now)) {
                long durationAllInMin = TimeUnit.MILLISECONDS.toMinutes(order.getEndDate().getTime() - order.getStartDate().getTime());
                long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - order.getStartDate().getTime());
                double price = order.getTotalPrice() / durationAllInMin * diffInMinutes + 10;
                //TODO: pay(price);
            } else {
                throw new OrderAlreadyFinishedException("Order already finished");
            }
        }
        em.remove(order);
    }

    @GET
    @Path("order/{id}")
    public Order getOrderWithCar(@PathParam("id") int id) {
        EntityGraph graph = em.createEntityGraph("graph.Order.car");
        return (Order) em.createNamedQuery("Order.getOrderWithCar").setParameter("id", id).setHint("javax.persistence.fetchgraph", graph).getSingleResult();
    }
}
