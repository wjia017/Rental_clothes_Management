package com.rental_clothes_management_system.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.*;

import com.rental_clothes_management_system.model.ClothesModel;
import com.rental_clothes_management_system.DAO.ClothesDAO;
import com.rental_clothes_management_system.DAO.CartDAO;
import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.DBconfig;
import com.rental_clothes_management_system.model.CartModel;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    CartDAO dao = new CartDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            UserModel user = (UserModel) request.getSession().getAttribute("user");

            if (user == null) {
                response.sendRedirect("login");
                return;
            }

            Connection con = DBconfig.getConnection();

            String sql = "SELECT * FROM rental_cart WHERE user_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user.getUserId());

            ResultSet rs = pst.executeQuery();

            List<CartModel> list = new ArrayList<>();

            while (rs.next()) {
                CartModel c = new CartModel();
                c.setCartId(rs.getInt("cart_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setClothId(rs.getInt("cloth_id"));
                list.add(c);
            }

            request.setAttribute("cartList", list);

            request.getRequestDispatcher("/WEB-INF/pages/cart.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            UserModel user = (UserModel) request.getSession().getAttribute("user");

            if (user == null) {
                response.sendError(401);
                return;
            }

            String action = request.getParameter("action");

            if ("add".equals(action)) {

                int clothId = Integer.parseInt(request.getParameter("clothId"));
                dao.addToCart(user.getUserId(), clothId);

                response.getWriter().write("added");

            } else if ("remove".equals(action)) {

                int cartId = Integer.parseInt(request.getParameter("cartId"));
                dao.removeFromCart(cartId);

                response.getWriter().write("removed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}