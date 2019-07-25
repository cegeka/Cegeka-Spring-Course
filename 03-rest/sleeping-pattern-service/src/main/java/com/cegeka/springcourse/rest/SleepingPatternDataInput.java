package com.cegeka.springcourse.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SleepingPatternDataInput implements Serializable {

    private List<Integer> dataPoints = new ArrayList<>();

    public SleepingPatternDataInput(){}

    public SleepingPatternDataInput(List<Integer> dataPoints){
        this.dataPoints = dataPoints;
    }

    public List<Integer> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(List<Integer> dataPoints) {
        this.dataPoints = dataPoints;
    }
}
