package com.rental_clothes_management_system.service;

import com.rental_clothes_management_system.DAO.UserDAO;
import com.rental_clothes_management_system.model.UserModel;
import com.rental_clothes_management_system.utils.PasswordUtil;

public class LoginService {

    private UserDAO dao = new UserDAO();

    public UserModel authenticate(String username, String password) throws Exception {
        // Step 1: Fetch user from DB by username only using the login method
        UserModel user = dao.login(username);

        // Step 2: If user exists, check if the plain-text password matches the stored hash
        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
            return user;
        }

        // Return null if user doesn't exist or password is wrong
        return null;
    }
}