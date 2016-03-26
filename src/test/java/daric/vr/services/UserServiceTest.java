package daric.vr.services;

import daric.vr.entities.User;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setName("Daria");
        user.setSurname("Koreneva");
        user.setDateOfBirth(LocalDate.now());
        user.setMail("daric2612@gmail.com");
        user.setTelNumber("0963687818");
        user.setLicense("2");
        user.setPassword("1");

        UserService service = new UserService();
        User user1 = service.addUser(user);
        assertNotEquals(user1.getUserId(), user.getUserId());
    }

    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setName("Daria");
        user.setSurname("Koreneva");
        user.setDateOfBirth(LocalDate.now());
        user.setMail("daric2612@gmail.com");
        user.setTelNumber("0963687818");
        user.setLicense("1");
        user.setPassword("1");

        UserService service = new UserService();
        User user1 = service.addUser(user);

        service.deleteUser(user1.getUserId());
        assertNull(service.getUser(user1.getUserId()));
    }

    @Test
    public void testGet() throws Exception {
        User user = new User();
        user.setName("Daria");
        user.setSurname("Koreneva");
        user.setDateOfBirth(LocalDate.now());
        user.setMail("daric2612@gmail.com");
        user.setTelNumber("0963687818");
        user.setLicense("1");
        user.setPassword("1");

        UserService service = new UserService();
        User user1 = service.addUser(user);

        User user2 = service.getUser(user1.getUserId());
        assertEquals(user1, user2);

    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setName("Daria");
        user.setSurname("Koreneva");
        user.setDateOfBirth(LocalDate.now());
        user.setMail("daric2612@gmail.com");
        user.setTelNumber("0963687818");
        user.setLicense("1");
        user.setPassword("1");

        UserService service = new UserService();
        User user1 = service.addUser(user);

        user1.setName("Dasha");
        User updatedUser = service.updateUser(user1);
        assertEquals(user1, updatedUser);

    }
}