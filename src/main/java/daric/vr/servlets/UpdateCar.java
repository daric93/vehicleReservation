package daric.vr.servlets;

import daric.vr.entities.Car;
import daric.vr.exceptions.DuplicateEntryException;
import daric.vr.exceptions.RequiredFieldIsMissingException;
import daric.vr.services.CarService;
import daric.vr.services.CarTypeService;

import javax.ejb.EJB;
import javax.persistence.EntityNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCar extends HttpServlet {
    @EJB
    CarService carService;
    @EJB
    CarTypeService carTypeService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = (Car) req.getAttribute("car");
        if (req.getParameter("active") != null)
            car.setActive(true);
        else car.setActive(false);
        car.setColor(req.getParameter("color"));
        car.setCarType(carTypeService.getCarTypeRef(Integer.parseInt(req.getParameter("carType"))));
        car.setLicenseNumber(req.getParameter("number"));
        car.setAddress(req.getParameter("address"));
        try {
            //String carId = req.getParameter("carId");
            //Car car = carService.getCar(Integer.parseInt(carId));
            carService.addCar(car);
            resp.sendRedirect("editCar.jsp?success=Updated&carId="+car.getCarId());
        } catch (RequiredFieldIsMissingException | DuplicateEntryException | EntityNotFoundException e) {
            resp.sendRedirect("editCar.jsp?error="+e.getMessage()+"&carId="+car.getCarId());
        }
    }
}
