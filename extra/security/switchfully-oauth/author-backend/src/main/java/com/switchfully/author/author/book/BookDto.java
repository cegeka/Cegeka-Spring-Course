package com.switchfully.author.author.book;

import com.switchfully.author.author.book.rating.RatingDto;

import java.io.Serializable;
import java.util.List;

public class BookDto implements Serializable {

    private String id;
    private String name;
    private String author;
    private List<RatingDto> ratings;

    public BookDto(){}

    public String getId() {
        return id;
    }

    public BookDto withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookDto withName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookDto withAuthor(String author) {
        this.author = author;
        return this;
    }

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public BookDto withRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
        return this;
    }
}
