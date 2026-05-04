package com.rental_clothes_management_system.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.rental_clothes_management_system.utils.DBconfig;

public class ReviewDAO {

    public void addReview(int userId, int clothId, int rentalId,
                          int rating, String comment) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "INSERT INTO reviews(user_id, cloth_id, rental_id, rating, comment) "
                   + "VALUES(?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, userId);
        pst.setInt(2, clothId);
        pst.setInt(3, rentalId);
        pst.setInt(4, rating);
        pst.setString(5, comment);

        pst.executeUpdate();

        pst.close();
        con.close();
    }
}