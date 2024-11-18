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

@WebServlet(name = "EditProductServlet", value = "/editProduct")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required.");
        }
        int productId = Integer.parseInt(idParam);

        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
        Product product = productDao.getProductById(productId);
        request.setAttribute("product", product);

        List<Category> categories = new CategoryDao(ConnectionUtil.getConnection()).getAllCategories();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required.");
        }
        int id = Integer.parseInt(idParam);

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
        productDao.updateProduct(product);

        ProductListServlet productListServlet = new ProductListServlet();
        productListServlet.products(request);

        response.sendRedirect("admin.jsp");
    }
}

