package com.bookstore.book.service.impl;

import com.bookstore.book.model.Author;
import com.bookstore.book.repository.AuthorRepository;
import com.bookstore.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findByUuid(UUID uuid) {
        return authorRepository.findById(uuid).orElse(null);
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}