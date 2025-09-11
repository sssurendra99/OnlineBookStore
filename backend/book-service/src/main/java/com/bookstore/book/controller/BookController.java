package com.bookstore.book.controller;

import com.bookstore.book.dto.BookDto;
import com.bookstore.book.model.Book;
import com.bookstore.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> save(@RequestBody Book book) {
        return ResponseEntity.ok(BookDto.toBookDto(bookService.save(book)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BookDto> findByUuid(@PathVariable UUID uuid) {
        Book book = bookService.findByUuid(uuid);
        return book != null ? ResponseEntity.ok(BookDto.toBookDto(book)) : ResponseEntity.notFound().build();
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookDto> findByISBN(@PathVariable String isbn) {
        Book book = bookService.findByISBN(isbn);
        return book != null ? ResponseEntity.ok(BookDto.toBookDto(book)) : ResponseEntity.notFound().build();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<BookDto> findByTitle(@PathVariable String title) {
        Book book = bookService.findByTitle(title);
        return book != null ? ResponseEntity.ok(BookDto.toBookDto(book)) : ResponseEntity.notFound().build();
    }

    @GetMapping("/author/{authorUuid}")
    public ResponseEntity<List<BookDto>> findByAuthor(@PathVariable String authorUuid) {
        List<Book> books = bookService.findByAuthor(authorUuid);
        return ResponseEntity.ok(books.stream().map(BookDto::toBookDto).toList());
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() {
        return ResponseEntity.ok(bookService.findAll().stream().map(BookDto::toBookDto).toList());
    }
}
