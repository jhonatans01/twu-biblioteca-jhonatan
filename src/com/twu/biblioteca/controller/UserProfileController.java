package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Profile;
import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserProfileController {

    List<User> users = new ArrayList<User>();

    public UserProfileController() {

        User user = new User("123-1234", "123");
        user.setProfile(new Profile("Librarian", "librarian@domain.com", "1100-0000"));
        users.add(user);

        user = new User("123-1234", "123");
        user.setProfile(new Profile("Customer 1", "customer1@domain.com", "0100-0000"));
        users.add(user);

        user = new User("234-2345", "123");
        user.setProfile(new Profile("Customer 2", "customer2@domain.com", "010-0000"));
        users.add(user);
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
