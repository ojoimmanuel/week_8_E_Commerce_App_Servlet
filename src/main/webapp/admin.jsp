<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/13/2024
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Welcome User</h1>
<p>Welcome, ${email} to your dashboard</p>

<div align="center">
    <h2>Store Management</h2>
    <a href="addProduct.jsp">Add New Product</a> <br /> <br />

    <form method="get" action="productsByCategory">
        <label for="category">Filter by Category:</label>
        <select name="categoryId" id="category">
            <option value="">All Categories</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Filter</button>
    </form>
    <br />

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
<%--            <th>Category</th>--%>
            <th>Actions</th>
        </tr>

        <c:forEach var="product" items="${products}">

            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            <%--                <td><%= product.getCategory().getName() %></td> --%>
                <td>
                    <a href="editProduct.jsp?id=${product.id}">Edit</a>
                    <a href="deleteProduct?id=${product.id}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <a href="logout">Log out</a> <br /> <br />

</div>
</body>
</html>
