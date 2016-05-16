package daric.vr.servlets;

import daric.vr.entities.CarType;
import daric.vr.services.CarTypeService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCarTypes extends HttpServlet {
    @EJB
    CarTypeService carTypeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarType> carTypes = carTypeService.getAll();
        req.setAttribute("carTypes", carTypes);
        RequestDispatcher dispatcher = req.getRequestDispatcher("carTypes.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
