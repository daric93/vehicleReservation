package daric.vr.servlets;

import daric.vr.entities.CarType;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.services.CarTypeService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import java.io.IOException;

public class GetCarType extends HttpServlet {
    @EJB
    CarTypeService carTypeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CarType carType = carTypeService.getCarType(Integer.parseInt(req.getParameter("carTypeId")));
            req.setAttribute("carType", carType);
            RequestDispatcher dispatcher = req.getRequestDispatcher("editCarType.jsp");
            dispatcher.forward(req, resp);
        } catch (EntryNotFoundException e) {
            resp.sendError(404, "Not found");
        }
    }
}
