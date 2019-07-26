package com.cegeka.springcourse.events.goodiebag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodieBagController {

    @Autowired
    private GoodieBagService goodieBagService;

    @GetMapping
    public GoodieBag getRegularGoodieBag() {
        return goodieBagService.getRegularGoodieBag();
    }

    @GetMapping("/vip")
    public GoodieBag getVipGoodieBag() {
        return goodieBagService.getVipGoodieBag();
    }
}
