package daric.vr.servlets;

import daric.vr.entities.CarType;
import daric.vr.services.CarTypeService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCarTypes implements Filter {
    @EJB
    CarTypeService carTypeService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<CarType> carTypes = carTypeService.getAll();
        request.setAttribute("carTypes", carTypes);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
