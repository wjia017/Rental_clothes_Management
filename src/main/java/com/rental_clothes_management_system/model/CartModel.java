package com.rental_clothes_management_system.model;

public class CartModel {
    private int cartId;
    private int userId;
    private int clothId;

    public int getCartId() { return cartId; }
    public void setCartId(int cartId) { this.cartId = cartId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getClothId() { return clothId; }
    public void setClothId(int clothId) { this.clothId = clothId; }
}