package daric.vr.servlets;

import daric.vr.entities.Car;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.services.CarService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCar implements Filter {
    @EJB
    CarService carService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            String carId = request.getParameter("carId");
            Car car = carService.getCar(Integer.parseInt(carId));
            request.setAttribute("car", car);
            chain.doFilter(request, response);
        } catch (EntryNotFoundException e) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(404, e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
