package com.rental_clothes_management_system.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import com.rental_clothes_management_system.DAO.RentalDAO;
import com.rental_clothes_management_system.model.ClothesModel;
import com.rental_clothes_management_system.model.RentalModel;
import com.rental_clothes_management_system.model.UserModel;

@WebServlet("/rental/*")
public class RentalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();

        if (path == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (path.equals("/create")) {

            HttpSession session = request.getSession(false);

            if (session == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }

            UserModel user = (UserModel) session.getAttribute("user");
            List<ClothesModel> cart = (List<ClothesModel>) session.getAttribute("cart");

            if (user == null || cart == null || cart.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/cart");
                return;
            }

            try {
                RentalDAO dao = new RentalDAO();

                dao.createRental(user.getUserId(), cart);

                session.removeAttribute("cart");

                response.getWriter().write("success");

            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500, "Rental creation failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        UserModel user = (UserModel) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        try {
            RentalDAO dao = new RentalDAO();

            List<RentalModel> rentals = dao.getUserRentals(user.getUserId());

            request.setAttribute("rentals", rentals);

            request.getRequestDispatcher("/WEB-INF/pages/user_rentals.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "Unable to load rentals");
        }
    }
}