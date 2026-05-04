<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Clothes</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-clothes.css">
</head>
<body>

<div class="container">
    <h2>Edit Clothes</h2>

    <form action="${pageContext.request.contextPath}/update-clothes" method="post">
        <input type="hidden" name="id" value="${cloth.id}">

        <input type="text" name="name" value="${cloth.name}">
        <input type="text" name="category" value="${cloth.category}">
        <input type="number" name="price" value="${cloth.price}">
        <input type="number" name="stock" value="${cloth.stock}">

        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>