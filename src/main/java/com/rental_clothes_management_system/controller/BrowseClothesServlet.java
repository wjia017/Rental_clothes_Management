package com.rental_clothes_management_system.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.rental_clothes_management_system.DAO.ClothesDAO;

@WebServlet("/browse")
public class BrowseClothesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String category = request.getParameter("category");
        String status = request.getParameter("status");

        ClothesDAO dao = new ClothesDAO();

        try {
            request.setAttribute("clothesList",
                    dao.getAll(category, status));

            request.getRequestDispatcher("/WEB-INF/pages/browse.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}