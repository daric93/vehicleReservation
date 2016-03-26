package daric.vr.servlets;

import daric.vr.entities.User;
import daric.vr.services.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registration extends HttpServlet {
    @EJB
    UserService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setMail(req.getParameter("mail"));
        user.setLicense(req.getParameter("license"));
        user.setTelNumber(req.getParameter("phone"));
        user.setDateOfBirth(LocalDate.parse(req.getParameter("date"), DateTimeFormatter.ISO_LOCAL_DATE));
        user.setPassword(req.getParameter("password"));

        System.out.println(user);

        User addedUser = service.addUser(user);
        System.out.println(addedUser);
        HttpSession session = req.getSession();
        session.setAttribute("mail", addedUser.getMail());

        RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
        dispatcher.forward(req, resp);
    }
}
