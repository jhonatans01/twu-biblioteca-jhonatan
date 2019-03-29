package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.controller.RentController;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Rent;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.InputOutputUtil;

public class BookView {

    private static BookController bookController = new BookController();
    private static RentController rentController = new RentController();

    public void printBooks() {
        for (Book book : bookController.list()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void printCheckedOutBooks() {
        for (Book book : bookController.list()) {
            if (!book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public boolean checkoutBook(User user, Integer id) {
        if (user != null && id != null) {
            Book book = bookController.find(id);
            if (book != null) {
                return bookController.checkout(book) && rentController.add(new Rent(user, book));
            }
        }
        return false;
    }

    public static boolean returnBook(User user, Integer id) {
        if (user != null && id != null) {
            Book book = bookController.find(id);
            if (book != null) {
                Rent rent = rentController.find(user, book);
                if (rent != null) {
                    return bookController.returnBook(book) && rentController.returnRent(rent);
                }
            }
        }
        return false;
    }

    public Integer getCheckoutBookId() {
        System.out.print("Insert the id of the book which you want to checkout and press enter: ");
        return InputOutputUtil.readOption();
    }

    public Integer getReturnBookId() {
        System.out.print("Insert the id of the book which you want to return and press enter: ");
        return InputOutputUtil.readOption();
    }

    public String checkoutBookSuccessMessage() {
        return "Thank you!\n";
    }

    public String checkoutBookErrorMessage() {
        return "Sorry, that book is not available for return\n";
    }

    public String returnBookSuccessMessage() {
        return "Thank you! Enjoy the book\n";
    }

    public String returnBookErrorMessage() {
        return "Sorry, that book is not available\n";
    }
}
