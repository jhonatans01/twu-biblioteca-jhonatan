package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    List<Book> books;

    public BookController() {
        books = new ArrayList<Book>();

        Book newBook = new Book("Book title 1", "Author 1", "2017");
        newBook.setId(1);
        books.add(newBook);

        newBook = new Book("Book title 2", "Author 2", "2018");
        newBook.setId(2);
        books.add(newBook);

        newBook = new Book("Book title 3", "Author 3", "2019");
        newBook.setId(3);
        books.add(newBook);
    }

    public Book find(Integer id) {
        Book bookToFind;
        for (Book book: books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> list() {
        return books;
    }

    public boolean checkout(Book bookToCheckout) {
        for (Book book: books) {
            if (book.getId() == bookToCheckout.getId()) {
                book.setAvailable(false);
                books.set(books.indexOf(book), book);
                return true;
            }
        }
        return false;
    }
}
