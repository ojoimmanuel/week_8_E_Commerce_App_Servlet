//package com.example.week_8_e_commerce_app_servlet.controller;
//
//import com.example.week_8_e_commerce_app_servlet.dao.ProductDao;
//import com.example.week_8_e_commerce_app_servlet.model.Product;
//import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.*;
//import java.sql.*;
//import java.util.List;
//
////@WebServlet(name = "loginServlet", value = "/login-servlet")
//@WebServlet(name = "loginServlet", value = "/")
////@WebServlet("/")
//
//public class IndexServlet extends HttpServlet {
//    private static String adminEmail = "admin@gmail.com";
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/week8_db";
//    private static final String JDBC_USER = "root";
//    private static final String JDBC_PASSWORD = "password123";
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//            indexPage(request, response);
//        }
//
//
//
//    public void products(HttpServletRequest request) throws ServletException, IOException {
//        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
//        List<Product> products = productDao.getAllProducts();
//        request.setAttribute("products", products);
////        request.getSession().setAttribute("email", "admin@gmail.com"); // example email for testing
//
//        // Forward to the admin dashboard
////        request.getRequestDispatcher("admin.jsp").forward(request, response);
//
//    }
//
//    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        products(request);
//        request.getRequestDispatcher("home.jsp").forward(request, response);
//    }
//
//    public void loginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        products(request);
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//                String sql = "SELECT * FROM user WHERE email=? AND password=?";
//                try (PreparedStatement statement = conn.prepareStatement(sql)) {
//                    statement.setString(1, email);
//                    statement.setString(2, password);
//                    try (ResultSet result = statement.executeQuery()) {
//                        if (result.next()) {
//                            // User authenticated
//                            String userEmail = result.getString("email");
//                            request.setAttribute("email", userEmail);
//                            request.getSession().setAttribute("userId", result.getInt("id"));
//
////                            doGet(request, response);
//                            products(request);
//
//
//                            // check if user is admin by email
//                            if(adminEmail.equalsIgnoreCase(userEmail)) {
//                                request.getRequestDispatcher("admin.jsp").forward(request, response);
////                                response.sendRedirect("admin.jsp");
//                            } else {
//                                request.getRequestDispatcher("customer.jsp").forward(request, response);
////                                response.sendRedirect("customer-login-success.jsp");
//                            }
//
//                        } else {
//                            // Invalid credentials
//                            response.sendRedirect("signup-error.jsp");
//                        }
//                    }
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                response.sendRedirect("signup-error.jsp");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            response.sendRedirect("signup-error.jsp");
//        }
//
//    }
//}
//
