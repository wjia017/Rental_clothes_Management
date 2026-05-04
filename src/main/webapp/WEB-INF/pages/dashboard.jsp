<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/dashboard.css">
</head>

<body>

<div class="sidebar">
    <h2>RentWear</h2>

    <a href="browse">Browse Clothes</a>
    <a href="cart">Cart</a>
    <a href="rentals">My Rentals</a>
    <a href="logout">Logout</a>
</div>

<div class="main">
    <h1>Welcome ${user.firstName}</h1>
</div>

</body>
</html>