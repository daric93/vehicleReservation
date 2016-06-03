package daric.vr.servlets;

import daric.vr.entities.Order;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.services.OrderService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOrder implements Filter {
    @EJB
    OrderService orderService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String orderId = request.getParameter("orderId");
        System.out.println("In filter:" + orderId);
        try {
            Order order = orderService.getOrderWithCar(Integer.parseInt(orderId));
            request.setAttribute("order", order);
            chain.doFilter(request, response);
        } catch (EntryNotFoundException e) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(404, "Not found");
        }
    }

    @Override
    public void destroy() {
    }
}
