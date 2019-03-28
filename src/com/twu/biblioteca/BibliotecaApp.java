package com.twu.biblioteca;

import com.twu.biblioteca.util.InputOutputUtil;
import com.twu.biblioteca.view.BookView;
import com.twu.biblioteca.view.MovieView;

import java.util.*;

public class BibliotecaApp {

    private static BookView bookView = new BookView();
    private static MovieView movieView = new MovieView();


    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static List<String> getMenuOptions() {
        List<String> options = new ArrayList<String>();
        options.add("1 - List of books");
        options.add("2 - Checkout a book");
        options.add("3 - Return a book");
        options.add("4 - List of movies");
        options.add("5 - Checkout a movie");
        options.add("\n0 - Exit");
        return options;
    }

    public static void printMenuOptions() {
        List<String> menuOptions = BibliotecaApp.getMenuOptions();
        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    public static Object chooseOption(int option) {
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                bookView.printBooks();
                return true;
            case 2:
                if (bookView.checkoutBook(bookView.getCheckoutBookId())) {
                    return bookView.checkoutBookSuccessMessage();
                } else {
                    return bookView.checkoutBookErrorMessage();
                }
            case 3:
                if (bookView.returnBook(bookView.getReturnBookId())) {
                    return bookView.returnBookSuccessMessage();
                } else {
                    return bookView.returnBookErrorMessage();
                }
            case 4:
                movieView.printMovies();
                return true;
            case 5:
                if (movieView.checkoutMovie(movieView.getCheckoutMovieId())) {
                    return movieView.checkoutMovieSuccessMessage();
                } else {
                    return movieView.checkoutMovieErrorMessage();
                }
            default:
                return InputOutputUtil.getInvalidOptionErrorMessage();
        }
    }

    public static void main(String[] args) {
        System.out.println(getWelcomeMessage());
        do {
            printMenuOptions();
            Integer option = InputOutputUtil.readOption();
            if (option != null) {
                Object selectedOptionResult = chooseOption(option);
                if (selectedOptionResult instanceof String) {
                    System.out.println(selectedOptionResult);
                }
            }
        } while (true);
    }
}
