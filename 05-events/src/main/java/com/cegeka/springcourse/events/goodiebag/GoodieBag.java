package com.cegeka.springcourse.events.goodiebag;

import java.util.List;

public class GoodieBag {
    private List<String> goodies;

    public GoodieBag(List<String> goodies) {
        this.goodies = goodies;
    }

    public List<String> getGoodies() {
        return goodies;
    }
}
