package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.model.Book;

public class BibliotecaApp {

    public static String welcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static void printBooks() {
        BookController bookController = new BookController();
        for (Book book : bookController.list()) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        System.out.println(welcomeMessage());
        printBooks();
    }
}
