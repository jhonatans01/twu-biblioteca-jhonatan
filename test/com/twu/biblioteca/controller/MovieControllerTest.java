package com.twu.biblioteca.controller;

import com.twu.biblioteca.controller.MovieController;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieControllerTest {

    private MovieController movieController = new MovieController();
    private ArrayList<Movie> moviesList;

    @Before
    public void setUp() {
        moviesList = (ArrayList<Movie>) movieController.list();
    }

    @Test
    public void shouldReturnMoviesList() {
        assertNotNull(moviesList);
    }

    @Test
    public void shouldNotCheckoutAMovieWithNullObject() {
        assertFalse(movieController.checkout(null));
    }

    @Test
    public void shouldNotCheckoutAMovieWithNullId() {
        assertFalse(movieController.checkout(new Movie()));
    }

    @Test
    public void shouldCheckoutAMovie() {
        if (!moviesList.isEmpty()) {
            Movie singleBook = moviesList.get(0);
            assertTrue(movieController.checkout(singleBook));
        } else {
            fail("Movies list is empty");
        }
    }
}
