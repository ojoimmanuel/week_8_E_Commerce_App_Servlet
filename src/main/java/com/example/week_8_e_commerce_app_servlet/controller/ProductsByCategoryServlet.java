package com.example.week_8_e_commerce_app_servlet.controller;

import com.example.week_8_e_commerce_app_servlet.dao.CategoryDao;
import com.example.week_8_e_commerce_app_servlet.dao.ProductDao;
import com.example.week_8_e_commerce_app_servlet.model.Category;
import com.example.week_8_e_commerce_app_servlet.model.Product;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productsByCategoryServlet", value = "/productsByCategory")
public class ProductsByCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


//        String categoryIdParam = request.getParameter("categoryId");
//        List<Product> products;
//        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
//        try  {
//            if (categoryIdParam == null || categoryIdParam.isEmpty()) {
//                // No category selected, fetch all products
//                products = productDao.getAllProducts();
//            } else {
//                int categoryId = Integer.parseInt(categoryIdParam);
//                products = productDao.getProductsByCategory(categoryId);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            products = null;
//        }

//        int categoryId = 0;
//
//        // Get the selected category from the request
//        if (request.getParameter("categoryId") != null && !request.getParameter("categoryId").isEmpty()) {
//            categoryId = Integer.parseInt(request.getParameter("categoryId"));
//        }
//
//        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
//        List<Product> products;
//        if (categoryId == 0) {
//            products = productDao.getAllProducts();
//        } else {
//            products = productDao.getProductsByCategory(categoryId);
//        }
//
//        // Set attributes for JSP
//        CategoryDao categoryDao = new CategoryDao(ConnectionUtil.getConnection());
//        List<Category> categories = categoryDao.getAllCategories();
//
//
//        request.getSession().setAttribute("products", products);
//        request.getSession().setAttribute("categories", categories);
//        request.setAttribute("categories", new CategoryDao(ConnectionUtil.getConnection()).getAllCategories());
//        request.getRequestDispatcher("admin.jsp").forward(request, response);

//        request.setAttribute("products", products);
//        request.setAttribute("categories", categories);
//        request.getRequestDispatcher("admin.jsp").forward(request, response);
//        response.sendRedirect("admin.jsp");

        ProductListServlet productListServlet = new ProductListServlet();
        productListServlet.products(request);


        String referer = request.getHeader("Referer");

        if (referer != null) {
            // Redirect back to the referer URL
            response.sendRedirect(referer);
        } else {
            // Fallback if Referer header is missing
            response.sendRedirect("home.jsp");
        }

    }
}

