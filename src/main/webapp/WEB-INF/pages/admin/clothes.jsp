<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage Clothes</title>

<link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;600;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-clothes.css">

</head>
<body>

<div class="container">

    <h1>👗 Clothes Management</h1>

    <!-- ADD FORM -->
    <form action="${pageContext.request.contextPath}/add-clothes" method="post" class="form-card">
        <input type="text" name="name" placeholder="Cloth Name" required>
        <input type="text" name="category" placeholder="Category" required>
        <input type="number" name="price" placeholder="Price" required>
        <input type="number" name="stock" placeholder="Stock" required>
        <button type="submit">Add Clothes</button>
    </form>

    <!-- TABLE -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="c" items="${clothesList}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.category}</td>
                    <td>${c.price}</td>
                    <td>${c.stock}</td>

                    <td>
                        <a href="edit-clothes?id=${c.id}" class="edit">Edit</a>
                        <a href="delete-clothes?id=${c.id}" class="delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>