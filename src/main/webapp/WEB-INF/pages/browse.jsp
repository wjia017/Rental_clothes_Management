<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Browse Clothes</title>


<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;600;700&display=swap" rel="stylesheet">

<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/browse.css">

<style>
    body {
        font-family: 'Plus Jakarta Sans', sans-serif;
        background: #F8F9FC;
        margin: 0;
    }

    h2 {
        text-align: center;
        color: #2D3436;
        margin: 20px 0;
    }

    .grid {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
        gap: 20px;
        padding: 30px;
    }

    .card {
        background: #FFFFFF;
        border-radius: 15px;
        padding: 15px;
        box-shadow: 0 5px 15px rgba(0,0,0,0.05);
        text-align: center;
        transition: 0.3s;
    }

    .card:hover {
        transform: translateY(-5px);
    }

    .card img {
        width: 100%;
        height: 180px;
        object-fit: cover;
        border-radius: 10px;
    }

    .card h3 {
        margin: 10px 0;
        color: #2D3436;
    }

    .price {
        color: #6C63FF;
        font-weight: bold;
    }

    .btn {
        background: #6C63FF;
        color: white;
        border: none;
        padding: 10px;
        width: 100%;
        border-radius: 8px;
        cursor: pointer;
        margin-top: 10px;
    }

    .btn:hover {
        background: #574fd6;
    }
</style>


</head>

<body>

<h2>Browse Clothes</h2>

<div class="grid">


<c:forEach var="c" items="${clothes}">
    <div class="card">

        <!-- IMAGE -->
        <img src="${pageContext.request.contextPath}/images/${c.image}" alt="Clothes">

        <h3>${c.name}</h3>

        <p class="price">Rs. ${c.price}</p>

        <!-- ADD TO CART -->
        <form action="${pageContext.request.contextPath}/cart" method="post">
    <input type="hidden" name="action" value="add">
    <input type="hidden" name="clothId" value="${c.id}">
    <button class="btn">Add to Cart</button>
</form>

    </div>
</c:forEach>


</div>

</body>
</html>
