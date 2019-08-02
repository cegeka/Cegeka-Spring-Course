package com.cegeka.springcourse.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SystemStatusService {

    @Autowired
    private InternalSystems internalSystems;


    @HystrixCommand(fallbackMethod = "internal")
    public String getStatusOfSystems() {
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:7777/15", String.class);
        return response.getBody();
    }

    public String internal() {
        return internalSystems.getStatus();
    }
}
