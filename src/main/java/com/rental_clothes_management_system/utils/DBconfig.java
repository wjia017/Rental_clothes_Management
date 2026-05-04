package com.rental_clothes_management_system.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconfig {

    private static final String URL = "jdbc:mysql://localhost:3307/rental_system";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ Database Connected Successfully");

        } catch (Exception e) {
            System.out.println("❌ Database Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}