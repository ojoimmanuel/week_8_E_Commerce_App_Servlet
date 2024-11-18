package com.example.week_8_e_commerce_app_servlet.dao;

import com.example.week_8_e_commerce_app_servlet.model.CartItem;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private Connection connection;

    public CartDao(Connection connection) {
        this.connection = ConnectionUtil.getConnection();
    }

    public int getOrCreateCartId(int userId) throws SQLException {
        String selectCart = "SELECT id FROM cart WHERE user_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectCart);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        } else {
            String insertCart = "INSERT INTO cart (user_id) VALUES (?)";
            preparedStatement = connection.prepareStatement(insertCart, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }

    public void addToCart(int cartId, int productId, int quantity) throws SQLException {
        String query = "INSERT INTO cart_item (cart_id, product_id, quantity) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, cartId);
        preparedStatement.setInt(2, productId);
        preparedStatement.setInt(3, quantity);
        preparedStatement.setInt(4, quantity);
        preparedStatement.executeUpdate();
    }

    public void removeFromCart(int cartId, int productId) throws SQLException {
        String query = "DELETE FROM cart_item WHERE cart_id = ? AND product_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, cartId);
        preparedStatement.setInt(2, productId);
        preparedStatement.executeUpdate();
    }

    public List<CartItem> getCartItems(int cartId) throws SQLException {
        String query = "SELECT ci.id, ci.quantity, p.name, p.price " +
                "FROM cart_item ci JOIN product p ON ci.product_id = p.id " +
                "WHERE ci.cart_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, cartId);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<CartItem> items = new ArrayList<>();
        while (resultSet.next()) {
            CartItem item = new CartItem(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("quantity"));
            items.add(item);
        }
        return items;
    }
}

