package com.cegeka.springcourse.jms;

import org.springframework.stereotype.Component;

@Component
public class BruceRepository {

    private Bruce bruce;

    public Bruce getBruce() {
        if(bruce == null) {
            bruce = new Bruce();
        }
        return bruce;
    }

    public Bruce updateBruce(Bruce bruce) {
        this.bruce = bruce;
        return this.bruce;
    }
}
