package daric.vr.services;

import daric.vr.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserService {
    private final EntityManager em = Persistence.createEntityManagerFactory("VehicleReservation").createEntityManager();

    public User addUser(User user) {
        em.getTransaction().begin();
        User newUser = em.merge(user);
        em.getTransaction().commit();
        return newUser;
    }

    public void deleteUser(int id) {
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }

    public User getUser(int id) {
        em.getTransaction().begin();
        try {
            return em.find(User.class, id);
        } finally {
            em.getTransaction().commit();
        }
    }

    public User updateUser(User user) {
        em.getTransaction().begin();
        User updatedUser = em.merge(user);
        em.getTransaction().commit();
        return updatedUser;
    }
}
