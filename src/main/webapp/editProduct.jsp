<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/17/2024
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<%
    String productId = request.getParameter("id");
    // Fetch product details using productId and populate form fields
%>
<form method="post" action="editProduct">
    <input type="hidden" name="id" value="<%= productId %>" />
<%--    <input type="hidden" name="id" value="${product.id}" />--%>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${product.name}" required /> <br /><br />

    <label for="description">Description:</label>
    <textarea id="description" name="description" required>${product.description}</textarea> <br /><br />

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" value="${product.price}" step="0.01" required /> <br /><br />

    <label for="category">Category:</label>
    <select id="category" name="categoryId" required>
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}" ${product.category.id == category.id ? "selected" : ""}>
                    ${category.name}
            </option>
        </c:forEach>
    </select> <br /><br />

    <button type="submit">Update Product</button>
    <a href="admin.jsp">Cancel</a>
</form>
</body>
</html>
