package com.rental_clothes_management_system.service;

import com.rental_clothes_management_system.DAO.RentalDAO;

public class RentalService {

    RentalDAO dao = new RentalDAO();

    // APPROVE RENTAL
    public void approveRental(int rentalId) throws Exception {
    	dao.updateStatus(rentalId, "APPROVED");
    	dao.reduceStock(rentalId);
    }

    // RETURN RENTAL
    public void returnRental(int rentalId) throws Exception {
    	dao.updateStatus(rentalId, "RETURNED");
    	dao.restoreStock(rentalId);
    }

    // REJECT
    public void rejectRental(int rentalId) throws Exception {
    	dao.updateStatus(rentalId, "REJECTED");
    }
}
