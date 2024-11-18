<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
<h1>Sign In</h1>
<form action="/login-servlet" method="post">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Password:</label>
    <input type="password" name="password" required>

    <input type="submit" value="Sign In">
</form>
</body>
</html>
