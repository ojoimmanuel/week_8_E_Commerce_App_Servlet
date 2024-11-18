package com.example.week_8_e_commerce_app_servlet.controller;

import com.example.week_8_e_commerce_app_servlet.dao.CartDao;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "addToCartServlet", value = "/addToCart")

public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = 1;
        int userId = (int) request.getSession().getAttribute("userId");

        try (Connection connection = ConnectionUtil.getConnection()) {
            CartDao cartDao = new CartDao(connection);
            int cartId = cartDao.getOrCreateCartId(userId);
            cartDao.addToCart(cartId, productId, quantity);

            request.getRequestDispatcher("customer.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

