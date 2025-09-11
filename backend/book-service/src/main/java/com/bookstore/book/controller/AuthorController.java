package com.bookstore.book.controller;

import com.bookstore.book.dto.AuthorDto;
import com.bookstore.book.model.Author;
import com.bookstore.book.service.AuthorService;
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
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> save(@RequestBody Author author) {
        return ResponseEntity.ok(AuthorDto.toAuthorDto(authorService.save(author)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AuthorDto> findByUuid(@PathVariable UUID uuid) {
        Author author = authorService.findByUuid(uuid);
        return author != null ? ResponseEntity.ok(AuthorDto.toAuthorDto(author)) : ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<AuthorDto> findByName(@PathVariable String name) {
        Author author = authorService.findByName(name);
        return author != null ? ResponseEntity.ok(AuthorDto.toAuthorDto(author)) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> findAll() {
        return ResponseEntity.ok(authorService.findAll().stream().map(AuthorDto::toAuthorDto).toList());
    }
}
