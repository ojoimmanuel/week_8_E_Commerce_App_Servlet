<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<header>
    <h1>Welcome to the Product Store</h1>
    <p>Find quality products at unbeatable prices.</p>

    <div class="auth-links">
        <a href="signup.jsp">Sign Up</a> |
        <a href="login.jsp">Sign In</a>
    </div>
</header>

<div align="center">
    <h2>Product Store</h2>

    <!-- Category Selection -->
    <form method="get" action="productsByCategory-">
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

    <!-- Display table of products -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
<%--            <th>Category</th>--%>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
<%--                <td>${product.category.name}</td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>





