package daric.vr.servlets;

import daric.vr.entities.Order;
import daric.vr.exceptions.CarIsNotAvailableException;
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
import java.text.ParseException;

public class Reserve extends HttpServlet {
    @EJB
    OrderService orderService;
    @EJB
    UserService userService;
    @EJB
    CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String mail = (String) req.getSession().getAttribute("mail");
        if (mail != null) {
            try {
                Order order = orderService.addOrder(Integer.parseInt(req.getParameter("id")), mail,
                        req.getParameter("pick_up"), req.getParameter("drop_off"));
                resp.sendRedirect("showOrder.jsp?orderId=" + order.getOrderId());
            } catch (ParseException e) {
                throw new ServletException(e);
            } catch (CarIsNotAvailableException e) {
                resp.sendRedirect("SearchPage.jsp?error=" + e.getMessage());
            }
        } else {
            req.setAttribute("error", "You are not logged in");
            RequestDispatcher dispatcher = req.getRequestDispatcher("bsLoginForm.jsp");
            dispatcher.include(req, resp);
        }
    }
}
