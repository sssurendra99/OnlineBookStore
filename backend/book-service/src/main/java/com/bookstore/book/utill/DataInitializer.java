package com.bookstore.book.utill;

import com.bookstore.book.model.Author;
import com.bookstore.book.model.Book;
import com.bookstore.book.model.BookType;
import com.bookstore.book.repository.AuthorRepository;
import com.bookstore.book.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DataInitializer {

    @Bean
    CommandLineRunner initData(BookRepository bookRepo, AuthorRepository authorRepo) {
        return args -> {
            Author rowling = new Author();
            rowling.setName("J.K. Rowling");
            rowling.setDescription("British author of Harry Potter series");

            Author martin = new Author();
            martin.setName("George R.R. Martin");
            martin.setDescription("American author of A Song of Ice and Fire");

            Book hp1 = new Book();
            hp1.setTitle("Harry Potter and the Philosopher's Stone");
            hp1.setIsbn("9780747532699");
            hp1.setDescription("First book in the Harry Potter series");
            hp1.setPrice(19.99);
            hp1.setImageUrl("https://example.com/hp1.jpg");
            hp1.setBookTypes(Arrays.asList(BookType.PAPERBACK, BookType.EBOOK));
            hp1.setAuthors(List.of(rowling));

            Book got1 = new Book();
            got1.setTitle("A Game of Thrones");
            got1.setIsbn("9780553103540");
            got1.setDescription("First book in A Song of Ice and Fire");
            got1.setPrice(24.99);
            got1.setImageUrl("https://example.com/got1.jpg");
            got1.setBookTypes(List.of(BookType.PAPERBACK));
            got1.setAuthors(List.of(martin));

            authorRepo.saveAll(Arrays.asList(rowling, martin));
            bookRepo.saveAll(Arrays.asList(hp1, got1));
        };
    }
}

