package com.example.week_8_e_commerce_app_servlet.controller;

import com.example.week_8_e_commerce_app_servlet.dao.CartDao;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        int productId = Integer.parseInt(request.getParameter("id"));

        try (Connection connection = ConnectionUtil.getConnection()) {
            CartDao cartDao = new CartDao(connection);
            int cartId = cartDao.getOrCreateCartId(userId);
            cartDao.removeFromCart(cartId, productId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("customer.jsp");
    }
}
