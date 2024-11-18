package com.example.week_8_e_commerce_app_servlet.dao;

import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeProductDao {
    private Connection connection;

    public LikeProductDao(Connection connection) {
        this.connection = ConnectionUtil.getConnection();
    }

        public void likeOrUnlike (int userId, int productId){
            try {
                String checkLikedQuery = "SELECT * FROM liked_products WHERE user_id = ? AND product_id = ?";
                try (PreparedStatement checkStmt = connection.prepareStatement(checkLikedQuery)) {
                    checkStmt.setInt(1, userId);
                    checkStmt.setInt(2, productId);
                    try (ResultSet rs = checkStmt.executeQuery()) {
                        if (rs.next()) {
                            // Product is already liked, unlike it
                            String deleteQuery = "DELETE FROM liked_products WHERE user_id = ? AND product_id = ?";
                            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                                deleteStmt.setInt(1, userId);
                                deleteStmt.setInt(2, productId);
                                deleteStmt.executeUpdate();
                            }
                        } else {
                            // Product is not liked, like it
                            String insertQuery = "INSERT INTO liked_products (user_id, product_id) VALUES (?, ?)";
                            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                                insertStmt.setInt(1, userId);
                                insertStmt.setInt(2, productId);
                                insertStmt.executeUpdate();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
  }