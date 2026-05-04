package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.PasswordUtil;
import com.rental_clothes_management_system.DAO.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
        	String firstName = request.getParameter("firstName");
        	String lastName = request.getParameter("lastName");
        	String username = request.getParameter("username");
        	String email = request.getParameter("email");
        	String phone = request.getParameter("phone");
        	String password = request.getParameter("password");

            System.out.println("REGISTER DATA: " + username); // DEBUG

            UserModel user = new UserModel();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setEmail(email);
            user.setPhone(phone);
            user.setPassword(password);

            UserDAO dao = new UserDAO();
            dao.register(user);

            System.out.println("USER INSERTED SUCCESS"); // DEBUG

            response.sendRedirect(request.getContextPath() + "/login?success=1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}