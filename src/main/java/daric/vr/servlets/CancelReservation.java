package daric.vr.servlets;

import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.exceptions.OrderAlreadyFinishedException;
import daric.vr.services.OrderService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelReservation extends HttpServlet {
    @EJB
    OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        try {
            orderService.deleteOrder(orderId);
        } catch (OrderAlreadyFinishedException e) {
            req.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("showOrder.jsp");
            dispatcher.forward(req, resp);
        } catch (EntryNotFoundException e) {
            resp.sendError(500, e.getMessage());
        }
        resp.sendRedirect("orders.jsp");
    }
}
