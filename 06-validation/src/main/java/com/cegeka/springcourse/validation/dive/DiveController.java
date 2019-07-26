package com.cegeka.springcourse.validation.dive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiveController {

    @Autowired
    private DiveService diveService;

    @PostMapping
    public List<Dive> submitDives(@RequestBody List<Dive> dives) {
        return diveService.addDives(dives);
    }

    @PutMapping
    public void updateDive(@RequestBody Dive dive) {
        diveService.updateDive(dive);
    }
}
