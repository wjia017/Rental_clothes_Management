package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.rental_clothes_management_system.utils.SessionUtil;
/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SessionUtil.invalidate(request);
        response.sendRedirect(request.getContextPath() + "/login");
    }
}