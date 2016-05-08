package daric.vr.servlets;

import daric.vr.entities.Car;
import daric.vr.services.CarService;

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
import java.util.List;

public class Search extends HttpServlet {
    @EJB
    CarService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("city_up") != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            List<Car> cars = null;
            try {
                cars = service.getCars(req.getParameter("city_up"), dateFormat.parse(req.getParameter("pick_up")), dateFormat.parse(req.getParameter("drop_off")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            req.setAttribute("cars", cars);
            RequestDispatcher dispatcher = req.getRequestDispatcher("SearchPage.jsp");
            dispatcher.forward(req, resp);
        } else {
            List<Car> cars = service.getAllCars();
            req.setAttribute("cars", cars);
            RequestDispatcher dispatcher = req.getRequestDispatcher("SearchPage.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
