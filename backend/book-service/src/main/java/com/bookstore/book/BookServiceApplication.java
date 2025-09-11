package com.bookstore.book;

import com.bookstore.book.model.Author;
import com.bookstore.book.model.Book;
import com.bookstore.book.model.BookType;
import com.bookstore.book.repository.AuthorRepository;
import com.bookstore.book.repository.BookRepository;
import com.bookstore.book.utill.DbUnitDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class BookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(DbUnitDataLoader dbUnitDataLoader) {
		return args -> {
//			dbUnitDataLoader.executeDataset("demo-data/basic-data.xml");
		};
	}

}
