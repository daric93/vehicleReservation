package daric.vr.services;

import com.google.common.base.Throwables;
import daric.vr.entities.Admin;
import daric.vr.exceptions.DuplicateEntryException;
import daric.vr.exceptions.RequiredFieldIsMissingException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.ws.rs.*;
import java.util.Optional;

@Stateless
@Path("adminService")
public class AdminService {
    @PersistenceContext(unitName = "VehicleReservation")
    private EntityManager em;

    @GET
    @Path("{mail}")
    public Admin getAdmin(@PathParam("mail") String mail) {
        try {
            return (Admin) em.createNamedQuery("Admin.getAdmin").setParameter("mail", mail).getSingleResult();
        } catch (NoResultException e) {
            throw new NotFoundException(e);
        }
    }

    @POST
    public Admin addAdmin(Admin admin) {
        try {
            Admin admin1 = em.merge(admin);
            em.flush();
            return admin1;
        } catch (PersistenceException e) {
            if (Throwables.getCausalChain(e).stream().anyMatch(ex -> ex.getMessage().contains("Duplicate entry"))) {
                throw new DuplicateEntryException("Admin with such mail already exists");
            } else {
                Optional<Throwable> opt = Throwables.getCausalChain(e).stream().filter(ex -> ex.getMessage().contains("cannot be null")).findAny();
                if (opt.isPresent())
                    throw new RequiredFieldIsMissingException(opt.get().getMessage());
                else throw e;
            }
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteAdmin(@PathParam("id") int id) {
        Admin admin = em.find(Admin.class, id);
        if (admin == null)
            throw new NotFoundException("Entry with such id is not found");
        em.remove(admin);
    }
}
