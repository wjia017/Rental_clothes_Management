package com.rental_clothes_management_system.DAO;

import java.sql.*;
import java.util.*;

import com.rental_clothes_management_system.model.ClothesModel;
import com.rental_clothes_management_system.model.RentalModel;
import com.rental_clothes_management_system.utils.DBconfig;

public class RentalDAO {

    // =========================
    // CREATE RENTAL
    // =========================
    public void createRental(int userId, List<ClothesModel> cart) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "INSERT INTO rentals(user_id, status, start_date) VALUES (?, 'PENDING', CURDATE())";

        PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, userId);

        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        rs.next();
        int rentalId = rs.getInt(1);

        // insert items
        String sql2 = "INSERT INTO rental_items(rental_id, cloth_id) VALUES (?, ?)";

        PreparedStatement pst2 = con.prepareStatement(sql2);

        for (ClothesModel c : cart) {
            pst2.setInt(1, rentalId);
            pst2.setInt(2, c.getClothId());
            pst2.addBatch();
        }

        pst2.executeBatch();

        pst.close();
        pst2.close();
        con.close();
    }

    // =========================
    // GET USER RENTALS (FIXED)
    // =========================
    public List<RentalModel> getUserRentals(int userId) throws Exception {

        List<RentalModel> list = new ArrayList<>();

        Connection con = DBconfig.getConnection();

        String sql = "SELECT * FROM rentals WHERE user_id=? ORDER BY rental_id DESC";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, userId);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            RentalModel r = new RentalModel();

            r.setRentalId(rs.getInt("rental_id"));
            r.setUserId(rs.getInt("user_id"));
            r.setStatus(rs.getString("status"));
            r.setStartDate(rs.getDate("start_date"));
            r.setReturnDate(rs.getDate("return_date"));

            list.add(r);
        }

        rs.close();
        pst.close();
        con.close();

        return list;
    }

    // =========================
    // UPDATE STATUS
    // =========================
    public void updateStatus(int rentalId, String status) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "UPDATE rentals SET status=? WHERE rental_id=?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, status);
        pst.setInt(2, rentalId);

        pst.executeUpdate();

        pst.close();
        con.close();
    }

    // =========================
    // STOCK LOGIC (BASIC PLACEHOLDER)
    // =========================
    public void reduceStock(int rentalId) throws Exception {
        // implement later using JOIN rental_items
    }

    public void restoreStock(int rentalId) throws Exception {
        // implement later
    }
}