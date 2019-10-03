package com.switchfully.author.author.book.rating;

import java.util.UUID;

public class Rating {
    private String id;
    private int scoreOutOfFive;
    private String raterName;

    public Rating(int scoreOutOfFive, String raterName) {
        this.raterName = raterName;
        this.id = UUID.randomUUID().toString();
        this.scoreOutOfFive = scoreOutOfFive;
    }

    public String getId() {
        return id;
    }

    public int getScoreOutOfFive() {
        return scoreOutOfFive;
    }

    public String getRaterName() {
        return raterName;
    }
}
