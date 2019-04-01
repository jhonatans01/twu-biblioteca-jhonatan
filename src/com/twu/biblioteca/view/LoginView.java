package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.UserProfileController;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.InputOutputUtil;
import com.twu.biblioteca.util.LoginUtil;

public class LoginView {

    private static UserProfileController userProfileController = new UserProfileController();
    private static LoginUtil session;

    public LoginView() {
        session = LoginUtil.getInstance();
    }

    public boolean authenticate() {
        String libraryNumber = getLibraryNumber();
        String password = getPassword();

        User user = userProfileController.find(libraryNumber, password);
        if (user != null) {
            session.setUser(user);
            return true;
        }
        return false;
    }


    public String getLibraryNumber() {
        System.out.print("Insert your library number and press enter: ");
        return InputOutputUtil.readString();
    }

    public String getPassword() {
        System.out.print("Insert your password and press enter: ");
        return InputOutputUtil.readString();
    }

    public String authenticateErrorMessage() {
        return "These credentials were not found in our database.";
    }

    public String authenticateSuccessMessage() {
        return "You're logged in.";
    }
}
