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
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CancelReservation extends HttpServlet {
    @EJB
    OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        Order order = orderService.getOrder(orderId);
        if (!order.isPaymentReceived() || order.getStartDate().after(new Date())) {
            orderService.deleteOrder(orderId);
            RequestDispatcher dispatcher = req.getRequestDispatcher("orders");
            dispatcher.forward(req, resp);
        } else {
            long durationAllInMin = TimeUnit.MILLISECONDS.toMinutes(order.getEndDate().getTime() - order.getStartDate().getTime());
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - order.getStartDate().getTime());
            double price = order.getTotalPrice() / durationAllInMin * diffInMinutes + 50;
            req.setAttribute("orderId", orderId);
            req.setAttribute("reservation_price", price);
            req.setAttribute("total", order.getTotalPrice());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("confirmCancellation");
            requestDispatcher.forward(req, resp);
        }
    }
}
