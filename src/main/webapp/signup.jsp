<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
<h1>Create an Account</h1>
<form action="/signup" method="post">
    <label>First Name:</label>
    <input type="text" name="firstName" required>

    <label>Last Name:</label>
    <input type="text" name="lastName" required>

    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Password:</label>
    <input type="password" name="password" required>

<%--    <label>Sign Up as Admin</label>--%>
<%--    <input type="checkbox" name="isAdmin" value="true">--%>

    <input type="submit" value="Sign Up">
</form>
</body>
</html>
