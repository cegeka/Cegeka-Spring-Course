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
        addABitOfDelayForTestingPurposes();
        goodieBagStock.depleteStock(event.getGoodieBagType());
    }

    private void addABitOfDelayForTestingPurposes() {
        try {
            Thread.sleep(500);
            System.out.println("SYNC: In Listener after sleep; expecting this one first");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
