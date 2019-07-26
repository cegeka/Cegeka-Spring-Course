package com.cegeka.springcourse.events.goodiebag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodieBagService {

    @Autowired
    private GoodieBagManager goodieBagManager;

    public GoodieBag getRegularGoodieBag() {
        return goodieBagManager.pullRegularBagFromStock();
    }

    public GoodieBag getVipGoodieBag() {
        return goodieBagManager.pullVipBagFromStock();
    }
}
