package daric.vr.services;

import com.google.common.base.Throwables;
import daric.vr.entities.User;
import daric.vr.exceptions.DuplicateEntryException;
import daric.vr.exceptions.RequiredFieldIsMissingException;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Stateless
@Path("userService")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        try {
            User user1 = em.merge(user);
            em.flush();
            return user1;
        } catch (PersistenceException e) {
            if (Throwables.getCausalChain(e).stream().anyMatch(ex -> ex.getMessage().contains("Duplicate entry"))) {
                throw new DuplicateEntryException("User with this mail already exists");
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
    public void deleteUser(@PathParam("id") int id) {
        em.remove(getUser(id));
    }

    @GET
    @Path("{id}")
    public User getUser(@PathParam("id") int id) {
        User user = em.find(User.class, id);
        if (user == null)
            throw new NotFoundException("User with this id is not found");
        return user;
    }

    @GET
    @Path("{mail}")
    public User getUserByMail(@PathParam("mail") String mail) {
        EntityGraph graph = em.createEntityGraph("graph.User.getOrders");
        try {
            return (User) em.createNamedQuery("getUserByMail").
                    setParameter("mail", mail).setHint("javax.persistence.fetchgraph", graph).
                    getSingleResult();
        } catch (NoResultException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
