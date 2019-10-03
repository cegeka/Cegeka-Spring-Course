package com.switchfully.author.author.book;

import com.switchfully.author.author.book.rating.Rating;

import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;

public class Book {

    private String id;
    private String name;
    private String author;
    private List<Rating> ratings = newArrayList();

    public Book(String name, String author) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void rate(Rating rating) {
        ratings.add(rating);
    }
}
