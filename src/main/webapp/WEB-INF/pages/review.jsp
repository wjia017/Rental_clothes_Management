<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Review</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/review.css">
</head>
<body>

<h2>Leave Review</h2>

<form action="review" method="post">

    <input type="hidden" name="rentalId" value="${rental.id}">

    <label>Rating</label>
    <select name="rating">
        <option>5</option>
        <option>4</option>
        <option>3</option>
        <option>2</option>
        <option>1</option>
    </select>

    <label>Comment</label>
    <textarea name="comment"></textarea>

    <button>Submit</button>

</form>

</body>
</html>