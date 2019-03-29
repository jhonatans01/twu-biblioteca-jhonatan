package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Rent;
import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class RentControllerTest {

    RentController rentController = new RentController();

    @Test
    public void shouldAddNewRentForBook() {
        User user = new User("", "");
        Book book = new Book();

        Rent rent = new Rent(user, book);
        assertTrue(rentController.add(rent));
    }

    @Test
    public void shouldNotAddNewRentForNullObject() {
        assertFalse(rentController.add(null));
    }

    @Test
    public void shouldFindNewRent() {
        User user = new User("123-1234", "123");
        Book book = new Book();

        rentController.add(new Rent(user, book));
        assertNotNull(rentController.find(user, book));
    }

    @Test
    public void shouldNotFindRentForNullArguments() {
        assertNull(rentController.find(null, null));
    }

    @Test
    public void shouldNotFindRentForNonExistingData() {
        assertNull(rentController.find(new User("", ""), new Book()));
    }

    @Test
    public void shouldReturnRent() {
        User user = new User("123-1234", "123");
        Book book = new Book("title", "author", "0000");

        Rent rent = new Rent(user, book);
        rentController.add(rent);
        assertTrue(rentController.returnRent(rent));
    }

    @Test
    public void shouldNotReturnRentForNonExistingData() {
        assertFalse(rentController.returnRent(new Rent(new User("", ""), new Book())));
    }

    @Test
    public void shouldNotReturnRentForNullArguments() {
        assertFalse(rentController.returnRent(null));
    }
}
