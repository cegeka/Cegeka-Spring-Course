package com.cegeka.springcourse.validation.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamRegistrationController {

    @PostMapping("/register/{league}")
    public void registerTeam(TeamRegistration teamRegistration) {

    }
}
