package daric.vr.servlets;

import daric.vr.entities.Order;
import daric.vr.exceptions.EntryNotFoundException;
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
        try {
            if (req.getAttribute("order") != null) {
                Order order = orderService.getOrderWithCar((int) req.getAttribute("order"));
                req.setAttribute("order", order);
            }
            if (req.getParameter("order") != null) {
                Order order = orderService.getOrderWithCar(Integer.parseInt(req.getParameter("order")));
                req.setAttribute("order", order);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("showOrder.jsp");
            dispatcher.forward(req, resp);
        } catch (EntryNotFoundException e) {
            resp.sendError(404, e.getMessage());
        }
    }
}
