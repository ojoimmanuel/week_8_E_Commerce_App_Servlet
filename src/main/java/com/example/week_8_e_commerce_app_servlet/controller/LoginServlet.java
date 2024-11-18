package com.example.week_8_e_commerce_app_servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

@WebServlet(name = "loginServlet", value = "/")

public class LoginServlet extends HttpServlet {
    private static String adminEmail = "admin@gmail.com";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/week8_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password123";

    ProductListServlet productListServlet = new ProductListServlet();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        if (action.equals("/login-servlet")) {
            loginServlet(request, response);
        } else {
            indexPage(request, response);
        }
    }

    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productListServlet.products(request);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    public void loginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productListServlet.products(request);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                String sql = "SELECT * FROM user WHERE email=? AND password=?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, email);
                    statement.setString(2, password);
                    try (ResultSet result = statement.executeQuery()) {
                        if (result.next()) {
                            String userEmail = result.getString("email");
                            request.getSession().setAttribute("email", userEmail);
                            request.getSession().setAttribute("userId", result.getInt("id"));

                            if(adminEmail.equalsIgnoreCase(userEmail)) {
                                response.sendRedirect("admin.jsp");
                            } else {
                                request.getRequestDispatcher("customer.jsp").forward(request, response);
                            }
                        } else {
                            response.sendRedirect("signup-error.jsp");
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                response.sendRedirect("signup-error.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("signup-error.jsp");
        }
    }
}

