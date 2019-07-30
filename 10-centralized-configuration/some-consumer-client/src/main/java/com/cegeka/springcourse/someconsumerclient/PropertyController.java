package com.cegeka.springcourse.someconsumerclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    private PropertyConfig propertyConfig;

    @GetMapping
    private String getSomeProperties() {
        return propertyConfig.getGlobalPropOne();
    }
}
