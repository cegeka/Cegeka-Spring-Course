package com.switchfully.author.author.book;

import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class BookRepository {
    private List<Book> books = newArrayList(
            new Book("The Codex of Leicester", "Leonardo Da Vinci"),
            new Book("Geographia Cosmographia", "Claudius Ptolemy"),
            new Book("On the Revolutions of the Heavenly Spheres", "Nicolaus Copernicus")
    );

    public Book save(Book book) {
        books.add(book);
        return book;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findById(String bookid) {
        return books.stream()
                .filter(book -> book.getId().equals(bookid))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book no found for id " + bookid));
    }

    public void update(Book book) {
        Book bookToUpdate = findById(book.getId());
        books.remove(bookToUpdate);
        books.add(book);
    }
}
