package com.rental_clothes_management_system.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    // Set session attribute with timeout
    public static void setAttribute(HttpServletRequest request, String key, Object value, int timeoutSeconds) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
        session.setMaxInactiveInterval(timeoutSeconds);
    }

    // Get session attribute
    public static Object getAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return session.getAttribute(key);
        }
        return null;
    }

    // Remove single attribute
    public static void removeAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(key);
        }
    }

    // Invalidate session (logout)
    public static void invalidate(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}