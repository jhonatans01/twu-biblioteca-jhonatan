package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieController {
    List<Movie> movies;

    public MovieController() {
        movies = new ArrayList<Movie>();

        Movie newMovie = new Movie("Movie name 1", "Director name 1", "5");
        newMovie.setId(1);
        movies.add(newMovie);

        newMovie = new Movie("Movie name 2", "Director name 2", "8");
        newMovie.setId(2);
        movies.add(newMovie);

        newMovie = new Movie("Movie name 3", "Director name 3", "10");
        newMovie.setId(3);
        movies.add(newMovie);
    }

    public Movie find(Integer id) {
        for (Movie movie: movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> list() {
        return movies;
    }

    public boolean checkout(Movie movieToCheckout) {
        if (movieToCheckout != null) {
            for (Movie movie: movies) {
                if (movie.getId() == movieToCheckout.getId() && movie.isAvailable()) {
                    movie.setAvailable(false);
                    movies.set(movies.indexOf(movie), movie);
                    return true;
                }
            }
        }
        return false;
    }
}
