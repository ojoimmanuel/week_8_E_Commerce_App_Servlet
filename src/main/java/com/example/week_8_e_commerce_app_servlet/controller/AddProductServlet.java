package com.example.week_8_e_commerce_app_servlet.controller;


import com.example.week_8_e_commerce_app_servlet.dao.ProductDao;
import com.example.week_8_e_commerce_app_servlet.model.Product;
import com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "addProductToServlet", value = "/addProduct")

public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
        productDao.addProducts(product);

        ProductListServlet productListServlet = new ProductListServlet();
        productListServlet.products(request);

        response.sendRedirect("/addProduct-success.jsp");
//        } else {
//            response.sendRedirect("/addProduct-error.jsp");
//        }

    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
//        List<Product> products = productDao.getAllProducts();
//        request.setAttribute("products", products);
//        request.getSession().setAttribute("email", "admin@gmail.com"); // example email for testing
//
//        // Forward to the admin dashboard
//        request.getRequestDispatcher("admin.jsp").forward(request, response);
//    }

}

