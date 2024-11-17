<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/12/2024
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.model.Category" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.dao.CategoryDao" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil" %>
<%
    CategoryDao categoryDao = new CategoryDao(ConnectionUtil.getConnection());
    List<Category> categories = categoryDao.getAllCategories();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add New Product</h1>
<form action="/addProduct" method="post">
    <label>Name:</label>
    <input type="text" name="name" required>
    <label>Description:</label>
    <textarea name="description"></textarea>
    <label>Price:</label>
    <input type="number" name="price" step="0.01" required>
<%--    <label>Quantity:</label>--%>
<%--    <input type="number" name="quantity" required>--%>
    <label for="category">Category:</label>
    <select id="category" name="categoryId" required>
        <option value="">--Select Category--</option>
        <%
            for (Category category : categories) {
        %>
        <option value="<%= category.getId() %>"><%= category.getName() %></option>
        <%
            }
        %>
    </select><br><br>
    <input type="submit" value="Add Product">
</form>
</body>
</html>

