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
import java.util.concurrent.TimeUnit;

@Stateless
@Path("orderService")
@Produces(MediaType.APPLICATION_JSON)
public class OrderService {
    @EJB
    CarService carService;
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Path("{carId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Order addOrder(@PathParam("carId") int carId, Order order) {
        Car car = carService.checkDate(carId, order.getStartDate(), order.getEndDate());
        if (car != null) {
            order.setCar(car);
            long duration = order.getEndDate().getTime() - order.getStartDate().getTime();
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
    public Order updateOrder(Order order) {
        return em.merge(order);
    }

    @DELETE
    @Path("{id}")
    public void deleteOrder(@PathParam("id") int id) {
        em.remove(em.find(Order.class, id));
    }

    @GET
    @Path("order/{id}")
    public Order getOrderWithCar(@PathParam("id") int id) {
        EntityGraph graph = em.createEntityGraph("graph.Order.car");
        return (Order) em.createNamedQuery("Order.getOrderWithCar").setParameter("id", id).setHint("javax.persistence.fetchgraph", graph).getSingleResult();
    }
}
