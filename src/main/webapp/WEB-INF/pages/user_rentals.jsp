<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>My Rentals</title>
</head>

<body>

<h2>My Rentals</h2>

<table border="1">

<tr>
    <th>Cloth</th>
    <th>Status</th>
    <th>Start Date</th>
    <th>Return Date</th>
</tr>

<c:forEach var="r" items="${rentals}">
<tr>
    <td>${r.clothName}</td>
    <td>${r.status}</td>
    <td>${r.startDate}</td>
    <td>${r.returnDate}</td>
</tr>
</c:forEach>

</table>

</body>
</html>