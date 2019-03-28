package com.twu.biblioteca.view;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookViewTest {

    private static BookView bookView = new BookView();

    @Test
    public void shouldNotCheckoutBook() {
        assertFalse(bookView.checkoutBook(null));
    }

    @Test
    public void shouldCheckoutBook() {
        assertTrue(bookView.checkoutBook(1));
    }

    @Test
    public void shouldNotReturnBook() {
        assertFalse(bookView.returnBook(null));
    }

    @Test
    public void shouldReturnBook() {
        assertTrue(bookView.returnBook(1));
    }
}
