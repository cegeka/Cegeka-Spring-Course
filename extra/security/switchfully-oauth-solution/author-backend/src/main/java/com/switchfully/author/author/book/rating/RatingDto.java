package com.switchfully.author.author.book.rating;

import java.io.Serializable;

public class RatingDto implements Serializable {
    private String id;
    private int scoreOutOfFive;
    private String raterName;

    public RatingDto() {
    }

    public String getId() {
        return id;
    }

    public RatingDto withId(String id) {
        this.id = id;
        return this;
    }

    public int getScoreOutOfFive() {
        return scoreOutOfFive;
    }

    public RatingDto withScoreOutOfFive(int scoreOutOfFive) {
        this.scoreOutOfFive = scoreOutOfFive;
        return this;
    }

    public String getRaterName() {
        return raterName;
    }

    public RatingDto withRaterName(String raterName) {
        this.raterName = raterName;
        return this;
    }
}
