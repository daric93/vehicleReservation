package daric.vr.servlets;

import daric.vr.entities.Admin;
import daric.vr.entities.User;
import daric.vr.exceptions.EntryNotFoundException;
import daric.vr.services.AdminService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.util.Objects;

public class AdminLogIn extends HttpServlet{
    @EJB
    AdminService adminService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("mail");
        String pass = req.getParameter("password");

        try {
            Admin user = adminService.getAdmin(mail);
            if (Objects.equals(user.getPassword(), pass)) {
                HttpSession session = req.getSession();
                session.setAttribute("mail", mail);
                RequestDispatcher dispatcher = req.getRequestDispatcher("adminHomePage.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("error", "Wrong username or password");
                RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
                dispatcher.include(req, resp);
            }
        }catch (EntryNotFoundException e){
            req.setAttribute("error", "Wrong username or password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
            dispatcher.include(req, resp);
        }
    }
}
