package com.switchfully.author.author.book;

import com.switchfully.author.author.book.rating.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    private RatingMapper ratingMapper;

    public List<BookDto> mapToDto(List<Book> books) {
        return books.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> mapToDtoWithRatings(List<Book> books) {
        return books.stream()
                .map(this::mapToDtoWithRatings)
                .collect(Collectors.toList());
    }

    public BookDto mapToDto(Book book) {
        return new BookDto()
                .withId(book.getId())
                .withName(book.getName())
                .withAuthor(book.getAuthor());
    }

    public BookDto mapToDtoWithRatings(Book book) {
        return new BookDto()
                .withId(book.getId())
                .withName(book.getName())
                .withAuthor(book.getAuthor())
                .withRatings(ratingMapper.mapToDto(book.getRatings()));
    }

    public Book mapToDomain(BookDto bookDto) {
        return new Book(bookDto.getName(), bookDto.getAuthor());
    }
}
