package daric.vr.servlets;

import daric.vr.entities.Car;
import daric.vr.services.CarService;

import javax.ejb.EJB;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class GetCars implements Filter{
    @EJB
    CarService carService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<Car> cars = carService.getAllCars();
        request.setAttribute("cars",cars);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
