package com.cegeka.springcourse.jms;

public class Bruce {

    private boolean thirsty = true;
    private boolean bored = true;
    private String bookCurrentlyReading;

    public void giveDrink() {
        thirsty = false;
    }

    public void giveBookToRead(String bookName) {
        bookCurrentlyReading = bookName;
        bored = false;
    }

    @Override
    public String toString() {
        return "Bruce{" +
                "thirsty=" + thirsty +
                ", bored=" + bored +
                ", bookCurrentlyReading='" + bookCurrentlyReading + '\'' +
                '}';
    }
}
