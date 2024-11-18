package com.example.week_8_e_commerce_app_servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "productsByCategoryServlet", value = "/productsByCategory")
public class ProductsByCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductListServlet productListServlet = new ProductListServlet();
        productListServlet.products(request);

        String referer = request.getHeader("Referer");

        if (referer != null) {
            response.sendRedirect(referer);
        } else {
            response.sendRedirect("home.jsp");
        }
    }
}

