package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.model.Book;

import java.util.*;

public class BibliotecaApp {

    public static String getMenuOptionErrorMessage() {
        return "Please select a valid option!";
    }

    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static List<String> getMenuOptions() {
        List<String> options = new ArrayList<String>();
        options.add("1 - List of books");
        return options;
    }

    public static void printMenuOptions() {
        List<String> menuOptions = BibliotecaApp.getMenuOptions();
        for (String option: menuOptions) {
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
            case 1:
                printBooks();
                return true;
            default:
                return getMenuOptionErrorMessage();
        }
    }

    public static void printBooks() {
        BookController bookController = new BookController();
        for (Book book : bookController.list()) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        System.out.println(getWelcomeMessage());
        printMenuOptions();

        Integer option = readOption();
        if (option != null) {
            Object selectedOptionResult = chooseOption(option);
            if (selectedOptionResult instanceof String) {
                System.out.println(selectedOptionResult);
            }
        }
    }
}
