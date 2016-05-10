package daric.vr.servlets;

import daric.vr.entities.Order;
import daric.vr.services.OrderService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowOrder extends HttpServlet {
    @EJB
    OrderService orderService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getAttribute("order");
        if (attribute != null) {
            Order order = orderService.getOrderWithCar((int) attribute);
            req.setAttribute("order", order);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("showOrder.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
