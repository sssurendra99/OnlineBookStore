package com.bookstore.book.dto;

import com.bookstore.book.model.Author;
import com.bookstore.book.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private String uuid;
    private String name;
    private String description;
    private List<String> books;

    public static AuthorDto toAuthorDto(Author author) {
        return AuthorDto.builder()
                .uuid(author.getUuid())
                .name(author.getName())
                .description(author.getDescription())
                .books(author.getBooks() != null
                        ? author.getBooks().stream().map(Book::getUuid).collect(Collectors.toList())
                        : null)
                .build();
    }
}
