//package com.example.week_8_e_commerce_app_servlet.controller;
//
//import com.example.week_8_e_commerce_app_servlet.dao.CartDao;
//import com.example.week_8_e_commerce_app_servlet.model.CartItem;
//import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet("/removeItemFromCart")
//public class RemoveItemFromCartServlet extends HttpServlet {
//
//        @Override
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            // Get user ID from the session
//            HttpSession session = request.getSession();
//            int userId = (int) session.getAttribute("userId"); // Assuming the user ID is stored in the session
//
//            // Get product name from the request
//            String productName = request.getParameter("name");
//
//            if (productName == null || productName.isEmpty()) {
//                response.sendRedirect("error.jsp"); // Redirect to an error page if product name is missing
//                return;
//            }
//
//            try (Connection connection = ConnectionUtil.getConnection()) {
//                // SQL query to delete from cart based on product name
//                String deleteByNameSQL = """
//                DELETE FROM cart_items
//                WHERE user_id = ? AND product_id = (
//                    SELECT id FROM products WHERE name = ?
//                )""";
//
//                try (PreparedStatement ps = connection.prepareStatement(deleteByNameSQL)) {
//                    ps.setInt(1, userId);
//                    ps.setString(2, productName);
//                    int rowsAffected = ps.executeUpdate();
//
//                    if (rowsAffected == 0) {
//                        System.out.println("No matching item found to delete.");
//                    }
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                response.sendRedirect("error.jsp"); // Redirect to an error page in case of a database error
//                return;
//            }
//
//            // Redirect back to the cart page after removing the item
//            response.sendRedirect("viewCart.jsp");
//        }
//    }
