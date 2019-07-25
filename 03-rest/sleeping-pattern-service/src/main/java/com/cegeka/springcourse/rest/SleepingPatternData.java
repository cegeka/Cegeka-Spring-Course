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

    public SleepingPatternData(List<Integer> dataPoints) {
        this.id = UUID.randomUUID().toString();
        this.dataPoints = dataPoints;
        this.score = dataPoints.stream().mapToInt(dp -> dp).average().getAsDouble();
        this.extraData = dataPoints.stream().map(dp -> dp + (Math.random() * ( 100 - 10 )) ).collect(Collectors.toList());
    }

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
