package com.bookstore.book.service;

import com.bookstore.book.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book save(Book book);

    Book findByUuid(UUID uuid);

    Book findByISBN(String ISBN);

    List<Book> findByAuthor(String authorUUID);

    Book findByTitle(String title);

    List<Book> findAll();
}
