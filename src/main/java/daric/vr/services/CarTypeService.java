package daric.vr.services;

import daric.vr.entities.CarType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("carType")
@Produces(MediaType.APPLICATION_JSON)
public class CarTypeService {
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CarType addCarType(CarType carType) {
        return em.merge(carType);
    }

    @DELETE
    @Path("{id}")
    public void deleteCarType(@PathParam("id") int id) {
        em.remove(em.find(CarType.class, id));
    }

    @GET
    @Path("{id}")
    public CarType getCarType(@PathParam("id") int id) {
        return em.find(CarType.class, id);
    }

    @GET
    public List getAll() {
        return em.createNamedQuery("selectAllCarType").getResultList();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public CarType updateCarType(CarType carType) {
        return em.merge(carType);
    }

}
