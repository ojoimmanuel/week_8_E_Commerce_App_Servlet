<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/14/2024
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Your Cart</title>
</head>
<body>
<h1>Your Cart</h1>
<table border="1">
    <tr>
<%--        <th>Product ID</th>--%>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
    </tr>
    <c:forEach var="item" items="${cartItems}">
        <tr>
<%--            <td>${item.id}</td>--%>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.price * item.quantity}</td>
<%--            <td>--%>
<%--                <a href="removeItemFromCart?id=${item.name}">Remove from Cart</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
</table>

<p><strong>Total Amount: ${totalAmount}</strong></p>
<a href="customer.jsp">Back</a>

</body>
</html>


