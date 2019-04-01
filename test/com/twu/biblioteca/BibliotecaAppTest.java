package com.twu.biblioteca;


import com.twu.biblioteca.util.InputOutputUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    private BibliotecaApp app = new BibliotecaApp();
    private List<String> menuOptions = app.getMenuOptions();

    @Test
    public void shouldReturnWelcomeMessage() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", app.getWelcomeMessage());
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
        assertEquals(app.chooseOption(-1), InputOutputUtil.getInvalidOptionErrorMessage());
    }

    @Test
    public void shouldChooseMenuOptionWithErrorForNonAvailableOption() {
        assertEquals(app.chooseOption(999), InputOutputUtil.getInvalidOptionErrorMessage());
    }

    @Test
    public void shouldChooseMenuOptionWithSuccess() {
        assertTrue(app.chooseOption(1) instanceof Boolean);
    }
}
