package com.twu.biblioteca;

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
}
