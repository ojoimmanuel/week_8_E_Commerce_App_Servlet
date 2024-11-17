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

//@WebServlet("/addToCart")
@WebServlet(name = "addToCartServlet", value = "/addToCart")

public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = 1; // Default quantity, or you can pass it as a parameter

        // Assuming you have a way to get the logged-in user's ID
        int userId = (int) request.getSession().getAttribute("userId");
//        String userEmail = (String) request.getSession().getAttribute("email");
//        request.setAttribute("email", userEmail);

//        LoginServlet loginServlet = new LoginServlet();
//        loginServlet.products(request);

        try (Connection connection = ConnectionUtil.getConnection()) {
            CartDao cartDao = new CartDao(connection);
            int cartId = cartDao.getOrCreateCartId(userId);
            cartDao.addToCart(cartId, productId, quantity);

            request.getRequestDispatcher("customer.jsp").forward(request, response);

//            response.sendRedirect("customer.jsp"); // Redirect back to products page
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

