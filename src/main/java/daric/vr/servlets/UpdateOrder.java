package daric.vr.servlets;

import daric.vr.entities.Order;
import daric.vr.exceptions.CarIsNotAvailableException;
import daric.vr.services.OrderService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class UpdateOrder extends HttpServlet {
    @EJB
    OrderService orderService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = (String) req.getSession().getAttribute("mail");
        if (mail != null) {
            int orderId = Integer.parseInt(req.getParameter("orderId"));
            try {
                Order order = orderService.updateOrder(orderId, req.getParameter("pick_up"), req.getParameter("drop_off"));
                resp.sendRedirect("showOrder.jsp?orderId=" + order.getOrderId());
            } catch (ParseException e) {
                throw new ServletException(e);
            } catch (CarIsNotAvailableException e) {
                resp.sendRedirect("editOrder.jsp?orderId=" + orderId + "&error=These dates are not available.");
            }
        } else {
            req.setAttribute("error", "You are not logged in");
            RequestDispatcher dispatcher = req.getRequestDispatcher("bsLoginForm.jsp");
            dispatcher.include(req, resp);
        }
    }
    //TODO:check if new date is the same
    //TODO: check old orders
}
