package daric.vr.services;

import daric.vr.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("userService")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        return em.merge(user);
    }

    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") int id) {
        em.remove(em.find(User.class, id));
    }

    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") int id) {
        return em.find(User.class, id);
    }

    @GET
    @Path("{username}")
    public User getUserByMail(@PathParam("mail") String mail) {
        try {
            return (User) em.createNamedQuery("getUserByMail").setParameter("mail", mail).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        return em.merge(user);
    }
}
