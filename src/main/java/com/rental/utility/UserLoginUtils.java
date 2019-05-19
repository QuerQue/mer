package com.rental.utility;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.rental.security.UserLogin;

@Service
public class UserLoginUtils {

    private UserLoginUtils() {
    }

    public static UserLogin getUserLogin() {
        Object principal;

        try {
            principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (NullPointerException e) {
            return null;
        }

        if (principal == null || !(principal instanceof UserLogin)) {
            return null;
        }

        return (UserLogin) principal;
    }
}