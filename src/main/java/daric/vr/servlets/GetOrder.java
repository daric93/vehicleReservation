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

public class GetOrder extends HttpServlet{
    @EJB
    OrderService orderService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        Order order = orderService.getOrderWithCar(Integer.parseInt(orderId));
        req.setAttribute("order",order);
        RequestDispatcher dispatcher = req.getRequestDispatcher("editOrder.jsp");
        dispatcher.forward(req,resp);
    }
}
