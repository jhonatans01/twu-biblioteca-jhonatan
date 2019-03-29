package com.twu.biblioteca.util;

import com.twu.biblioteca.model.User;

public class LoginUtil {
    private static LoginUtil instance = null;
    private User user;

    private LoginUtil() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public static LoginUtil getInstance() {
        if (instance == null) {
            instance = new LoginUtil();
        }
        return instance;
    }
}
