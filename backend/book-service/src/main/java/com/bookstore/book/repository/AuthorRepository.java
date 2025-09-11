package com.bookstore.book.repository;

import com.bookstore.book.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Author findByName(String name);
}
