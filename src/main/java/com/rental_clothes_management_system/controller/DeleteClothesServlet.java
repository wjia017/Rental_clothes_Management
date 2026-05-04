package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.rental_clothes_management_system.DAO.ClothesDAO;

@WebServlet("/delete-clothes")
public class DeleteClothesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            ClothesDAO dao = new ClothesDAO();
            dao.deleteClothes(id);

            response.sendRedirect(request.getContextPath() + "/admin/clothes");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}