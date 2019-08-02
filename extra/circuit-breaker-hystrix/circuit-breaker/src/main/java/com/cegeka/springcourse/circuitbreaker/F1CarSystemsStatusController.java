package com.cegeka.springcourse.circuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class F1CarSystemsStatusController {

    @Autowired
    private SystemStatusService systemStatusService;

    @GetMapping
    public String getSystemStatus() {
        return systemStatusService.getStatusOfSystems();
    }
}
