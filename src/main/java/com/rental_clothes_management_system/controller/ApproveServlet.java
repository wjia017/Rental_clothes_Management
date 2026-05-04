package com.rental_clothes_management_system.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.rental_clothes_management_system.DAO.RentalDAO;

@WebServlet("/admin/rental/*")
public class ApproveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        String idParam = request.getParameter("id");

        if (path == null || idParam == null) {
            response.sendRedirect(request.getContextPath() + "/admin/rentals");
            return;
        }

        int rentalId = Integer.parseInt(idParam);

        RentalDAO dao = new RentalDAO();

        try {
            switch (path) {

                case "/approve":
                    dao.updateStatus(rentalId, "APPROVED");
                    break;

                case "/reject":
                    dao.updateStatus(rentalId, "REJECTED");
                    break;

                case "/return":
                    dao.updateStatus(rentalId, "RETURNED");
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/admin/rentals");
    }
}