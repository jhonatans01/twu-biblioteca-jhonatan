package com.twu.biblioteca;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.InputOutputUtil;
import com.twu.biblioteca.util.LoginUtil;
import com.twu.biblioteca.view.BookView;
import com.twu.biblioteca.view.LoginView;
import com.twu.biblioteca.view.MovieView;
import com.twu.biblioteca.view.ProfileView;

import java.util.*;

public class BibliotecaApp {

    private static BookView bookView = new BookView();
    private static MovieView movieView = new MovieView();
    private static LoginView loginView = new LoginView();
    private static ProfileView profileView = new ProfileView();
    private static LoginUtil session;

    public BibliotecaApp() {
        session = session.getInstance();
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<String> getMenuOptions() {
        User user = session.getUser();
        List<String> options = new ArrayList<String>();
        options.add("1 - List of available books");
        options.add("2 - Checkout a book");
        options.add("3 - Return a book");
        options.add("4 - List of movies");
        options.add("5 - Checkout a movie");
        options.add("6 - List of checked out books");
        if (user != null) {
            options.add("7 - View profile information");
        }
        options.add("\n0 - Exit");
        return options;
    }

    public void printMenuOptions() {
        List<String> menuOptions = getMenuOptions();
        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    public void authenticate() {
        while (!loginView.authenticate()) {
            System.out.println(loginView.authenticateErrorMessage());
        }
        System.out.println(loginView.authenticateSuccessMessage());
    }

    public Object chooseOption(int option) {
        User user;

        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                bookView.printBooks();
                return true;
            case 2:
                user = session.getUser();
                if (user == null) {
                    authenticate();
                    return chooseOption(2);
                } else {
                    if (bookView.checkoutBook(user, bookView.getCheckoutBookId())) {
                        return bookView.checkoutBookSuccessMessage();
                    } else {
                        return bookView.checkoutBookErrorMessage();
                    }
                }
            case 3:
                user = session.getUser();
                if (user == null) {
                    authenticate();
                    return chooseOption(3);
                } else {
                    if (bookView.returnBook(user, bookView.getReturnBookId())) {
                        return bookView.returnBookSuccessMessage();
                    } else {
                        return bookView.returnBookErrorMessage();
                    }
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
            case 6:
                bookView.printCheckedOutBooks();
                return true;
            case 7:
                user = session.getUser();
                if (user == null) {
                    authenticate();
                    return chooseOption(7);
                } else {
                    profileView.printInformation(user);
                    return true;
                }

            default:
                return InputOutputUtil.getInvalidOptionErrorMessage();
        }
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        System.out.println(app.getWelcomeMessage());
        do {
            app.printMenuOptions();
            Integer option = InputOutputUtil.readOption();
            if (option != null) {
                Object selectedOptionResult = app.chooseOption(option);
                if (selectedOptionResult instanceof String) {
                    System.out.println(selectedOptionResult);
                }
            }
        } while (true);
    }
}
