package com.rental_clothes_management_system.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.DBconfig;
import com.rental_clothes_management_system.utils.SessionUtil;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            UserModel user = (UserModel) SessionUtil.getAttribute(request, "user");

            if (user == null) {
                response.sendRedirect("login");
                return;
            }

            Connection con = DBconfig.getConnection();

            String sql = "SELECT * FROM rentals WHERE user_id=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, user.getUserId());

            ResultSet rs = pst.executeQuery();

            List<Map<String, Object>> history = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();

                row.put("rental_id", rs.getInt("rental_id"));
                row.put("status", rs.getString("status"));
                row.put("start_date", rs.getDate("start_date"));
                row.put("return_date", rs.getDate("return_date"));

                history.add(row);
            }

            request.setAttribute("history", history);

            rs.close();
            pst.close();
            con.close();

            request.getRequestDispatcher("/WEB-INF/pages/history.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}