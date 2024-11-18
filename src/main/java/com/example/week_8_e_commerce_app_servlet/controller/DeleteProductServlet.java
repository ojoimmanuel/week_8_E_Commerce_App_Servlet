package com.example.week_8_e_commerce_app_servlet.controller;

import com.example.week_8_e_commerce_app_servlet.dao.ProductDao;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
        productDao.deleteProduct(id);

        ProductListServlet productListServlet = new ProductListServlet();
        productListServlet.products(request);

        response.sendRedirect("admin.jsp");
    }
}

