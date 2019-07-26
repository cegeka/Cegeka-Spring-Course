package com.cegeka.springcourse.events.goodiebag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoodieBagManager {

    @Autowired
    private GoodieBagStock goodieBagStock;

    public GoodieBag pullRegularBagFromStock() {
        List<String> goodies = new ArrayList<>();
        goodies.add(goodieBagStock.getGood("bag"));
        goodies.add(goodieBagStock.getGood("voucher"));
        goodies.add(goodieBagStock.getGood("cap"));
        return new GoodieBag(goodies);
    }

    public GoodieBag pullVipBagFromStock() {
        List<String> goodies = new ArrayList<>();
        goodies.add(goodieBagStock.getGood("bag"));
        goodies.add(goodieBagStock.getGood("voucher"));
        goodies.add(goodieBagStock.getGood("voucher"));
        goodies.add(goodieBagStock.getGood("voucher"));
        goodies.add(goodieBagStock.getGood("voucher"));
        goodies.add(goodieBagStock.getGood("voucher"));
        goodies.add(goodieBagStock.getGood("cap"));
        goodies.add(goodieBagStock.getGood("champagne"));
        goodies.add(goodieBagStock.getGood("tent"));
        return new GoodieBag(goodies);
    }
}
