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
public class BookDto {
    private String uuid;
    private String title;
    private String isbn;
    private String description;
    private List<String> bookTypes;
    private double price;
    private String imageUrl;
    private List<String> authors;


    public static BookDto toBookDto(Book book) {
        return BookDto.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .description(book.getDescription())
                .bookTypes(book.getBookTypes() != null
                        ? book.getBookTypes().stream().map(Enum::name).collect(Collectors.toList())
                        : null)
                .price(book.getPrice())
                .imageUrl(book.getImageUrl())
                .authors(book.getAuthors() != null
                        ? book.getAuthors().stream().map(Author::getName).collect(Collectors.toList())
                        : null)
                .build();
    }
}
