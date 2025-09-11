package com.bookstore.book.service.impl;

import com.bookstore.book.model.Book;
import com.bookstore.book.repository.BookRepository;
import com.bookstore.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findByUuid(UUID uuid) {
        return bookRepository.findById(uuid).orElse(null);
    }

    @Override
    public Book findByISBN(String ISBN) {
        return bookRepository.findByIsbn(ISBN);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthors_Uuid(author);
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
