package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.model.Book;

import java.util.*;

public class BibliotecaApp {

    private static BookController bookController = new BookController();


    public static String getMenuOptionErrorMessage() {
        return "Please select a valid option!";
    }

    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static List<String> getMenuOptions() {
        List<String> options = new ArrayList<String>();
        options.add("1 - List of books");
        options.add("2 - Checkout a book");
        options.add("\n0 - Exit");
        return options;
    }

    public static void printMenuOptions() {
        List<String> menuOptions = BibliotecaApp.getMenuOptions();
        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    public static Integer readOption() {
        Scanner reader = new Scanner(System.in);
        String option = reader.nextLine();
        int intOption;
        try {
            intOption = Integer.parseInt(option);
        } catch (NumberFormatException numberException) {
            System.out.println(getMenuOptionErrorMessage());
            return null;
        }
        return intOption;
    }

    public static Object chooseOption(int option) {
        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                printBooks();
                return true;
            case 2:
                return checkoutBook(getCheckoutBookId());
            default:
                return getMenuOptionErrorMessage();
        }
    }

    public static void printBooks() {
        for (Book book : bookController.list()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public static Integer getCheckoutBookId() {
        System.out.print("Insert the id of the book which you want to checkout and press enter: ");
        return readOption();
    }

    public static boolean checkoutBook(Integer id) {
        if (id != null) {
            Book book = bookController.find(id);
            if (book != null) {
                return bookController.checkout(book);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getWelcomeMessage());
        do {
            printMenuOptions();
            Integer option = readOption();
            if (option != null) {
                Object selectedOptionResult = chooseOption(option);
                if (selectedOptionResult instanceof String) {
                    System.out.println(selectedOptionResult);
                }
            }
        } while (true);
    }
}
