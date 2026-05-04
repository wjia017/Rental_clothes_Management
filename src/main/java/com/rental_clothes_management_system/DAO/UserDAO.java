package com.rental_clothes_management_system.DAO;

import java.sql.*;
import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.DBconfig;

public class UserDAO {

    // ✅ Check username exists
    public boolean checkUsername(String username) throws Exception {
        Connection con = DBconfig.getConnection();

        String sql = "SELECT * FROM users WHERE username=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);

        ResultSet rs = pst.executeQuery();

        boolean exists = rs.next();

        rs.close();
        pst.close();
        con.close();

        return exists;
    }

    // ✅ Register user (default PENDING)
    public void register(UserModel user) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "INSERT INTO users (first_name,last_name,username,email,phone,password,role,status) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, user.getFirstName());
        pst.setString(2, user.getLastName());
        pst.setString(3, user.getUsername());
        pst.setString(4, user.getEmail());
        pst.setString(5, user.getPhone());
        pst.setString(6, user.getPassword());
        pst.setString(7, "USER");
        pst.setString(8, "PENDING"); // 👈 IMPORTANT for admin approval

        int rows = pst.executeUpdate();

        System.out.println("Rows inserted: " + rows); // DEBUG

        pst.close();
        con.close();
    }

    // ✅ LOGIN WITH PASSWORD + STATUS CHECK
 // Method signature must take ONLY one String parameter
    public UserModel login(String username) throws Exception {
        Connection con = DBconfig.getConnection();
        
        // SQL query only filters by username
        String sql = "SELECT * FROM users WHERE username = ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        UserModel user = null;
        if (rs.next()) {
            user = new UserModel();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password")); // This is the BCrypt hash
            user.setRole(rs.getString("role"));
            user.setStatus(rs.getString("status"));
        }

        rs.close();
        pst.close();
        con.close();
        return user;
    }

    // ✅ ADMIN: GET ALL USERS
    public ResultSet getAllUsers() throws Exception {
        Connection con = DBconfig.getConnection();
        String sql = "SELECT * FROM users";
        PreparedStatement pst = con.prepareStatement(sql);
        return pst.executeQuery();
    }

    // ✅ ADMIN: APPROVE USER
    public void approveUser(int userId) throws Exception {
        Connection con = DBconfig.getConnection();

        String sql = "UPDATE users SET status='APPROVED' WHERE user_id=?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, userId);
        pst.executeUpdate();

        pst.close();
        con.close();
    }
}