<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Cart</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
.cart-item {
    display: flex;
    justify-content: space-between;
    background: white;
    padding: 12px;
    margin-bottom: 10px;
    border-radius: 10px;
}
button {
    background: #FF4D4F;
    color: white;
    border: none;
    padding: 6px 10px;
    cursor: pointer;
}
</style>

</head>
<body>

<h2>Your Cart</h2>

<div id="cartBox">

    <c:forEach var="c" items="${cartList}">
        <div class="cart-item" id="item-${c.cartId}">
            <div>
                Cloth ID: ${c.clothId}
            </div>

            <button onclick="removeItem(${c.cartId})">
                Remove
            </button>
        </div>
    </c:forEach>

</div>

<script>

function addToCart(userId, clothId) {

    $.post("cart", {
        action: "add",
        userId: userId,
        clothId: clothId
    }, function(response) {
        alert("Added to cart!");
    });
}

function removeItem(cartId) {

    $.post("cart", {
        action: "remove",
        cartId: cartId
    }, function(response) {
        $("#item-" + cartId).remove();
    });
}

</script>

</body>
</html>