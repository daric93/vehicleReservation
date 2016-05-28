package daric.vr.servlets;

import daric.vr.entities.User;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.services.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Orders extends HttpServlet {
    @EJB
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = userService.getUserByMail((String) req.getSession().getAttribute("mail"));
            req.setAttribute("orders", user);
            //TODO: show only last version with prices
            //TODO: show order status: active, old, future
            RequestDispatcher dispatcher = req.getRequestDispatcher("orders.jsp");
            dispatcher.forward(req, resp);
        } catch (EntryNotFoundException e) {
            resp.sendError(404, "Session is over");
        }
    }
}
