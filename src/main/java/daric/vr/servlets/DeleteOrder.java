package daric.vr.servlets;

import daric.vr.services.OrderService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrder extends HttpServlet {
    @EJB
    OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.deleteOrder(Integer.parseInt(orderId));
        resp.sendRedirect("orders");
    }
}
