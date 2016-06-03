package daric.vr.services;

import com.google.common.base.Throwables;
import daric.vr.entities.CarType;
import daric.vr.exceptions.DuplicateEntryException;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.exceptions.RequiredFieldIsMissingException;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
            if (Throwables.getCausalChain(e).stream().
                    anyMatch(ex -> ex.getMessage().contains("uniqueBrandModel"))) {
                throw new DuplicateEntryException("Duplicate Car Type");
            } else {
                Optional<Throwable> opt = Throwables.getCausalChain(e).stream().
                        filter(ex -> ex.getMessage().contains("cannot be null")).findAny();
                if (opt.isPresent())
                    throw new RequiredFieldIsMissingException(opt.get().getMessage());
                else
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
        CarType carType = em.find(CarType.class, id);
        if (carType == null)
            throw new EntryNotFoundException("CarType with this id is not found");
        return carType;
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
        byte[] result;
        try {
            result = (byte[]) em.createNamedQuery("getImgById").
                    setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            throw new EntryNotFoundException("Entry with such id is not found");
        }
        return result;
    }

    public CarType getCarTypeRef(int id) {
        try {
            return em.getReference(CarType.class, id);
        } catch (EntityNotFoundException e) {
            throw new EntryNotFoundException("CarType with such id is not found");
        }
    }
}
