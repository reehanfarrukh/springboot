package com.example.restapitest.service;

import java.util.HashSet;
import java.util.List;

import com.example.restapitest.modal.Book;

public interface BookService {
    List<Book> findAllBook();
    Book findBookByID(long id);
    void addBook(Book b);
    void deleteAllData();
}

