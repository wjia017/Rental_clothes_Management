package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.rental_clothes_management_system.utils.DBconfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.rental_clothes_management_system.DAO.AdminDAO;

/**
 * Servlet implementation class AdminDashboardServlet
 */

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            AdminDAO dao = new AdminDAO();

            request.setAttribute("totalUsers", dao.countUsers());
            request.setAttribute("totalClothes", dao.countClothes());
            request.setAttribute("pendingRentals", dao.countPendingRentals());

            request.getRequestDispatcher("/WEB-INF/pages/admin/dashboard.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}