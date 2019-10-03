package com.switchfully.author.author.book;

import com.switchfully.author.author.book.rating.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book rate(Rating rating, String bookid) {
        Book book = bookRepository.findById(bookid);
        book.rate(rating);
        bookRepository.update(book);
        return book;
    }
}
