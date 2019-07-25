package com.cegeka.springcourse.cache;

import java.io.Serializable;

public class Transaction implements Serializable {
    public String from;
    public String to;
    public int amountInCent;

    public Transaction(String from, String to, int amountInCent) {
        this.from = from;
        this.to = to;
        this.amountInCent = amountInCent;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getAmountInCent() {
        return amountInCent;
    }

    public void setAmountInCent(int amountInCent) {
        this.amountInCent = amountInCent;
    }
}
