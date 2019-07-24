package com.cegeka.springcourse.dependencyinjection;

import org.springframework.web.bind.annotation.GetMapping;

public class PillsController {

    @GetMapping(path = "/pills")
    public String pills() {
        return "Take three of these per day during the next two weeks.";
    }
}
