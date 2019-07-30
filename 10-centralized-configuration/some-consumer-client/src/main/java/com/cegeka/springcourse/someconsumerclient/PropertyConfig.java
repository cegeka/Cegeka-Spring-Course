package com.cegeka.springcourse.someconsumerclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RefreshScope
public class PropertyConfig {
//    To refresh: localhost:8080/actuator/refresh (POST call!)

    @Value("${global.prop.one}")
    private String globalPropOne;
    @Value("${le.premier.property}")
    private String premierProp;
    @Autowired
    private Environment environment;

    public String getGlobalPropOne() {
        return globalPropOne;
    }

    public String getPremierProp() {
        return premierProp;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
