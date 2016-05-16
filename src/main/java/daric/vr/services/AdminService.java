package daric.vr.services;

import daric.vr.entities.Admin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;

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
            return null;
        }
    }

    @POST
    public Admin addAdmin(Admin admin) {
        return em.merge(admin);
    }

    @DELETE
    @Path("{id}")
    public void deleteAdmin(@PathParam("id") int id) {
        em.remove(em.find(Admin.class, id));
    }
}
