package daric.vr.servlets;

import daric.vr.entities.User;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.services.UserService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUser implements Filter {
    @EJB
    UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            String mail = (String) req.getSession().getAttribute("mail");
            User user = userService.getUserByMail(mail);
            request.setAttribute("user", user);
            chain.doFilter(request, response);
        } catch (EntryNotFoundException e) {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect("bsLoginForm.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}
