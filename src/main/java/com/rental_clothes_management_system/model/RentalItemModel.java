package com.rental_clothes_management_system.model;

public class RentalItemModel {
    private int id;
    private int rentalId;
    private int clothId;

    // Getters
    public int getId() {
        return id;
    }

    public int getRentalId() {
        return rentalId;
    }

    public int getClothId() {
        return clothId;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public void setClothId(int clothId) {
        this.clothId = clothId;
    }
}