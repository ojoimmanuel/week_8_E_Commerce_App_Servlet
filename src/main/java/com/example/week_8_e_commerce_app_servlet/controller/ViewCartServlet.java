package com.example.week_8_e_commerce_app_servlet.controller;

import com.example.week_8_e_commerce_app_servlet.dao.CartDao;
import com.example.week_8_e_commerce_app_servlet.model.CartItem;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/viewCart")

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");

        try (Connection connection = ConnectionUtil.getConnection()) {
            CartDao cartDao = new CartDao(connection);
            int cartId = cartDao.getOrCreateCartId(userId);
            List<CartItem> items = cartDao.getCartItems(cartId);

            double totalAmount = items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();

            request.setAttribute("cartItems", items);
            request.setAttribute("totalAmount", totalAmount);
            request.getRequestDispatcher("viewCart.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

