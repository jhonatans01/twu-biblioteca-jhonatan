package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    public List<Book> list() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Book title 1"));
        books.add(new Book("Book title 2"));
        books.add(new Book("Book title 3"));
        return books;
    }
}
