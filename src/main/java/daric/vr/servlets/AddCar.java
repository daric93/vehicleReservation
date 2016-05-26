package daric.vr.servlets;

import daric.vr.entities.Car;
import daric.vr.entities.CarType;
import daric.vr.services.CarService;
import daric.vr.services.CarTypeService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCar extends HttpServlet {
    @EJB
    CarTypeService carTypeService;
    @EJB
    CarService carService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        CarType carTypeRef = carTypeService.getCarTypeRef(Integer.parseInt(req.getParameter("carType")));
        car.setCarType(carTypeRef);
        car.setAddress(req.getParameter("address"));
        car.setLicenseNumber(req.getParameter("number"));
        car.setColor(req.getParameter("color"));
        if (req.getParameter("active") != null) {
            car.setActive(true);
        } else car.setActive(false);

        carService.addCar(car);
        resp.sendRedirect("cars.jsp");
    }
}
