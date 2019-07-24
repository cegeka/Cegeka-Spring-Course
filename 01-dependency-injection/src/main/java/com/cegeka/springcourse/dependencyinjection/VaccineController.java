package com.cegeka.springcourse.dependencyinjection;

import org.springframework.web.bind.annotation.GetMapping;

public class VaccineController {

    @GetMapping("/vaccinate")
    public String helloVaccinatedWorld() {
        return "This might sting a little";
    }
}
