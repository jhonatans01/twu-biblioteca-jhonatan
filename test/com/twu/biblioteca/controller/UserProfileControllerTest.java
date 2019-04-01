package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileControllerTest {

    private UserProfileController userProfileController = new UserProfileController();

    @Test
    public void shouldNotFindUserWithNullCredentials() {
        assertNull(userProfileController.find(null, null));
    }

    @Test
    public void shouldNotFindUserWithEmptyCredentials() {
        assertNull(userProfileController.find("", ""));
    }

    @Test
    public void shouldFindUser() {
        assertNotNull(userProfileController.find("123-1234", "123"));
    }

    @Test
    public void shouldFindUserAndProfileNotNull() {
        User user = userProfileController.find("123-1234", "123");
        assertNotNull(user.getProfile());
    }
}
