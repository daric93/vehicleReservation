package daric.vr.services;

import daric.vr.entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by darya on 16.03.16.
 */
public class CarService {
    private final EntityManager em = Persistence.createEntityManagerFactory("VehicleReservation").createEntityManager();

    public Car addCar(Car Car){
        em.getTransaction().begin();
        Car Car1 = em.merge(Car);
        em.getTransaction().commit();
        return Car1;
    }

    public void deleteCar(int id) {
        em.getTransaction().begin();
        em.remove(em.find(Car.class, id));
        em.getTransaction().commit();
    }

    public Car getCar(int id) {
        em.getTransaction().begin();
        try {
            return em.find(Car.class, id);
        } finally {
            em.getTransaction().commit();
        }
    }

    public Car updateCar(Car Car) {
        em.getTransaction().begin();
        Car updatedCar = em.merge(Car);
        em.getTransaction().commit();
        return updatedCar;
    }
}
