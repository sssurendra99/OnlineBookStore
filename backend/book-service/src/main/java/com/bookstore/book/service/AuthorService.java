package com.bookstore.book.service;

import com.bookstore.book.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    Author save(Author author);

    Author findByUuid(UUID uuid);

    Author findByName(String name);

    List<Author> findAll();
}