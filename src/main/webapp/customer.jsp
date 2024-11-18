<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/12/2024
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Customer Dashboard</title>
</head>
<body>
<h1>Welcome User</h1>
<p>Welcome, ${email} to your dashboard</p>

<div align="center">
  <h2>Store</h2>
  <a href="viewCart">View Cart</a> <br /> <br />
  <a href="viewLikedProducts">View Liked Products</a>

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

