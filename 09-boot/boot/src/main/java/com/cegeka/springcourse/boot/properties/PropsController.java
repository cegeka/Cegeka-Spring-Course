package com.cegeka.springcourse.boot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropsController {

    @Autowired
    private Environment environment;

    @Value("${warm.fluid}")
    private String fluid;
    @Value("${cold.hard}")
    public List<String> list;

    @GetMapping("/property/{key}")
    public String getProp(@PathVariable("key") String key) {
        return environment.getProperty(key);
    }
}
