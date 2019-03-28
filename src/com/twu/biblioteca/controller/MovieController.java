package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieController {
    List<Movie> movies;

    public MovieController() {
        movies = new ArrayList<Movie>();

        Movie newMovie = new Movie("Movie name 1", "Director name 1", "5");
        movies.add(newMovie);

        newMovie = new Movie("Movie name 2", "Director name 2", "8");
        movies.add(newMovie);

        newMovie = new Movie("Movie name 3", "Director name 3", "10");
        movies.add(newMovie);
    }

    public List<Movie> list() {
        return movies;
    }
}
