package com.twu.biblioteca.view;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookViewTest {

    private static BookView bookView = new BookView();
    private static User user = new User("000-0000", "000");

    @Test
    public void shouldNotCheckoutBookForNullUserAndId() {
        assertFalse(bookView.checkoutBook(null, null));
    }

    @Test
    public void shouldCheckoutBook() {
        assertTrue(bookView.checkoutBook(user, 1));
    }

    @Test
    public void shouldNotReturnBookForNotCheckedOutBook() {
        assertFalse(bookView.returnBook(user, 2));
    }

    @Test
    public void shouldReturnBook() {
        assertTrue(bookView.returnBook(user, 1));
    }
}
