package daric.vr.servlets;

import daric.vr.entities.Car;
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
        if (req.getSession().getAttribute("mail") != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Order order = new Order();
            Car car = carService.getCarRef(Integer.parseInt(req.getParameter("id")));
            order.setCarId(car);
            order.setUserId(userService.getUserByMail((String) req.getSession().getAttribute("mail")));
            try {
                Date pick_up = dateFormat.parse(req.getParameter("pick_up"));
                Date drop_off = dateFormat.parse(req.getParameter("drop_off"));
                order.setStartDate(pick_up);
                order.setEndDate(drop_off);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            order.setOrderDate(new Date());
            order.setPaymentReceived(false);
            Order order1 = orderService.addOrder(order);
            if (order1 != null)
                req.setAttribute("order", order1.getOrderId());
            else
                req.setAttribute("error", "These dates are not available already");
            RequestDispatcher dispatcher = req.getRequestDispatcher("showOrder");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("error", "You are not logged in");
            RequestDispatcher dispatcher = req.getRequestDispatcher("bsLoginForm.jsp");
            dispatcher.include(req, resp);
        }
    }
}
