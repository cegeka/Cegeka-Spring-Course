package com.cegeka.springcourse.filters;

import java.io.Serializable;

public class BookAndMember implements Serializable {
    private String memberName;
    private String bookName;

    public BookAndMember() {
    }

    public BookAndMember(String memberName, String bookName) {
        this.memberName = memberName;
        this.bookName = bookName;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getBookName() {
        return bookName;
    }
}
