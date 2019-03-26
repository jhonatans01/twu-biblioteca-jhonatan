package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    public List<Book> list() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Book title 1", "Author 1", "2017"));
        books.add(new Book("Book title 2", "Author 2", "2018"));
        books.add(new Book("Book title 3", "Author 3", "2019"));
        return books;
    }
}
