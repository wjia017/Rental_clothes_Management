package com.rental_clothes_management_system.DAO;

import java.sql.*;

import com.rental_clothes_management_system.utils.DBconfig;

public class AdminDAO {

    public int countUsers() throws Exception {
        Connection con = DBconfig.getConnection();

        String sql = "SELECT COUNT(*) FROM user";
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    public int countClothes() throws Exception {
        Connection con = DBconfig.getConnection();

        String sql = "SELECT COUNT(*) FROM clothes";
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }

    public int countPendingRentals() throws Exception {
        Connection con = DBconfig.getConnection();

        String sql = "SELECT COUNT(*) FROM rental WHERE status='PENDING'";
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt(1);
    }
}