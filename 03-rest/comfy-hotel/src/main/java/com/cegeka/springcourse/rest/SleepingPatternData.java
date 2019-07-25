package com.cegeka.springcourse.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SleepingPatternData implements Serializable {
    private String id;
    private List<Integer> dataPoints = new ArrayList<>();
    private List<Double> extraData = new ArrayList<>();
    private Double score;

    public SleepingPatternData() {}

    public String getId() {
        return id;
    }

    public List<Integer> getDataPoints() {
        return dataPoints;
    }

    public Double getScore() {
        return score;
    }

    public List<Double> getExtraData() {
        return extraData;
    }
}
