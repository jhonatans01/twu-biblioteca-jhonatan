package com.twu.biblioteca.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserControllerTest {

    private UserController userController = new UserController();

    @Test
    public void shouldNotFindUserWithNullCredentials() {
        assertNull(userController.find(null, null));
    }

    @Test
    public void shouldNotFindUserWithEmptyCredentials() {
        assertNull(userController.find("", ""));
    }

    @Test
    public void shouldFindUser() {
        assertNotNull(userController.find("123-1234", "123"));
    }
}
