<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Manage Rentals</title>
</head>

<body>

<h2>Rental Requests</h2>

<table border="1">

<tr>
    <th>User</th>
    <th>Cloth</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<c:forEach var="r" items="${rentalList}">
<tr>
    <td>${r.userName}</td>
    <td>${r.clothName}</td>
    <td>${r.status}</td>

    <td>
        <a href="approve?rentalId=${r.rentalId}">Approve</a>
        <a href="reject?rentalId=${r.rentalId}">Reject</a>
    </td>
</tr>
</c:forEach>

</table>

</body>
</html>