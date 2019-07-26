package com.cegeka.springcourse.events.goodiebag;

import org.springframework.context.ApplicationEvent;

public class GoodieBagPulledEvent extends ApplicationEvent {

    private final GoodieBagType goodieBagType;

    public GoodieBagPulledEvent(Object source, GoodieBagType goodieBagType) {
        super(source);
        this.goodieBagType = goodieBagType;
    }

    public GoodieBagType getGoodieBagType() {
        return goodieBagType;
    }
}
