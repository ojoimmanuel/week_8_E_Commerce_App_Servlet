package com.example.week_8_e_commerce_app_servlet.controller;


import com.example.week_8_e_commerce_app_servlet.dao.CategoryDao;
import com.example.week_8_e_commerce_app_servlet.dao.ProductDao;
import com.example.week_8_e_commerce_app_servlet.model.Category;
import com.example.week_8_e_commerce_app_servlet.model.Product;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "addToProductServlet", value = "/products")
public class ProductListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        products(request);
//        String referer = request.getHeader("Referer");
//
//        if (referer != null) {
//            // Redirect back to the referer URL
//            response.sendRedirect(referer);
//        } else {
//            // Fallback if Referer header is missing
//            response.sendRedirect("home.jsp");
//        }

    }

    public void products(HttpServletRequest request) throws ServletException, IOException {
        int categoryId = 0;

        // Get the selected category from the request
        if (request.getParameter("categoryId") != null && !request.getParameter("categoryId").isEmpty()) {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        }

        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
        List<Product> products;
        if (categoryId == 0) {
            products = productDao.getAllProducts();
        } else {
            products = productDao.getProductsByCategory(categoryId);
        }

        CategoryDao categoryDao = new CategoryDao(ConnectionUtil.getConnection());
        List<Category> categories = categoryDao.getAllCategories();

//        request.setAttribute("products", products);
        request.getSession().setAttribute("products", products);
        request.getSession().setAttribute("categories", categories);

    }
}

