package com.cegeka.springcourse.circuitbreaker;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SystemStatusService {



    public String getStatusOfSystems() {
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:7777/15", String.class);
        return response.getBody();
    }
}
