package com.rental_clothes_management_system.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.rental_clothes_management_system.DAO.ClothesDAO;

@WebServlet("/add-clothes")
public class AddClothesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            int categoryId = Integer.parseInt(request.getParameter("category_id"));
            double price = Double.parseDouble(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            String image = request.getParameter("image");

            ClothesDAO dao = new ClothesDAO();
            dao.addClothes(name, categoryId, price, stock, image);

            response.sendRedirect(request.getContextPath() + "/admin/clothes");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error adding clothes");
        }
    }
}