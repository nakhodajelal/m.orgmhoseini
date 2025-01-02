package ir.maktab.filtertraning.servlet;

import ir.maktab.filtertraning.model.dto.CreateUserRequest;
import ir.maktab.filtertraning.model.dto.CreateUserResponse;
import ir.maktab.filtertraning.service.IUserService;
import ir.maktab.filtertraning.service.impl.UserServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class UserServlet extends HttpServlet {

    private final IUserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserRequest createUserRequest = (CreateUserRequest) req.getAttribute("createUserRequest");

        if (createUserRequest != null) {
            CreateUserResponse createUserResponse = userService.addUser(createUserRequest);
            req.setAttribute("createUserResponse", createUserResponse);
            resp.addCookie(new Cookie("admin", "true"));
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user data.");
        }
    }

}