package com.rental_clothes_management_system.DAO;

import java.sql.*;
import java.util.*;

import com.rental_clothes_management_system.model.ClothesModel;
import com.rental_clothes_management_system.utils.DBconfig;

public class ClothesDAO {

    // GET ALL
    public List<ClothesModel> getAll(String category, String status) throws Exception {

        List<ClothesModel> list = new ArrayList<>();

        Connection con = DBconfig.getConnection();

        String sql = "SELECT * FROM clothes WHERE 1=1";

        List<Object> params = new ArrayList<>();

        if (category != null && !category.isEmpty()) {
            sql += " AND category_id = ?";
            params.add(Integer.parseInt(category));
        }

        if (status != null && !status.isEmpty()) {
            sql += " AND status = ?";
            params.add(status);
        }

        PreparedStatement pst = con.prepareStatement(sql);

        for (int i = 0; i < params.size(); i++) {
            pst.setObject(i + 1, params.get(i));
        }

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            ClothesModel c = new ClothesModel();

            c.setClothId(rs.getInt("cloth_id"));
            c.setName(rs.getString("name"));
            c.setCategoryId(rs.getInt("category_id"));
            c.setPrice(rs.getDouble("price"));
            c.setStock(rs.getInt("stock"));
            c.setStatus(rs.getString("status"));
            c.setImage(rs.getString("image"));

            list.add(c);
        }

        rs.close();
        pst.close();
        con.close();

        return list;
    }

    // GET BY ID
    public ClothesModel getById(int id) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "SELECT * FROM clothes WHERE cloth_id=?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        ClothesModel c = null;

        if (rs.next()) {
            c = new ClothesModel();

            c.setClothId(rs.getInt("cloth_id"));
            c.setName(rs.getString("name"));
            c.setCategoryId(rs.getInt("category_id"));
            c.setPrice(rs.getDouble("price"));
            c.setStock(rs.getInt("stock"));
            c.setStatus(rs.getString("status"));
            c.setImage(rs.getString("image"));
        }

        rs.close();
        pst.close();
        con.close();

        return c;
    }

    // ADD CLOTHES
    public void addClothes(String name, int categoryId, double price, int stock, String image) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "INSERT INTO clothes(name, category_id, price, stock, status, image) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, name);
        pst.setInt(2, categoryId);
        pst.setDouble(3, price);
        pst.setInt(4, stock);
        pst.setString(5, "AVAILABLE");
        pst.setString(6, image);

        pst.executeUpdate();

        pst.close();
        con.close();
    }

    // DELETE
    public void deleteClothes(int id) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "DELETE FROM clothes WHERE cloth_id=?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);

        pst.executeUpdate();

        pst.close();
        con.close();
    }

    // UPDATE
    public void updateClothes(int id, String name, int categoryId,
                              double price, int stock, String status) throws Exception {

        Connection con = DBconfig.getConnection();

        String sql = "UPDATE clothes SET name=?, category_id=?, price=?, stock=?, status=? WHERE cloth_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, name);
        pst.setInt(2, categoryId);
        pst.setDouble(3, price);
        pst.setInt(4, stock);
        pst.setString(5, status);
        pst.setInt(6, id);

        pst.executeUpdate();

        pst.close();
        con.close();
    }
}