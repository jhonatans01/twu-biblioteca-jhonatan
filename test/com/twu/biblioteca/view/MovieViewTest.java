package com.twu.biblioteca.view;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieViewTest {

    private static MovieView movieView = new MovieView();

    @Test
    public void shouldNotCheckoutMovie() {
        assertFalse(movieView.checkoutMovie(null));
    }

    @Test
    public void shouldCheckoutMovie() {
        assertTrue(movieView.checkoutMovie(1));
    }
}
