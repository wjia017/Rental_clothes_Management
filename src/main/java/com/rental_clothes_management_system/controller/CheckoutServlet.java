package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.DBconfig;
import com.rental_clothes_management_system.utils.SessionUtil;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            UserModel user = (UserModel) SessionUtil.getAttribute(request, "user");

            if (user == null) {
                response.sendRedirect("login");
                return;
            }

            Connection con = DBconfig.getConnection();

            // 1. create rental
            String sql = "INSERT INTO rentals(user_id, status, start_date) VALUES(?,?,CURDATE())";

            PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, user.getUserId());
            pst.setString(2, "PENDING");

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            rs.next();

            int rentalId = rs.getInt(1);

            // 2. move cart → rental_items
            String sql2 = "INSERT INTO rental_items(rental_id, cloth_id) "
                        + "SELECT ?, cloth_id FROM rental_cart WHERE user_id=?";

            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setInt(1, rentalId);
            pst2.setInt(2, user.getUserId());

            pst2.executeUpdate();

            // 3. clear cart
            PreparedStatement pst3 = con.prepareStatement(
                    "DELETE FROM rental_cart WHERE user_id=?"
            );
            pst3.setInt(1, user.getUserId());
            pst3.executeUpdate();

            con.close();

            response.sendRedirect(request.getContextPath() + "/dashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}