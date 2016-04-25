package daric.vr.services;

import daric.vr.entities.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("carService")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Car addCar(Car Car){
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
    public Car getCarOrders(@PathParam("id") int id){
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
    public List<Car> getCarByAddress(@QueryParam("address") String address) {
        EntityGraph entityGraph = em.createEntityGraph("graph.Car.carTypes");
        return (List<Car>) em.createNamedQuery("Car.getByAddress").setParameter("address", address).setHint("javax.persistence.fetchgraph", entityGraph).getResultList();
    }

    @GET
    @SuppressWarnings("unchecked")
    public List<Car> getAllCars() {
        EntityGraph graph = em.createEntityGraph("graph.Car.carTypes");
        return em.createNamedQuery("Car.getAllCars").setHint("javax.persistence.fetchgraph", graph).getResultList();
    }
}
