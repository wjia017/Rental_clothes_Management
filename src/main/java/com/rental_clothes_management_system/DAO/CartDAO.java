package com.rental_clothes_management_system.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rental_clothes_management_system.utils.DBconfig;

public class CartDAO {

    // ADD TO CART
    public void addToCart(int userId, int clothId) {

        try {
            Connection con = DBconfig.getConnection();

            if (con == null) {
                System.out.println("DB connection failed");
                return;
            }

            String sql = "INSERT INTO rental_cart(user_id, cloth_id) VALUES(?,?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            pst.setInt(2, clothId);

            pst.executeUpdate();

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // REMOVE FROM CART
    public void removeFromCart(int cartId) {

        try {
            Connection con = DBconfig.getConnection();

            String sql = "DELETE FROM rental_cart WHERE cart_id=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cartId);

            pst.executeUpdate();

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}