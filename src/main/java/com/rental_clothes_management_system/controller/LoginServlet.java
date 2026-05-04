package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.rental_clothes_management_system.service.LoginService;
import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.SessionUtil;
import com.rental_clothes_management_system.DAO.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Opens the login page
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            UserDAO dao = new UserDAO();
            UserModel user = dao.login(username);

            if (user != null && user.getPassword().equals(password)) {

                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // ADMIN vs USER
                if ("ADMIN".equals(user.getRole())) {
                    response.sendRedirect("/admin-dashboard");
                } else {
                    response.sendRedirect("/dashboard");
                }
                

            } else {
                request.setAttribute("error", "Invalid Credentials");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}