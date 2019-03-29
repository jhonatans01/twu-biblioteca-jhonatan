package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> users;

    public UserController() {
        users = new ArrayList<User>();

        users.add(new User("123-1234", "123"));
        users.add(new User("234-2345", "123"));
    }

    public User find(String libraryNumber, String password) {
        for (User user: users) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
