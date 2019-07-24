package com.cegeka.springcourse.rest;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sleeping-pattern")
public class SleepingPatternController {

    private List<SleepingPatternData> sleepingPatternDataList = new ArrayList<>();

    @GetMapping("/{id}")
    public SleepingPatternData getSleepingData(@PathParam("id") String id) {
        return sleepingPatternDataList.stream().filter(data -> data.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping()
    public SleepingPatternData addSleepingData(@RequestBody SleepingPatternData sleepingPatternData) {
        sleepingPatternData.generateId();
        sleepingPatternDataList.add(sleepingPatternData);
        return sleepingPatternData;
    }

}
