<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/17/2024
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Liked Products</title>
</head>
<body>
<h1>Liked Products</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${likedProducts}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
<a href="customer.jsp">Back</a>
</body>
</html>

