package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private List<String> menuOptions;

    @Before
    public void setUp() {
        menuOptions = BibliotecaApp.getMenuOptions();
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", BibliotecaApp.getWelcomeMessage());
    }

    @Test
    public void shouldReturnOptionsMenu() {
        assertNotNull(menuOptions);
    }

    @Test
    public void shouldReturnOptionsMenuNotEmpty() {
        assertTrue(!menuOptions.isEmpty());
    }

    @Test
    public void shouldChooseMenuOptionWithErrorForNegativeNumber() {
        assertEquals(BibliotecaApp.chooseOption(-1), BibliotecaApp.getMenuOptionErrorMessage());
    }

    @Test
    public void shouldChooseMenuOptionWithErrorForNonAvailableOption() {
        assertEquals(BibliotecaApp.chooseOption(999), BibliotecaApp.getMenuOptionErrorMessage());
    }

    @Test
    public void shouldChooseMenuOptionWithSuccess() {
        assertTrue(BibliotecaApp.chooseOption(1) instanceof Boolean);
    }

    @Test
    public void shouldNotCheckoutBook() {
        assertFalse(BibliotecaApp.checkoutBook(null));
    }

    @Test
    public void shouldCheckoutBook() {
        assertTrue(BibliotecaApp.checkoutBook(1));
    }
}
