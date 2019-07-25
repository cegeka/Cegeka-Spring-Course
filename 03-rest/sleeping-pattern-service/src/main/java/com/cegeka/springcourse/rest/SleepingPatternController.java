package com.cegeka.springcourse.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sleeping-pattern")
public class SleepingPatternController {

    private List<SleepingPatternData> sleepingPatternDataList = new ArrayList<>();

    @GetMapping("/{id}")
    public SleepingPatternData getSleepingData(@PathVariable("id") String id) {
        return sleepingPatternDataList.stream().filter(data -> data.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping()
    public SleepingPatternData addSleepingData(@RequestBody SleepingPatternDataInput sleepingPatternDataInput) {
        SleepingPatternData sleepingPatternData = new SleepingPatternData(sleepingPatternDataInput.getDataPoints());
        sleepingPatternDataList.add(sleepingPatternData);
        return sleepingPatternData;
    }

}
