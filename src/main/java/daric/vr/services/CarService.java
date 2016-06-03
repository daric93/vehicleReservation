package daric.vr.services;

import com.google.common.base.Throwables;
import daric.vr.entities.Car;
import daric.vr.exceptions.CarIsNotAvailableException;
import daric.vr.exceptions.DuplicateEntryException;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.exceptions.RequiredFieldIsMissingException;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless
@Path("carService")
@Produces(MediaType.APPLICATION_JSON)
public class CarService {
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Car addCar(Car Car) {
        try {
            Car car = em.merge(Car);
            em.flush();
            return car;
        } catch (PersistenceException e) {
            if (Throwables.getCausalChain(e).stream().
                    anyMatch(ex -> ex.getMessage().contains("Duplicate entry"))) {
                throw new DuplicateEntryException("Car with this license number already exists");
            } else {
                Optional<Throwable> opt = Throwables.getCausalChain(e).stream().
                        filter(ex -> ex.getMessage().contains("cannot be null")).findAny();
                if (opt.isPresent())
                    throw new RequiredFieldIsMissingException(opt.get().getMessage());
                else throw e;
            }
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteCar(@PathParam("id") int id) {
        em.remove(getCar(id));
    }

    @GET
    @Path("{id}")
    public Car getCar(@PathParam("id") int id) {
        EntityGraph graph = em.createEntityGraph("graph.Car.carTypes");
        try {
            return (Car) em.createNamedQuery("Car.getCar").
                    setHint("javax.persistence.fetchgraph", graph).
                    setParameter("carId", id).getSingleResult();
        } catch (NoResultException e) {
            throw new EntryNotFoundException("Car with this id is not found");
        }
    }

    @GET
    @Path("orders/{id}")
    public Car getCarOrders(@PathParam("id") int id) {
        Car car = getCar(id);
        car.getOrders();
        return car;
    }

    @GET
    @SuppressWarnings("unchecked")
    public List<Car> getAllCars() {
        EntityGraph graph = em.createEntityGraph("graph.Car.carTypes");
        return em.createNamedQuery("Car.getAllCars").setHint("javax.persistence.fetchgraph", graph).
                getResultList();
    }

    @GET
    @Path("search/")
    @SuppressWarnings("unchecked")
    public List<Car> getCars(@QueryParam("city_up") String city,
                             @QueryParam("startDate") Date start,
                             @QueryParam("endDate") Date end) {
        EntityGraph graph = em.createEntityGraph("graph.Car.carTypes");
        return em.createNamedQuery("Car.getByParameters").setParameter("city_up", city).
                setParameter("startDate", start).setParameter("endDate", end).
                setHint("javax.persistence.fetchgraph", graph).getResultList();
    }

    public Car checkDate(@PathParam("id") int id,
                         @QueryParam("orderId") Integer orderId,
                         @QueryParam("startDate") Date start,
                         @QueryParam("endDate") Date end) {
        try {
            return (Car) em.createNamedQuery("Car.checkDate").setParameter("id", id).
                    setParameter("orderId", orderId).setParameter("startDate", start).
                    setParameter("endDate", end).getSingleResult();
        } catch (NoResultException e) {
            throw new CarIsNotAvailableException("Car is not available during this period");
        }
    }
}
