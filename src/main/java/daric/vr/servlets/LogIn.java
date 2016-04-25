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
import java.util.Objects;

public class LogIn extends HttpServlet {
    @EJB
    UserService serv;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mail = req.getParameter("mail");
        String pass = req.getParameter("password");

        User user = serv.getUserByMail(mail);
        if (user != null && Objects.equals(user.getPassword(), pass)) {
            HttpSession session = req.getSession();
            session.setAttribute("mail", mail);
            RequestDispatcher dispatcher = req.getRequestDispatcher("logged.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "Wrong username or password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("logIn.jsp");
            dispatcher.include(req, resp);
        }
    }
}