package daric.vr.services;

import daric.vr.entities.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Stateless
@Path("carService")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Car addCar(Car Car) {
        return em.merge(Car);
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") int id) {
        em.remove(em.find(Car.class, id));
    }

    @GET
    @Path("{id}")
    public Car getCar(@PathParam("id") int id) {
        return em.find(Car.class, id);
    }

    @GET
    @Path("orders/{id}")
    public Car getCarOrders(@PathParam("id") int id) {
        Car car = em.find(Car.class, id);
        car.getOrders();
        return car;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Car updateCar(Car Car) {
        return em.merge(Car);
    }

    @GET
    @SuppressWarnings("unchecked")
    public List<Car> getAllCars() {
        EntityGraph graph = em.createEntityGraph("graph.Car.carTypes");
        return em.createNamedQuery("Car.getAllCars").setHint("javax.persistence.fetchgraph", graph).getResultList();
    }

    @GET
    @Path("search/")
    @SuppressWarnings("unchecked")
    public List<Car> getCars(@QueryParam("city_up") String city, @QueryParam("startDate") Date start, @QueryParam("endDate") Date end) {
        EntityGraph graph = em.createEntityGraph("graph.Car.carTypes");
        return em.createNamedQuery("Car.getByParameters").setParameter("city_up", city).setParameter("startDate", start).setParameter("endDate", end).setHint("javax.persistence.fetchgraph", graph).getResultList();
    }

    @GET
    @Path("check/{id}")
    public Car checkDate(@PathParam("id") int id, @QueryParam("orderId") Integer orderId, @QueryParam("startDate") Date start, @QueryParam("endDate") Date end) {
        try {
            return (Car) em.createNamedQuery("Car.checkDate").setParameter("id", id).setParameter("orderId", orderId).setParameter("startDate", start).setParameter("endDate", end).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Car getCarRef(int id) {
        return em.getReference(Car.class, id);
    }
}
