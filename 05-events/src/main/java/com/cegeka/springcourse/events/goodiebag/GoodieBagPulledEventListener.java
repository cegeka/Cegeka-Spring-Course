package com.cegeka.springcourse.events.goodiebag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GoodieBagPulledEventListener implements ApplicationListener<GoodieBagPulledEvent> {

    @Autowired
    private GoodieBagStock goodieBagStock;

    @Override
    public void onApplicationEvent(GoodieBagPulledEvent event) {
        goodieBagStock.depleteStock(event.getGoodieBagType());
    }
}
