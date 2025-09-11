package com.bookstore.book.repository;

import com.bookstore.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Book findByIsbn(String isbn);

    List<Book> findByAuthors_Uuid(String authorUuid);

    Book findByTitle(String title);
}
