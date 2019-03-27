package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookControllerTest {

    private BookController bookController = new BookController();
    private ArrayList<Book> booksList;

    @Before
    public void setUp() {
        booksList = (ArrayList<Book>) bookController.list();
    }

    @Test
    public void shouldReturnBooksList() {
        assertNotNull(booksList);
    }

    @Test
    public void shouldReturnBooksWithAuthor() {
        if (!booksList.isEmpty()) {
            Book singleBook = booksList.get(0);
            assertNotNull("Author is null", singleBook.getAuthor());
        } else {
            fail("Books list is empty");
        }
    }

    @Test
    public void shouldReturnBooksWithPublicationYear() {
        if (!booksList.isEmpty()) {
            Book singleBook = booksList.get(0);
            assertNotNull("Publication year is null", singleBook.getPublicationYear());
        } else {
            fail("Books list is empty");
        }
    }

    @Test
    public void shouldNotCheckoutABook() {
        Book singleBook = new Book();
        assertFalse(bookController.checkout(singleBook));
    }

    @Test
    public void shouldCheckoutABook() {
        if (!booksList.isEmpty()) {
            Book singleBook = booksList.get(0);
            assertTrue(bookController.checkout(singleBook));
        } else {
            fail("Books list is empty");
        }
    }

    @Test
    public void shouldCheckoutABookAndSetUnavailable() {
        if (!booksList.isEmpty()) {
            Book singleBook = booksList.get(0);
            bookController.checkout(singleBook);

            booksList = (ArrayList<Book>) bookController.list();
            singleBook = booksList.get(0);

            assertFalse(singleBook.isAvailable());
        } else {
            fail("Books list is empty");
        }
    }
}
