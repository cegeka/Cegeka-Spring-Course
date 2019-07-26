package com.cegeka.springcourse.jms;

import java.io.Serializable;

public class BruceIsThirstyMessage implements Serializable {

    private String beverage;

    public BruceIsThirstyMessage(){}

    public BruceIsThirstyMessage(String beverage) {
        this.beverage = beverage;
    }

    public String getBeverage() {
        return beverage;
    }
}
