package com.cegeka.springcourse.jms;

import java.io.Serializable;

public class BruceWantsToRead implements Serializable {

    private String book;

    public BruceWantsToRead(){}

    public BruceWantsToRead(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }
}
