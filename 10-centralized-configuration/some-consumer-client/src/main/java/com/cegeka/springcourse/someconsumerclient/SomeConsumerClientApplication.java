package com.cegeka.springcourse.someconsumerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class SomeConsumerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeConsumerClientApplication.class, args);
	}

}
