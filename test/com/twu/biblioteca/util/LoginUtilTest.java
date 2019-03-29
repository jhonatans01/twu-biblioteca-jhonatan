package com.twu.biblioteca.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginUtilTest {

    LoginUtil util;

    @Before
    public void setUp() {
        util = util.getInstance();
    }

    @Test
    public void shouldNotGetUser() {
        assertNull(util.getUser());
    }
}
