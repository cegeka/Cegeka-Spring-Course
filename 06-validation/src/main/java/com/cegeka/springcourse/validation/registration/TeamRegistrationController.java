package com.cegeka.springcourse.validation.registration;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Validated
public class TeamRegistrationController {

    //consumes nodig?
    @PostMapping("/register/{league}")
    public void registerTeam(@Valid @RequestBody TeamRegistration teamRegistration, @PathVariable("league") @Min(1) @Max(5)  int league) {
        System.out.println("Doing something...");
    }
}
