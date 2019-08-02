package com.cegeka.springcourse.circuitbreakerfailingserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemStatusController {

    @GetMapping("/{carid}")
    public String getStatus() {
        return "Engine temp: 96F: OK\nTire pressure: 90bar: OK\nHydraulics: 76%: WARN\nDriver vitals: WARN: Dehydration imminent";
    }
}
