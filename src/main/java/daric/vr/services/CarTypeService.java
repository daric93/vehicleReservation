package daric.vr.services;

import com.google.common.base.Throwables;
import daric.vr.entities.CarType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Stateless
@Path("carType")
@Produces(MediaType.APPLICATION_JSON)
public class CarTypeService {
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CarType addCarType(CarType carType) throws DuplicateEntryException {
        try {
            em.merge(carType);
            em.flush();
            return carType;
        } catch (PersistenceException e) {
            if (Throwables.getCausalChain(e).stream().anyMatch(ex -> ex.getMessage().contains("uniqueBrandModel"))) {
                throw new DuplicateEntryException("Duplicate Car Type",e);
            } else {
                throw e;
            }
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteCarType(@PathParam("id") int id) {
        em.remove(getCarType(id));
    }

    @GET
    @Path("{id}")
    public CarType getCarType(@PathParam("id") int id) {
        //TODO: throw EntryNotFoundException
        return em.find(CarType.class, id);
    }

    @GET
    @SuppressWarnings("unchecked")
    public List<CarType> getAll() {
        return em.createNamedQuery("selectAllCarType").getResultList();
    }

    @GET
    @Path("fetchImg/{id}")
    @Produces({"image/jpg", "image/png"})
    public byte[] fetchImg(@PathParam("id") int id) throws IOException {
        //TODO: throw EntryNotFoundException
        return (byte[]) em.createNamedQuery("getImgById").setParameter("id", id).getSingleResult();
    }

    public CarType getCarTypeRef(int id) {
        return em.getReference(CarType.class, id);
    }
}
