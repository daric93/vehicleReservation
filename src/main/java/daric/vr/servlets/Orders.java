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
import java.util.List;

public class Orders extends HttpServlet {
    @EJB
    OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.getOrders();
        req.setAttribute("orders", orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher("adminOrders.jsp");
        dispatcher.forward(req, resp);
    }
}
