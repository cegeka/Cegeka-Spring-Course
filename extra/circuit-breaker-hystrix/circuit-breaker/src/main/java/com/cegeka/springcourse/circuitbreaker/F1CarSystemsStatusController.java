package com.cegeka.springcourse.circuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class F1CarSystemsStatusController {

    //dashboard: http://localhost:8080/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8080%2Factuator%2Fhystrix.stream&title=aaa

    @Autowired
    private SystemStatusService systemStatusService;

    @GetMapping("/status")
    public String getSystemStatus() {
        return systemStatusService.getStatusOfSystems();
    }
}
