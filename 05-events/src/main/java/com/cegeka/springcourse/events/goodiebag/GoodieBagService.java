package com.cegeka.springcourse.events.goodiebag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class GoodieBagService {

    @Autowired
    private GoodieBagManager goodieBagManager;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public GoodieBag getRegularGoodieBag() {
        GoodieBag goodieBag = goodieBagManager.pullRegularBagFromStock();
        applicationEventPublisher.publishEvent(new GoodieBagPulledEvent(this, GoodieBagType.REGULAR));
        return goodieBag;
    }

    public GoodieBag getVipGoodieBag() {
        GoodieBag goodieBag = goodieBagManager.pullVipBagFromStock();
        applicationEventPublisher.publishEvent(new GoodieBagPulledEvent(this, GoodieBagType.VIP));
        return goodieBag;
    }
}
