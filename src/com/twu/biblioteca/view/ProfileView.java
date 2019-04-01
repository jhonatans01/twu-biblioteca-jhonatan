package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Profile;
import com.twu.biblioteca.model.User;

public class ProfileView {

    public void printInformation(User user) {
        Profile profile = user.getProfile();
        if (profile != null) {
            System.out.println("Name: " + profile.getName());
            System.out.println("Email: " + profile.getEmail());
            System.out.println("Phone: " + profile.getPhone());
        }
    }
}
