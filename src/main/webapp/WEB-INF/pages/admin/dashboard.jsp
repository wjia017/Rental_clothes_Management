<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>

<style>
body {
    margin:0;
    font-family: 'Plus Jakarta Sans';
    background:#F8F9FC;
}

.sidebar {
    width:220px;
    height:100vh;
    background:#6C63FF;
    color:white;
    position:fixed;
    padding:20px;
}

.sidebar a {
    display:block;
    color:white;
    padding:10px;
    margin:10px 0;
    text-decoration:none;
}

.main {
    margin-left:240px;
    padding:20px;
}

.card {
    background:#fff;
    padding:20px;
    border-radius:10px;
    margin-bottom:20px;
}
</style>

<body>

<h1>Admin Panel</h1>

<ul>
    <li><a href="manage-users">Manage Users</a></li>
    <li><a href="manage-clothes">Manage Clothes</a></li>
    <li><a href="manage-rentals">Manage Rentals</a></li>
</ul>

</body>
</html>
