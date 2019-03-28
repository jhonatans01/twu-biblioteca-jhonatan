package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.MovieController;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.util.InputOutputUtil;

public class MovieView {

    private static MovieController movieController = new MovieController();

    public void printMovies() {
        for (Movie movie : movieController.list()) {
            if (movie.isAvailable()) {
                System.out.println(movie);
            }
        }
    }

    public boolean checkoutMovie(Integer id) {
        if (id != null) {
            Movie movie = movieController.find(id);
            if (movie != null) {
                return movieController.checkout(movie);
            }
        }
        return false;
    }

    public Integer getCheckoutMovieId() {
        System.out.print("Insert the id of the movie which you want to checkout and press enter: ");
        return InputOutputUtil.readOption();
    }

    public String checkoutMovieSuccessMessage() {
        return "Thank you! Enjoy the movie\n";
    }

    public String checkoutMovieErrorMessage() {
        return "Sorry, that movie is not available\n";
    }
}
