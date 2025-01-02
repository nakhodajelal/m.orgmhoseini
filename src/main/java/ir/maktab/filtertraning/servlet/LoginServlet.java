package ir.maktab.filtertraning.servlet;

import ir.maktab.filtertraning.model.Person;
import ir.maktab.filtertraning.service.IUserService;
import ir.maktab.filtertraning.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nationalCode = req.getParameter("nationalCode");


        Person user = userService.authenticateUser(username, password, nationalCode);

        if (user != null) {

            if (password.equals("12061206")) {
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("user.jsp").forward(req, resp);
            }
        } else {

            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials.");
        }
    }
}