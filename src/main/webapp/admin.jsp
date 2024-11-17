<%--
  Created by IntelliJ IDEA.
  User: EMY-W11
  Date: 11/13/2024
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.model.Product" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.dao.ProductDao" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.model.Category" %>
<%@ page import="com.example.week_8_e_commerce_app_servlet.controller.ProductListServlet" %>

<%
//    ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());
//    List<Product> products = productDao.getAllProducts();

//    ProductListServlet productListServlet = new ProductListServlet();
//    List<Product> products = productListServlet.products(request);
//    List<Category> categories = productDao.getProductsByCategory()
%>

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

    <!-- Category Selection -->
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

    <!-- Display table of products -->
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



<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: EMY-W11--%>
<%--  Date: 11/13/2024--%>
<%--  Time: 10:28 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="com.example.week_8_e_commerce_app_servlet.model.Product" %>--%>
<%--<%@ page import="com.example.week_8_e_commerce_app_servlet.dao.ProductDao" %>--%>
<%--<%@ page import="com.example.week_8_e_commerce_app_servlet.util.ConnectionUtil" %>--%>
<%--<%@ page import="com.example.week_8_e_commerce_app_servlet.model.Category" %>--%>

<%--&lt;%&ndash;&lt;%&ndash;%>--%>
<%--&lt;%&ndash;    ProductDao productDao = new ProductDao(ConnectionUtil.getConnection());&ndash;%&gt;--%>
<%--&lt;%&ndash;    List<Product> products = productDao.getAllProducts();&ndash;%&gt;--%>

<%--&lt;%&ndash;//    List<Category> categories = productDao.getProductsByCategory()&ndash;%&gt;--%>
<%--&lt;%&ndash;%>&ndash;%&gt;--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Welcome User</h1>--%>
<%--<p>Welcome, ${email} to your dashboard</p>--%>

<%--<div align="center">--%>
<%--    <h2>Store Management</h2>--%>
<%--    <a href="addProduct.jsp">Add New Product</a> <br /> <br />--%>

<%--    <!-- Category Selection -->--%>
<%--    <form method="get" action="productsByCategory">--%>
<%--        <label for="category">Filter by Category:</label>--%>
<%--        <select name="categoryId" id="category">--%>
<%--            <option value="">All Categories</option>--%>
<%--            <%--%>
<%--                // Assuming 'categories' is set in the request and is a List<Category>--%>
<%--                List<Category> categories = (List<Category>) request.getAttribute("categories");--%>
<%--                if (categories != null) {--%>
<%--                    for (Category category : categories) {--%>
<%--            %>--%>
<%--            <option value="<%= category.getId() %>"><%= category.getName() %></option>--%>
<%--            <%--%>
<%--                    }--%>
<%--                }--%>
<%--            %>--%>
<%--            &lt;%&ndash;            <c:forEach var="category" items="${categories}">&ndash;%&gt;--%>
<%--            &lt;%&ndash;                <option value="${category.id}">${category.name}</option>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            </c:forEach>&ndash;%&gt;--%>
<%--        </select>--%>
<%--        <button type="submit">Filter</button>--%>
<%--    </form>--%>
<%--    <br />--%>

<%--    <!-- Display table of products -->--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Description</th>--%>
<%--            <th>Price</th>--%>
<%--            &lt;%&ndash;            <th>Category</th>&ndash;%&gt;--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>

<%--        <%--%>
<%--            if (products != null) {--%>
<%--                for (Product product : products) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%= product.getId() %></td>--%>
<%--            <td><%= product.getName() %></td>--%>
<%--            <td><%= product.getDescription() %></td>--%>
<%--            <td><%= product.getPrice() %></td>--%>
<%--            &lt;%&ndash;                <td><%= product.getCategory().getName() %></td> &ndash;%&gt;--%>
<%--            <td>--%>
<%--                <a href="editProduct.jsp?id=<%= product.getId() %>">Edit</a>--%>
<%--                <a href="deleteProduct?id=<%= product.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <%--%>
<%--                }--%>
<%--            }--%>
<%--        %>--%>

<%--    </table>--%>
<%--    <a href="logout">Log out</a> <br /> <br />--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

