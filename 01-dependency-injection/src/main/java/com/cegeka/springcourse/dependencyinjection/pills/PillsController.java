package com.cegeka.springcourse.dependencyinjection.pills;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PillsController {

    @GetMapping(path = "/pills")
    public String pills() {
        return "Take three of these per day during the next two weeks.";
    }
}
