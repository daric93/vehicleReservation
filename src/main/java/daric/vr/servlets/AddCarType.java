package daric.vr.servlets;

import com.google.common.io.ByteStreams;
import daric.vr.entities.CarType;
import daric.vr.services.CarTypeService;
import daric.vr.services.DuplicateEntryException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class AddCarType extends HttpServlet {
    @EJB
    CarTypeService carTypeService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarType carType = new CarType();
        carType.setBrand(req.getParameter("brand"));
        carType.setModel(req.getParameter("model"));
        carType.setSeats(Integer.parseInt(req.getParameter("seats")));
        carType.setTransmissionType(req.getParameter("transmissionType"));
        carType.setTrunkVolume(Integer.parseInt(req.getParameter("trunkVolume")));
        carType.setPrice(Double.parseDouble(req.getParameter("price")));
        carType.setImg(ByteStreams.toByteArray(req.getPart("image").getInputStream()));

        try {
            carTypeService.addCarType(carType);
        } catch (DuplicateEntryException e) {
            resp.sendRedirect("carTypes.jsp?error=" + e.getMessage());
            return;
        }
        resp.sendRedirect("carTypes.jsp");
    }
}
