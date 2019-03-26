package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import org.junit.Test;


import static org.junit.Assert.*;

public class BookControllerTest {

    @Test
    public void shouldReturnBooksList() {
        BookController bookController = new BookController();
        assertNotNull(bookController.list());
    }
}
