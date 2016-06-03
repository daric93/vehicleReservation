package daric.vr.servlets;

import daric.vr.entities.User;
import daric.vr.exceptions.DuplicateEntryException;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.exceptions.RequiredFieldIsMissingException;
import daric.vr.services.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateUser extends HttpServlet {
    @EJB
    UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            String mail = (String) req.getSession().getAttribute("mail");
            user = userService.getUserByMail(mail);
            user.setName(req.getParameter("name"));
            user.setSurname(req.getParameter("surname"));
            user.setDateOfBirth(LocalDate.parse(req.getParameter("date"), DateTimeFormatter.ISO_LOCAL_DATE));
            user.setLicense(req.getParameter("license"));
            user.setTelNumber(req.getParameter("number"));
            userService.addUser(user);
            resp.sendRedirect("profile.jsp");
        } catch (EntryNotFoundException e) {
            resp.sendRedirect("bsLoginForm.jsp");
        } catch (DuplicateEntryException | RequiredFieldIsMissingException e) {
            req.setAttribute("user", user);
            req.setAttribute("error", e.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("editProfile.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
