<%@ page import="com.example.week_8_e_commerce_app_servlet.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/12/2024
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<jsp:useBean id="products" class="com.example.week_8_e_commerce_app_servlet.dao.ProductDao" scope="session" />--%>
<%--<jsp:setProperty name="products" property="*" />--%>



<html>
<head>
  <title>Customer Dashboard</title>
</head>
<body>
<h1>Welcome User</h1>
<p>Welcome, ${email} to your dashboard</p>

<div align="center">
  <h2>Store</h2>
  <!-- Link to view the cart -->
  <a href="viewCart">View Cart</a> <br /> <br />
  <a href="viewLikedProducts">View Liked Products</a>

<%--  <form method="get" action="productsByCategory">--%>
<%--    <label for="category">Filter by Category:</label>--%>
<%--    <select name="categoryId" id="category">--%>
<%--      <option value="">All Categories</option>--%>
<%--      <c:forEach var="category" items="${categories}">--%>
<%--        <option value="${category.id}">${category.name}</option>--%>
<%--      </c:forEach>--%>
<%--    </select>--%>
<%--    <button type="submit">Filter</button>--%>
<%--  </form>--%>
<%--  <br />--%>


  <!-- Display table of products -->
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
<%--      <th>Category</th>--%>
      <th>Actions</th>
    </tr>
<%--    <% List<Product> productList = products.getAllProducts(); %>--%>
<%--    <% List<Product> productList = (List<Product>) request.getAttribute("products");%>--%>

    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
<%--        <td>${product.category.name}</td>--%>
        <td>
          <!-- Add to Cart and Like actions for each product -->
          <a href="addToCart?id=${product.id}">Add to Cart</a>
          <a href="removeFromCart?id=${product.id}">Remove from Cart</a>
          <a href="likeProduct?id=${product.id}">Like/Unlike</a>
        </td>
      </tr>
    </c:forEach>
  </table>
  <a href="logout">Log out</a> <br /> <br />

</div>
</body>
</html>

