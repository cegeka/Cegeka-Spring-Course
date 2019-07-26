package com.cegeka.springcourse.jms;

import org.springframework.stereotype.Component;

@Component
public class BruceRepository {

    private Bruce bruce;

    public Bruce getBruce() {
        if(bruce == null) {
            System.out.println("NEW BRUCE");
            bruce = new Bruce();
        }
        return bruce;
    }

    public Bruce updateBruce(Bruce bruce) {
        this.bruce = bruce;
        System.out.println("Current state of Bruce: " + bruce.toString());
        return this.bruce;
    }
}
