package com.switchfully.author.author.book;

import com.switchfully.author.author.book.rating.RatingDto;
import com.switchfully.author.author.book.rating.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RatingMapper ratingMapper;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<BookDto> getAll() {
        return bookMapper.mapToDto(bookService.findAll());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public BookDto save(@RequestBody BookDto bookDto) {
        Book book = bookService.save(bookMapper.mapToDomain(bookDto));
        return bookMapper.mapToDto(book);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, path = "/rate/{bookid}")
    public BookDto rate(@PathVariable("bookid") String bookid, @RequestBody RatingDto ratingDto) {
        Book book = bookService.rate(ratingMapper.mapToDomain(ratingDto), bookid);
        return bookMapper.mapToDtoWithRatings(book);
    }

    @GetMapping(path = "/rated", produces = APPLICATION_JSON_VALUE)
    public List<BookDto> getAllWithRatings() {
        return bookMapper.mapToDtoWithRatings(bookService.findAll());
    }
}
