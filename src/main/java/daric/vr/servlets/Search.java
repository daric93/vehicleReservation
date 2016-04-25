package daric.vr.servlets;

import daric.vr.entities.Car;
import daric.vr.entities.CarType;
import daric.vr.services.CarService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search extends HttpServlet {
    @EJB
    CarService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("city-up") != null) {
            String city_up = req.getParameter("city-up");
            List<Car> cars = service.getCarByAddress(city_up);
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
