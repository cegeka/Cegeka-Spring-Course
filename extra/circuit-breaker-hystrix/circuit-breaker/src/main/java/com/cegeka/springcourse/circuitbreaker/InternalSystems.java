package com.cegeka.springcourse.circuitbreaker;

import org.springframework.stereotype.Component;

@Component
public class InternalSystems {

    public String getStatus() {
        return "Engine temp: OK\nTire pressure: OK\nHydraulics: WARN";
    }
}
