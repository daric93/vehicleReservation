package daric.vr.servlets;

import daric.vr.entities.Order;
import daric.vr.services.CarService;
import daric.vr.services.OrderService;
import daric.vr.services.UserService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserve extends HttpServlet {
    @EJB
    OrderService orderService;
    @EJB
    UserService userService;
    @EJB
    CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = (String) req.getSession().getAttribute("mail");
        if (mail != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date pick_up = dateFormat.parse(req.getParameter("pick_up"));
                Date drop_off = dateFormat.parse(req.getParameter("drop_off"));
                Order order;
                if (req.getParameter("orderId") != null) {
                    order = orderService.updateOrder(Integer.parseInt(req.getParameter("orderId")), pick_up, drop_off);
                } else
                    order = orderService.addOrder(Integer.parseInt(req.getParameter("id")), mail, pick_up, drop_off);
                if (order != null)
                    req.setAttribute("order", order.getOrderId());
                else
                    req.setAttribute("error", "These dates are not available");

            } catch (ParseException e) {
                throw new ServletException(e);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("showOrder");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "You are not logged in");
            RequestDispatcher dispatcher = req.getRequestDispatcher("bsLoginForm.jsp");
            dispatcher.include(req, resp);
        }
    }
}
